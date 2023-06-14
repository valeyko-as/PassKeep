package com.passkeep.models.services;

import com.passkeep.configs.PasswordEncryptor;
import com.passkeep.models.data.Password;
import com.passkeep.models.repositories.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PasswordService {
    private final PasswordRepository repository;

    @Autowired
    public PasswordService(PasswordRepository repository) {
        this.repository = repository;
    }

    public String getById(Integer id) throws Exception {
        Password password = repository.findById(id).orElseThrow();
        return PasswordEncryptor.decryptPassword(password.getPassword());
    }

    public void addPassword(String password) throws Exception {
        Password passwordToAdd = new Password();
        passwordToAdd.setPassword(PasswordEncryptor.encryptPassword(password));
        repository.saveAndFlush(passwordToAdd);
    }

    public void updatePassword(Integer passwordId, String newPassword) throws Exception {
        Password password = repository.findById(passwordId).orElseThrow();
        password.setPassword(PasswordEncryptor.encryptPassword(newPassword));
        repository.saveAndFlush(password);
    }
}
