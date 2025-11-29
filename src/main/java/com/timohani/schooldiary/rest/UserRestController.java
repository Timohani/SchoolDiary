package com.timohani.schooldiary.rest;

import com.timohani.schooldiary.dto.user.UserCreateDto;
import com.timohani.schooldiary.dto.user.UserReadDto;
import com.timohani.schooldiary.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "Users", description = "API для работы с пользователями")
public class UserRestController {

    private final UserService userService;

    @Operation(summary = "Создать пользователя")
    @ApiResponse(responseCode = "201", description = "Пользователь создан")
    @ApiResponse(responseCode = "400", description = "Пользователь уже существует")
    @PostMapping
    public ResponseEntity<UserReadDto> createUser(@RequestBody UserCreateDto createDto) {
        UserReadDto savedUser;
        try {
            savedUser = userService.createUser(createDto);
        } catch (EntityExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @Operation(summary = "Получить ученика по ID")
    @ApiResponse(responseCode = "200", description = "Ученик найден")
    @ApiResponse(responseCode = "404", description = "Ученик не найден")
    @GetMapping("/id/{id}")
    public ResponseEntity<UserReadDto> findUserById(@PathVariable Long id) {
        UserReadDto savedUser;
        try {
            savedUser = userService.findById(id);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(savedUser);
    }

    @Operation(summary = "Получить пользователя по username")
    @ApiResponse(responseCode = "200", description = "Пользователь найден")
    @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    @GetMapping("/{username}")
    public ResponseEntity<UserReadDto> findUserByUsername(@PathVariable String username) {
        UserReadDto savedUser;
        try {
            savedUser = userService.findByUsername(username);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(savedUser);
    }

    @Operation(summary = "Получить всех студентов в классе")
    @ApiResponse(responseCode = "200", description = "Студенты найдены")
    @GetMapping("/class/{schoolClass}")
    public ResponseEntity<List<UserReadDto>> findAllBySchoolClass(@PathVariable String schoolClass) {
        List<UserReadDto> savedList = userService.findAllBySchoolClass(schoolClass);

        return ResponseEntity.ok(savedList);
    }
}
