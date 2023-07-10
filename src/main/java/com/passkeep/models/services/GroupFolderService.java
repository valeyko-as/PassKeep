package com.passkeep.models.services;

import com.passkeep.models.data.Group;
import com.passkeep.models.data.GroupFolder;
import com.passkeep.models.repositories.GroupFolderRepository;
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

    public void add(GroupFolder newFolder, Group group) {
        newFolder.setGroup(group);
        repository.saveAndFlush(newFolder);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
