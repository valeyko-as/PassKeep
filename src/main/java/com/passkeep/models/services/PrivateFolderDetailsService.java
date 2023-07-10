package com.passkeep.models.services;

import com.passkeep.configs.PasswordEncryptor;
import com.passkeep.models.data.PrivateFolderDetails;
import com.passkeep.models.repositories.PrivateFolderDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("PrivateFolderDetailsService")
@Transactional
public class PrivateFolderDetailsService implements FolderDetailsService<PrivateFolderDetails> {
    private final PrivateFolderDetailsRepository folderRepository;

    public PrivateFolderDetailsService(PrivateFolderDetailsRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    public PrivateFolderDetails getById(Integer id) {
        return folderRepository.getById(id);
    }

    @Override
    public List<PrivateFolderDetails> getByFolder(Integer folderId) {
        return folderRepository.findAllByFolderId(folderId);
    }

    @Override
    public PrivateFolderDetails getByName(Integer folderId, String name) {
        return folderRepository.findByName(folderId, name);
    }

    @Override
    public void add(PrivateFolderDetails folderDetails) {
        folderRepository.save(folderDetails);
    }

    public void update(Integer id, PrivateFolderDetails newDetails, String newPassword) throws Exception {
        PrivateFolderDetails details = folderRepository.findById(id).orElse(null);
        if (details != null) {
            details.setUrl(newDetails.getUrl());
            details.setName(newDetails.getName());
            details.getPassword().setPassword(PasswordEncryptor.encryptPassword(newPassword));
            folderRepository.saveAndFlush(details);
        }
    }
    @Override
    public void deleteById(Integer id) {
        folderRepository.deleteById(id);
    }
}
