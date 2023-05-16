package com.passkeep.services;

import com.passkeep.data.GroupFolderEntity;
import com.passkeep.repositories.GroupFolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("GroupFolderService")
@Transactional
public class GroupFolderService implements FolderService<GroupFolderEntity> {
    private final GroupFolderRepository repository;

    @Autowired
    public GroupFolderService(GroupFolderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GroupFolderEntity> getAllByOwnerId(Integer ownerId) {
        return repository.findGroupFolders(ownerId);
    }

    @Override
    public GroupFolderEntity getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public GroupFolderEntity update(Integer id, GroupFolderEntity updatedFolder) {
        GroupFolderEntity folder = repository.findById(id).orElse(null);
        if (folder != null) {
            folder.setName(updatedFolder.getName());
            repository.saveAndFlush(folder);
        }
        return folder;
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
