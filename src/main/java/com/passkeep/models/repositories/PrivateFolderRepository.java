package com.passkeep.models.repositories;

import com.passkeep.models.data.PrivateFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivateFolderRepository extends JpaRepository<PrivateFolder, Integer> {

    @Query("select f from PrivateFolder f join f.user u where u.id = ?1")
    List<PrivateFolder> findUserFolders(Integer id);
}
