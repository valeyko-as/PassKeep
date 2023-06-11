package com.passkeep.repositories;

import com.passkeep.data.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    @Query("select g from Group g join g.groupStructure gs join gs.user u where u.id = ?1")
    Group findUserGroups(Integer id);

}
