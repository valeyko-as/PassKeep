package com.passkeep.controllers;

import com.passkeep.configs.PasswordEncryptor;
import com.passkeep.models.data.*;
import com.passkeep.models.services.*;
import com.passkeep.models.repositories.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/main")
public class AppController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordRepository passwordRepository;
    @Autowired
    private GroupService groupService;
    @Autowired
    private GroupRoleService roleService;
    @Autowired
    private PrivateFolderService privateFolderService;
    @Autowired
    private PrivateFolderDetailsService privateFolderDetailsService;
    @Autowired
    private GroupFolderService groupFolderService;
    @Autowired
    private GroupFolderDetailsService groupFolderDetailsService;

    @GetMapping
    public String mainPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.getByLogin(userDetails.getUsername());
        List<PrivateFolder> privateFolders = privateFolderService.getAllByOwnerId(user.getId());
        Group group = groupService.findUserGroups(user.getId());
        if (group != null) {
            List<GroupFolder> groupFolders = groupFolderService.getAllByOwnerId(group.getId());
            model.addAttribute("groupFolders", groupFolders);
        }
        model.addAttribute("privateFolders", privateFolders);
        model.addAttribute("group", group);

        return "main-page";
    }

    @GetMapping("/main/private/{id}")
    public String privateFolderDetailsPage(@PathVariable("id") Integer id, Model model) {
        List<PrivateFolderDetails> folderDetails = privateFolderDetailsService.getByFolder(id);
        model.addAttribute("details", folderDetails);
        return "private-details-page";
    }

    @GetMapping("/main/private/password/{id}")
    public String privatePasswordDetails(@PathVariable("id") Integer id, Model model) throws Exception {
        PrivateFolderDetails passwordDetails = privateFolderDetailsService.getById(id);
        Password password = passwordDetails.getPassword();
        String decryptedPass = PasswordEncryptor.decryptPassword(password.getPassword());
        model.addAttribute("passwordDetails", passwordDetails);
        model.addAttribute("password", decryptedPass);
        return "password-page";
    }
}
