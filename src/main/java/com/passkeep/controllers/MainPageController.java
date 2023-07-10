package com.passkeep.controllers;

import com.passkeep.models.data.*;
import com.passkeep.models.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/main")
public class MainPageController {
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private PrivateFolderService privateFolderService;
    @Autowired
    private GroupFolderService groupFolderService;

    @GetMapping
    @ResponseBody
    public Model mainPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.getByLogin(userDetails.getUsername());
        List<PrivateFolder> privateFolders = privateFolderService.getAllByOwnerId(user.getId());
        Group group = groupService.findUserGroups(user.getId());
        if (group != null) {
            List<GroupFolder> groupFolders = groupFolderService.getAllByOwnerId(group.getId());
            model.addAttribute("groupFolders", groupFolders);
        }
        model.addAttribute("privateFolders", privateFolders);
        model.addAttribute("group", group);

        return model;
    }

    @PostMapping("/main/private/add")
    public ResponseEntity<Void> addPrivateFolder(@AuthenticationPrincipal UserDetails userDetails,
                                   @ModelAttribute("folder") PrivateFolder folder) {
        User user = userService.getByLogin(userDetails.getUsername());
        folder.setUser(user);
        privateFolderService.add(folder);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/main/group/add/{id}")
    public ResponseEntity<Void> addGroupFolder(@PathVariable("id") Integer id,
                                                 @ModelAttribute("folder") GroupFolder folder) {
        groupFolderService.add(folder, groupService.findById(id));
        return ResponseEntity.ok().build();
    }
}
