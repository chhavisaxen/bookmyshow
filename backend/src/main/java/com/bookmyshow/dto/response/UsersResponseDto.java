package com.bookmyshow.dto.response;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Users;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public @Data class UsersResponseDto {
    private Long id;

    private String first_name;

    private String last_name;

    private String gender;

//    Password password;

    private Integer age;

    private String email;

    private String phone;

    private Timestamp createdAt;

    public UsersResponseDto(Users users) {
        this.id = users.getId();
        this.first_name = users.getFirst_name();
        this.last_name = users.getLast_name();
        this.gender = users.getGender();
        this.age = users.getAge();
        this.email = users.getEmail();
        this.createdAt = users.getCreatedAt();
    }
    public static List<UsersResponseDto> toList(List<Users> users) {
        List<UsersResponseDto> usersResponseDtos = new ArrayList<>();
        for (Users user : users) {
            usersResponseDtos.add(new UsersResponseDto(user));
        }
        return usersResponseDtos;
    }

}
