package com.passkeep.services;

import com.passkeep.data.Group;
import com.passkeep.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("GroupService")
@Transactional
public class GroupService {
    private final GroupRepository repository;

    @Autowired
    public GroupService(GroupRepository repository) {
        this.repository = repository;
    }

    public Group findUserGroups(Integer id) {
        return repository.findUserGroups(id);
    }

    public Group add(Group group) {
        return repository.save(group);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
