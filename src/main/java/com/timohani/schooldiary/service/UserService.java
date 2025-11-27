package com.timohani.schooldiary.service;

import com.timohani.schooldiary.database.entity.User;
import com.timohani.schooldiary.database.repository.UserRepository;
import com.timohani.schooldiary.dto.UserCreateDto;
import com.timohani.schooldiary.dto.UserReadDto;
import com.timohani.schooldiary.mapper.UserCreateMapper;
import com.timohani.schooldiary.mapper.UserReadMapper;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserCreateMapper userCreateMapper;
    private final UserReadMapper userReadMapper;

    public UserReadDto createUser(UserCreateDto createDto) {

        if (userRepository.findByFirstnameAndLastname(createDto.getFirstname(), createDto.getLastname()).isPresent()) {
            String exceptionMessage = "User with firstname:" + createDto.getFirstname() + " and lastname: " + createDto.getLastname() + " already exists.";
            throw new EntityExistsException(exceptionMessage);
        }

        User createdUser = userRepository.save(userCreateMapper.mapTo(createDto));
        return userReadMapper.mapTo(createdUser);
    }
}
