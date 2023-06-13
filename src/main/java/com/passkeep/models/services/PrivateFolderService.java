package com.passkeep.models.services;

import com.passkeep.models.data.PrivateFolder;
import com.passkeep.models.repositories.PrivateFolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("PrivateFolderService")
@Transactional
public class PrivateFolderService implements FolderService<PrivateFolder>{
    private final PrivateFolderRepository repository;

    @Autowired
    public PrivateFolderService(PrivateFolderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PrivateFolder> getAllByOwnerId(Integer ownerId) {
        return repository.findUserFolders(ownerId);
    }

    @Override
    public PrivateFolder getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public PrivateFolder add(PrivateFolder folder) {
        return repository.saveAndFlush(folder);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public PrivateFolder update(Integer id, PrivateFolder updatedFolder) {
        PrivateFolder folder = repository.findById(id).orElse(null);
        if (folder != null) {
            folder.setName(updatedFolder.getName());
            repository.saveAndFlush(folder);
        }
        return folder;
    }
}
