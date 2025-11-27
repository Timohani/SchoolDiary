package com.timohani.schooldiary.mapper;

import com.timohani.schooldiary.database.entity.User;
import com.timohani.schooldiary.dto.UserCreateDto;
import org.springframework.stereotype.Component;

@Component
public class UserCreateMapper implements Mapper<UserCreateDto, User> {

    @Override
    public User mapTo(UserCreateDto from) {
        return User.builder()
                .firstname(from.getFirstname())
                .lastname(from.getLastname())
                .role(from.getRole())
                .build();
    }

}
