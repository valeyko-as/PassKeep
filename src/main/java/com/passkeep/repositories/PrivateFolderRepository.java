package com.passkeep.repositories;

import com.passkeep.data.PrivateFolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrivateFolderRepository extends JpaRepository<PrivateFolderEntity, Integer> {

    @Query("select f from PrivateFolderEntity f join f.user u where u.id = ?1")
    List<PrivateFolderEntity> findUserFolders(Integer id);
}
