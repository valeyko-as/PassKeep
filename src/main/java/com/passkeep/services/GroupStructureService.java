package com.passkeep.services;

import com.passkeep.data.GroupEntity;
import com.passkeep.data.GroupRoleEntity;
import com.passkeep.data.GroupStructureEntity;
import com.passkeep.data.UserEntity;
import com.passkeep.repositories.GroupStructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("GroupStructureService")
@Transactional
public class GroupStructureService {
    private final GroupStructureRepository repository;

    @Autowired
    public GroupStructureService(GroupStructureRepository repository) {
        this.repository = repository;
    }

    public List<GroupStructureEntity> getStructureByGroup(GroupEntity group) {
        return repository.findAllByGroupName(group.getName());
    }

    public List<GroupStructureEntity> getStructureByRoleInGroup(GroupEntity group, GroupRoleEntity role) {
        return repository.findByGroupRole(group.getName(), role.getName());
    }

    public void addUserToStructure(GroupEntity group, UserEntity user, GroupRoleEntity role) {
        GroupStructureEntity userToAdd = new GroupStructureEntity();
        userToAdd.setGroup(group);
        userToAdd.setUser(user);
        userToAdd.setRole(role);
        repository.save(userToAdd);
    }

    public void deleteUser(GroupStructureEntity user) {
        repository.delete(user);
    }

    public void deleteGroupStructure(GroupEntity group) {
        repository.deleteAllByGroup(group.getId());
    }
}
