package com.passkeep.models.services;

import com.passkeep.models.data.GroupRole;
import com.passkeep.models.data.GroupStructure;
import com.passkeep.models.data.User;
import com.passkeep.models.repositories.GroupStructureRepository;
import com.passkeep.models.data.Group;
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
        return repository.findAllByGroupId(group.getId());
    }

    public List<GroupStructure> getStructureByRoleInGroup(GroupRole role) {
        return repository.findByGroupRole(role.getId());
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
