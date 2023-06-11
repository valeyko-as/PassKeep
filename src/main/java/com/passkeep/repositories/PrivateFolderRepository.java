package com.passkeep.repositories;

import com.passkeep.data.PrivateFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrivateFolderRepository extends JpaRepository<PrivateFolder, Integer> {

    @Query("select f from PrivateFolder f join f.user u where u.id = ?1")
    List<PrivateFolder> findUserFolders(Integer id);
}
