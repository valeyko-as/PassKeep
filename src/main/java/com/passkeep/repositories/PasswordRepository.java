package com.passkeep.repositories;

import com.passkeep.data.PasswordEntity;
import org.springframework.data.repository.CrudRepository;

public interface PasswordRepository extends CrudRepository<PasswordEntity, Integer> {
}
