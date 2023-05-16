package com.passkeep.repositories;

import com.passkeep.data.GroupEntity;
import com.passkeep.data.GroupRoleEntity;
import com.passkeep.data.GroupStructureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupStructureRepository extends JpaRepository<GroupStructureEntity, Integer> {
    @Query("select gs from GroupStructureEntity gs join gs.group g where g.name = ?1")
    List<GroupStructureEntity> findAllByGroupName(String groupName);

    @Query("select gs from GroupStructureEntity gs join gs.role gr join gs.group g where g.name = ?1 and gr.name = ?2")
    List<GroupStructureEntity> findByGroupRole(String name, String role);

    @Query("delete from GroupStructureEntity gs where gs.group.id =?1")
    void deleteAllByGroup(Integer id);
}
