package com.passkeep.services;

import com.passkeep.data.GroupFolderDetailsEntity;
import com.passkeep.repositories.GroupFolderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("GroupFolderDetailsService")
@Transactional
public class GroupFolderDetailsService implements FolderDetailsService<GroupFolderDetailsEntity> {
    private final GroupFolderDetailsRepository repository;

    @Autowired
    public GroupFolderDetailsService(GroupFolderDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GroupFolderDetailsEntity> getByFolder(Integer folderId) {
        return repository.findAllByFolderId(folderId);
    }

    @Override
    public GroupFolderDetailsEntity getByName(Integer folderId, String name) {
        return repository.findByName(folderId, name);
    }

    public List<GroupFolderDetailsEntity> getByGroupRole(Integer id) {
        return repository.findAllByRoleId(id);
    }

    @Override
    public void add(GroupFolderDetailsEntity groupFolderDetails) {
        repository.save(groupFolderDetails);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
