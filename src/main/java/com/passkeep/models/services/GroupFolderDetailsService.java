package com.passkeep.models.services;

import com.passkeep.models.data.GroupFolderDetails;
import com.passkeep.models.repositories.GroupFolderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("GroupFolderDetailsService")
@Transactional
public class GroupFolderDetailsService implements FolderDetailsService<GroupFolderDetails> {
    private final GroupFolderDetailsRepository repository;

    @Autowired
    public GroupFolderDetailsService(GroupFolderDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GroupFolderDetails> getByFolder(Integer folderId) {
        return repository.findAllByFolderId(folderId);
    }

    @Override
    public GroupFolderDetails getByName(Integer folderId, String name) {
        return repository.findByName(folderId, name);
    }

    public List<GroupFolderDetails> getByGroupRole(Integer id) {
        return repository.findAllByRoleId(id);
    }

    @Override
    public void add(GroupFolderDetails groupFolderDetails) {
        repository.save(groupFolderDetails);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
