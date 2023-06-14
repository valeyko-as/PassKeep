package com.passkeep.models.repositories;

import com.passkeep.models.data.GroupStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupStructureRepository extends JpaRepository<GroupStructure, Integer> {
    @Query("select gs from GroupStructure gs join gs.group g where g.id = ?1")
    List<GroupStructure> findAllByGroupId(Integer groupId);

    @Query("select gs from GroupStructure gs join gs.role gr join gs.group g where gr.id = ?2")
    List<GroupStructure> findByGroupRole(Integer roleId);

    @Query("delete from GroupStructure gs where gs.group.id =?1")
    void deleteAllByGroup(Integer id);
}
