package com.passkeep.services;

import com.passkeep.data.GroupEntity;
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

    public List<GroupEntity> findUserGroups(Integer id) {
        return repository.findUserGroups(id);
    }

    public GroupEntity add(GroupEntity group) {
        return repository.save(group);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
