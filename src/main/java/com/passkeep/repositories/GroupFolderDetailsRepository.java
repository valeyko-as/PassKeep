package com.passkeep.repositories;

import com.passkeep.data.GroupFolderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupFolderDetailsRepository extends JpaRepository<GroupFolderDetailsEntity, Integer> {
    @Query("select fd from GroupFolderDetailsEntity fd join fd.groupFolder f where f.id = ?1")
    List<GroupFolderDetailsEntity> findAllByFolderId(Integer id);

    @Query("select fd from GroupFolderDetailsEntity fd join fd.groupFolder f where f.id = ?1 and fd.name = ?2")
    GroupFolderDetailsEntity findByName(Integer folderId, String name);

    @Query("select fd from GroupFolderDetailsEntity fd join fd.role r where r.id = ?1")
    List<GroupFolderDetailsEntity> findAllByRoleId(Integer id);
}
