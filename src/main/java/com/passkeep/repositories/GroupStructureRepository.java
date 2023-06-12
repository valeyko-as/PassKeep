package com.passkeep.repositories;

import com.passkeep.data.GroupStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupStructureRepository extends JpaRepository<GroupStructure, Integer> {
    @Query("select gs from GroupStructure gs join gs.group g where g.name = ?1")
    List<GroupStructure> findAllByGroupName(String groupName);

    @Query("select gs from GroupStructure gs join gs.role gr join gs.group g where g.name = ?1 and gr.name = ?2")
    List<GroupStructure> findByGroupRole(String name, String role);

    @Query("delete from GroupStructure gs where gs.group.id =?1")
    void deleteAllByGroup(Integer id);
}
