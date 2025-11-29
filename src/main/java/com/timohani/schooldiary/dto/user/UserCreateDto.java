package com.timohani.schooldiary.dto.user;

import com.timohani.schooldiary.database.entity.enums.Role;
import lombok.Getter;

@Getter
public class UserCreateDto {

    private String username;

    private String firstname;

    private String lastname;

    private Role role;

    private String schoolClass;
}
