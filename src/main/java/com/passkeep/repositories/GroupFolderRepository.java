package com.passkeep.repositories;

import com.passkeep.data.GroupFolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupFolderRepository extends JpaRepository<GroupFolderEntity, Integer> {
    @Query("select f from GroupFolderEntity f join f.group g where g.id = ?1")
    List<GroupFolderEntity> findGroupFolders(Integer id);
}
