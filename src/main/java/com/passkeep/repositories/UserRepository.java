package com.passkeep.repositories;

import com.passkeep.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query("select u from UserEntity u where u.login = ?1")
    UserEntity findByLogin(String login);
}
