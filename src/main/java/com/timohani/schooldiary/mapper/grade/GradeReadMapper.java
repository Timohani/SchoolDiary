package com.timohani.schooldiary.mapper.grade;

import com.timohani.schooldiary.database.entity.Grade;
import com.timohani.schooldiary.dto.grade.GradeReadDto;
import com.timohani.schooldiary.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class GradeReadMapper implements Mapper<Grade, GradeReadDto> {

    @Override
    public GradeReadDto map(Grade from) {
        return new GradeReadDto(
                from.getId(),
                from.getSubject(),
                from.getValue(),
                from.getStudent().getId(),
                from.getDateTime()
        );
    }
}
