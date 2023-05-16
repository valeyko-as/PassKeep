package com.passkeep.repositories;

import com.passkeep.data.GroupRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRoleRepository extends JpaRepository<GroupRoleEntity, Integer> {
    @Query("select r from GroupRoleEntity r join r.groupStructure gs where gs.user.id = ?1")
    GroupRoleEntity getRoleByUserId(Integer id);

    @Query("select r from GroupRoleEntity r where r.group.id = ?1")
    List<GroupRoleEntity> getAllByGroupId(Integer id);
}
