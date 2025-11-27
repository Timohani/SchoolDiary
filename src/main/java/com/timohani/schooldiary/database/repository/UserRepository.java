package com.timohani.schooldiary.database.repository;

import com.timohani.schooldiary.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByFirstnameAndLastname(String firstname, String lastname);
}