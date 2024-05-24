package com.bookmyshow.dto.request;

import lombok.Data;

public @Data class UpdateUsersDto {


    private String firstName;

    private String lastName;

    private String gender;

    private int age;

    private String email;

    private String phone;
}
