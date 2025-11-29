package com.timohani.schooldiary.dto.user;

import com.timohani.schooldiary.database.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserReadDto {

    private Long id;

    private String firstname;

    private String lastname;

    private Role role;
}
