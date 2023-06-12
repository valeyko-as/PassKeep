package com.passkeep.repositories;

import com.passkeep.data.GroupFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupFolderRepository extends JpaRepository<GroupFolder, Integer> {
    @Query("select f from GroupFolder f join f.group g where g.id = ?1")
    List<GroupFolder> findGroupFolders(Integer id);
}
