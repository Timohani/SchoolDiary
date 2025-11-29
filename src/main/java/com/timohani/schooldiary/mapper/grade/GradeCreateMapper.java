package com.timohani.schooldiary.mapper.grade;

import com.timohani.schooldiary.database.entity.Grade;
import com.timohani.schooldiary.database.repository.UserRepository;
import com.timohani.schooldiary.dto.grade.GradeCreateDto;
import com.timohani.schooldiary.mapper.Mapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class GradeCreateMapper implements Mapper<GradeCreateDto, Grade> {

    private final UserRepository userRepository;

    @Override
    public Grade map(GradeCreateDto from) {
        String exceptionMessage = "User with id:" + from.getStudentId() + " not found";
        return Grade.builder()
                .subject(from.getSubject())
                .value(from.getValue())
                .student(userRepository.findById(from.getStudentId()).orElseThrow(() -> new EntityNotFoundException(exceptionMessage)))
                .dateTime(LocalDateTime.now())
                .build();
    }
}
