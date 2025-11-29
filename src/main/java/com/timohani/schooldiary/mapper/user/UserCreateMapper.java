package com.timohani.schooldiary.mapper.user;

import com.timohani.schooldiary.database.entity.User;
import com.timohani.schooldiary.dto.user.UserCreateDto;
import com.timohani.schooldiary.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserCreateMapper implements Mapper<UserCreateDto, User> {

    @Override
    public User map(UserCreateDto from) {
        return User.builder()
                .firstname(from.getFirstname())
                .lastname(from.getLastname())
                .role(from.getRole())
                .build();
    }

}
