package com.passkeep.models.repositories;

import com.passkeep.models.data.PrivateFolderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivateFolderDetailsRepository extends JpaRepository<PrivateFolderDetails, Integer> {
    @Query("select fd from PrivateFolderDetails fd join fd.folder f where f.id = ?1")
    List<PrivateFolderDetails> findAllByFolderId(Integer id);

    @Query("select fd from PrivateFolderDetails fd join fd.folder f where f.id = ?1 and fd.name = ?2")
    PrivateFolderDetails findByName(Integer folderId, String name);
}
