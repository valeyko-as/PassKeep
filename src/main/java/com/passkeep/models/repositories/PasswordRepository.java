package com.passkeep.models.repositories;

import com.passkeep.models.data.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Integer> {
}
