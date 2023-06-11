package com.passkeep.services;

import com.passkeep.data.GroupFolder;
import com.passkeep.repositories.GroupFolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("GroupFolderService")
@Transactional
public class GroupFolderService implements FolderService<GroupFolder> {
    private final GroupFolderRepository repository;

    @Autowired
    public GroupFolderService(GroupFolderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GroupFolder> getAllByOwnerId(Integer ownerId) {
        return repository.findGroupFolders(ownerId);
    }

    @Override
    public GroupFolder getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public GroupFolder update(Integer id, GroupFolder updatedFolder) {
        GroupFolder folder = repository.findById(id).orElse(null);
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
