package com.timohani.schooldiary.dto.grade;

import com.timohani.schooldiary.database.entity.enums.GradeValue;
import com.timohani.schooldiary.database.entity.enums.Subject;
import lombok.Getter;

@Getter
public class GradeCreateDto {

    private Subject subject;

    private GradeValue value;

    private Long studentId;
}
