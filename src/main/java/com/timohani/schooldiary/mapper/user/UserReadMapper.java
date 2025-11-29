package com.timohani.schooldiary.mapper.user;

import com.timohani.schooldiary.database.entity.User;
import com.timohani.schooldiary.dto.user.UserReadDto;
import com.timohani.schooldiary.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserReadMapper implements Mapper<User, UserReadDto> {

    @Override
    public UserReadDto map(User from) {
        return new UserReadDto(
                from.getId(),
                from.getFirstname(),
                from.getLastname(),
                from.getRole()
        );
    }

}
