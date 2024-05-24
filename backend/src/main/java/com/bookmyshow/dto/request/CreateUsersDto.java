package com.bookmyshow.dto.request;

import lombok.Data;

public @Data class CreateUsersDto {

    private String firstName;

    private String lastName;

    private String gender;

    private String password;

    private int age;

    private String email;

    private String phone;
}
