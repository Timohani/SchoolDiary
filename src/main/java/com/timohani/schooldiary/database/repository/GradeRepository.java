package com.timohani.schooldiary.database.repository;

import com.timohani.schooldiary.database.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}