package com.timohani.schooldiary.dto;

import com.timohani.schooldiary.database.entity.enums.Role;
import lombok.Getter;

@Getter
public class UserCreateDto {

    private String firstname;

    private String lastname;

    private Role role;
}
