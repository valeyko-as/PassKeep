package com.passkeep.models.repositories;

import com.passkeep.models.data.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    @Query("select g from Group g join g.groupStructure gs join gs.user u where u.id = ?1")
    Group findUserGroups(Integer id);

}
