package com.passkeep.models.repositories;

import com.passkeep.models.data.GroupFolderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupFolderDetailsRepository extends JpaRepository<GroupFolderDetails, Integer> {
    @Query("select fd from GroupFolderDetails fd join fd.groupFolder f where f.id = ?1")
    List<GroupFolderDetails> findAllByFolderId(Integer id);

    @Query("select fd from GroupFolderDetails fd join fd.groupFolder f where f.id = ?1 and fd.name = ?2")
    GroupFolderDetails findByName(Integer folderId, String name);

    @Query("select fd from GroupFolderDetails fd join fd.role r where r.id = ?1")
    List<GroupFolderDetails> findAllByRoleId(Integer id);
}
