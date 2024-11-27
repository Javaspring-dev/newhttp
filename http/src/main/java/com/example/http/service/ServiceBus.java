package com.example.http.service;

import com.example.http.model.UserEntity;
import com.example.http.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceBus {

    @Autowired
    private Repo userRepo;

    public List<UserEntity> getAllUserEntity() {
        return userRepo.findAll();
    }

    public Optional<UserEntity> getUserEntityById(int id) {
        return userRepo.findById((long) id);
    }

    public UserEntity SaveUserEntity(UserEntity userEntity) {
        return userRepo.save(userEntity); 
    }

    public boolean deleteUserEntity(int id) {
        if (Repo.existsById(id)) {
            Repo.deleteById(id);
            return true;
        }
        return false;
    }

    public UserEntity updateUserEntity(int id, UserEntity userEntity) {
        if (Repo.existsById(id)) {
            Repo.setId(id);
            return userRepo.save(userEntity);
        }
        return null;
    }
}
