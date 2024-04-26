package com.example.UserServiceApp.repository;

import com.example.UserServiceApp.model.Usermodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usermodel,Long> {

    @Override
    Usermodel save(Usermodel user);

    @Override
    Optional<Usermodel> findById(Long id);

    Optional<Usermodel> findByEmailID(String emailID);
}