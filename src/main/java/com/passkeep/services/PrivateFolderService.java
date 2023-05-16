package com.passkeep.services;

import com.passkeep.data.PrivateFolderEntity;
import com.passkeep.repositories.PrivateFolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("PrivateFolderService")
@Transactional
public class PrivateFolderService implements FolderService<PrivateFolderEntity>{
    private final PrivateFolderRepository repository;

    @Autowired
    public PrivateFolderService(PrivateFolderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PrivateFolderEntity> getAllByOwnerId(Integer ownerId) {
        return repository.findUserFolders(ownerId);
    }

    @Override
    public PrivateFolderEntity getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public PrivateFolderEntity add(PrivateFolderEntity folder) {
        return repository.saveAndFlush(folder);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public PrivateFolderEntity update(Integer id, PrivateFolderEntity updatedFolder) {
        PrivateFolderEntity folder = repository.findById(id).orElse(null);
        if (folder != null) {
            folder.setName(updatedFolder.getName());
            repository.saveAndFlush(folder);
        }
        return folder;
    }
}
