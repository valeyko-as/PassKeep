package com.passkeep.services;

import com.passkeep.data.PrivateFolderDetails;
import com.passkeep.repositories.PrivateFolderDetailsRepository;
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

    @Override
    public void delete(Integer id) {
        folderRepository.deleteById(id);
    }
}
