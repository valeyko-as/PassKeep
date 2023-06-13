package com.passkeep.models.repositories;

import com.passkeep.models.data.GroupRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRoleRepository extends JpaRepository<GroupRole, Integer> {
    @Query("select r from GroupRole r join r.groupStructure gs where gs.user.id = ?1")
    GroupRole getRoleByUserId(Integer id);

    @Query("select r from GroupRole r where r.group.id = ?1")
    List<GroupRole> getAllByGroupId(Integer id);
}
