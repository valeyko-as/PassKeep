package com.passkeep.services;

import com.passkeep.data.Group;
import com.passkeep.data.GroupRole;
import com.passkeep.data.GroupStructure;
import com.passkeep.data.User;
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

    public List<GroupStructure> getStructureByGroup(Group group) {
        return repository.findAllByGroupName(group.getName());
    }

    public List<GroupStructure> getStructureByRoleInGroup(Group group, GroupRole role) {
        return repository.findByGroupRole(group.getName(), role.getName());
    }

    public void addUserToStructure(Group group, User user, GroupRole role) {
        GroupStructure userToAdd = new GroupStructure();
        userToAdd.setGroup(group);
        userToAdd.setUser(user);
        userToAdd.setRole(role);
        repository.save(userToAdd);
    }

    public void deleteUser(GroupStructure user) {
        repository.delete(user);
    }

    public void deleteGroupStructure(Group group) {
        repository.deleteAllByGroup(group.getId());
    }
}
