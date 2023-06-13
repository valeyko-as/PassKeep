package com.passkeep.models.services;

import com.passkeep.models.repositories.GroupRoleRepository;
import com.passkeep.models.data.GroupRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("GroupRoleService")
@Transactional
public class GroupRoleService {
    private final GroupRoleRepository repository;

    @Autowired
    public GroupRoleService(GroupRoleRepository repository) {
        this.repository = repository;
    }

    public List<GroupRole> getGroupRoles(Integer groupId) {
        return repository.getAllByGroupId(groupId);
    }

    public GroupRole getUserRole(Integer userId) {
        return repository.getRoleByUserId(userId);
    }

    public void add(GroupRole role) {
        repository.save(role);
    }

    public void delete(Integer id) { //TODO
        repository.deleteById(id);
    }
}
