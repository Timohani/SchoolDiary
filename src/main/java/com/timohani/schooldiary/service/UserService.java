package com.timohani.schooldiary.service;

import com.timohani.schooldiary.database.entity.User;
import com.timohani.schooldiary.database.repository.UserRepository;
import com.timohani.schooldiary.dto.user.UserCreateDto;
import com.timohani.schooldiary.dto.user.UserReadDto;
import com.timohani.schooldiary.mapper.user.UserCreateMapper;
import com.timohani.schooldiary.mapper.user.UserReadMapper;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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

        User createdUser = userRepository.save(userCreateMapper.map(createDto));
        return userReadMapper.map(createdUser);
    }

    public UserReadDto findById(Long id) {
        String exceptionMessage = "User with id:" + id + " not found";
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(exceptionMessage));
        return userReadMapper.map(user);
    }
}
