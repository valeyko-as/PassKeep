package com.passkeep.models.services;

import com.passkeep.models.data.Group;
import com.passkeep.models.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("GroupService")
@Transactional
public class GroupService {
    private final GroupRepository repository;

    @Autowired
    public GroupService(GroupRepository repository) {
        this.repository = repository;
    }

    public Group findById(Integer id) {
        return repository.findById(id).orElseThrow();
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
