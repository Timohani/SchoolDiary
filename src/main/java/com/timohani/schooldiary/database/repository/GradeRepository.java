package com.timohani.schooldiary.database.repository;

import com.timohani.schooldiary.database.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    Optional<Grade> findByDateTime(LocalDateTime localDateTime);
}