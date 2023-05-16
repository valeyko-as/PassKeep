package com.passkeep.services;

import com.passkeep.data.PrivateFolderDetailsEntity;
import com.passkeep.repositories.PasswordRepository;
import com.passkeep.repositories.PrivateFolderDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("PrivateFolderDetailsService")
@Transactional
public class PrivateFolderDetailsService implements FolderDetailsService<PrivateFolderDetailsEntity> {
    private final PrivateFolderDetailsRepository folderRepository;

    public PrivateFolderDetailsService(PrivateFolderDetailsRepository folderRepository) {
        this.folderRepository = folderRepository;
    }


    @Override
    public List<PrivateFolderDetailsEntity> getByFolder(Integer folderId) {
        return folderRepository.findAllByFolderId(folderId);
    }

    @Override
    public PrivateFolderDetailsEntity getByName(Integer folderId, String name) {
        return folderRepository.findByName(folderId, name);
    }

    @Override
    public void add(PrivateFolderDetailsEntity folderDetails) {
        folderRepository.save(folderDetails);
    }

    @Override
    public void delete(Integer id) {
        folderRepository.deleteById(id);
    }
}
