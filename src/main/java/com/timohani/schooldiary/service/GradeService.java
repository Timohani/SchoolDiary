package com.timohani.schooldiary.service;

import com.timohani.schooldiary.database.entity.Grade;
import com.timohani.schooldiary.database.repository.GradeRepository;
import com.timohani.schooldiary.dto.grade.GradeCreateDto;
import com.timohani.schooldiary.dto.grade.GradeReadDto;
import com.timohani.schooldiary.mapper.grade.GradeCreateMapper;
import com.timohani.schooldiary.mapper.grade.GradeReadMapper;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;
    private final GradeCreateMapper gradeCreateMapper;
    private final GradeReadMapper gradeReadMapper;

    public GradeReadDto addGrade(GradeCreateDto createDto) {

        Grade grade = gradeCreateMapper.map(createDto);
        if (gradeRepository.findByDateTime(grade.getDateTime()).isPresent()) {
            String exceptionMessage = "This grade already exists.";
            throw new EntityExistsException(exceptionMessage);
        }

        Grade createdGrade = gradeRepository.save(grade);
        return gradeReadMapper.map(createdGrade);
    }
}
