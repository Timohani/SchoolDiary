package com.timohani.schooldiary.mapper;

import com.timohani.schooldiary.database.entity.User;
import com.timohani.schooldiary.dto.UserReadDto;
import org.springframework.stereotype.Component;

@Component
public class UserReadMapper implements Mapper<User, UserReadDto> {

    @Override
    public UserReadDto mapTo(User from) {
        return new UserReadDto(
                from.getId(),
                from.getFirstname(),
                from.getLastname(),
                from.getRole()
        );
    }

}
