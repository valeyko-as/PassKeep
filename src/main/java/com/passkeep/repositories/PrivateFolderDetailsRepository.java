package com.passkeep.repositories;

import com.passkeep.data.PrivateFolderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrivateFolderDetailsRepository extends JpaRepository<PrivateFolderDetailsEntity, Integer> {
    @Query("select fd from PrivateFolderDetailsEntity fd join fd.folder f where f.id = ?1")
    List<PrivateFolderDetailsEntity> findAllByFolderId(Integer id);

    @Query("select fd from PrivateFolderDetailsEntity fd join fd.folder f where f.id = ?1 and fd.name = ?2")
    PrivateFolderDetailsEntity findByName(Integer folderId, String name);
}
