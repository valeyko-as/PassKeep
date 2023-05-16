package com.passkeep.repositories;

import com.passkeep.data.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<GroupEntity, Integer> {
    @Query("select g from GroupEntity g join g.groupStructure gs join gs.user u where u.id = ?1")
    List<GroupEntity> findUserGroups(Integer id);

}
