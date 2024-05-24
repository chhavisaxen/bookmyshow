package com.bookmyshow.controller;

import com.bookmyshow.dto.request.CreateUsersDto;
import com.bookmyshow.dto.request.UpdateUsersDto;
import com.bookmyshow.dto.response.UsersResponseDto;
import com.bookmyshow.entity.Users;
import com.bookmyshow.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/users")
public class UsersController {
    @Autowired
    public UsersService usersService;

    @GetMapping("/all")
    public ResponseEntity<List<UsersResponseDto>> getAllUsers() {
        List<Users> users = usersService.getAllUsers();
        return ResponseEntity.ok(UsersResponseDto.toList(users));
    }

    @PostMapping
    public ResponseEntity<UsersResponseDto> createUsers(@RequestBody CreateUsersDto createUsersDto) {
        Users user = usersService.createUsers(createUsersDto);
        UsersResponseDto usersResponseDto = new UsersResponseDto(user);
        return ResponseEntity.ok(usersResponseDto);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<UsersResponseDto> updateUsers(@PathVariable(name = "id") Long id, @RequestBody UpdateUsersDto updateUsersDto) {
        Users user = usersService.updateUsers(id, updateUsersDto);
        UsersResponseDto usersResponseDto = new UsersResponseDto(user);
        return ResponseEntity.ok(usersResponseDto);
    }
}
