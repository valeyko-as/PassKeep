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
@RequestMapping(path = "/private")
public class PrivateFolderController {
    @Autowired
    private PasswordService passwordService;
    @Autowired
    private PrivateFolderDetailsService privateFolderDetailsService;

    @GetMapping("/private/{id}")
    @ResponseBody
    public Model privateFolderDetailsPage(@PathVariable("id") Integer id, Model model) {
        List<PrivateFolderDetails> folderDetails = privateFolderDetailsService.getByFolder(id);
        model.addAttribute("details", folderDetails);
        return model;
    }

    @GetMapping("/private/password/{id}")
    @ResponseBody
    public Model privatePasswordDetails(@PathVariable("id") Integer id, Model model) throws Exception {
        PrivateFolderDetails passwordDetails = privateFolderDetailsService.getById(id);
        String decryptedPass = passwordService.getById(passwordDetails.getPassword().getId());
        model.addAttribute("passwordDetails", passwordDetails);
        model.addAttribute("password", decryptedPass);
        return model;
    }

    @PutMapping("/private/password/{id}/update")
    public ResponseEntity<Void> updatePrivatePasswordDetails(@PathVariable("id") Integer id,
                                                             @ModelAttribute("details") PrivateFolderDetails newDetails,
                                                             @ModelAttribute("password") String newPassword) throws Exception {
        privateFolderDetailsService.update(id, newDetails, newPassword);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> addPassword(@PathVariable("id") Integer id,
                                            @ModelAttribute("details") PrivateFolderDetails newDetails,
                                            @ModelAttribute("password") String newPassword) throws Exception {
        Password password = passwordService.addPassword(newPassword);
        newDetails.setPassword(password);
        privateFolderDetailsService.add(newDetails);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/private/password/{id}/delete")
    public ResponseEntity<Void> deletePrivatePassword(@PathVariable("id") Integer id) {
        passwordService.deleteById(privateFolderDetailsService.getById(id).getPassword().getId());
        privateFolderDetailsService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
