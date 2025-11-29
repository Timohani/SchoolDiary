package com.timohani.schooldiary.database.repository;

import com.timohani.schooldiary.database.entity.User;
import com.timohani.schooldiary.database.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByFirstnameAndLastname(String firstname, String lastname);
    List<User> findAllByRoleAndSchoolClass(Role role, String schoolClass);
    Optional<User> findByUsername(String username);
}