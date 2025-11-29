package com.timohani.schooldiary.dto.grade;

import com.timohani.schooldiary.database.entity.enums.GradeValue;
import com.timohani.schooldiary.database.entity.enums.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class GradeReadDto {

    private Long id;

    private Subject subject;

    private GradeValue value;

    private Long studentId;

    private LocalDateTime dateTime;
}
