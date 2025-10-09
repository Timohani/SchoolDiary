package com.timohani.schooldiary.database.entity;

import com.timohani.schooldiary.database.entity.enums.GradeValue;
import com.timohani.schooldiary.database.entity.enums.Subject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Enumerated
    @Column(nullable = false)
    private Subject subject;

    @Enumerated
    private GradeValue value;

    @ManyToOne
    private User student;
}