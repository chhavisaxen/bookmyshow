package com.bookmyshow.dto.request;
import lombok.Data;

public @Data class UpdateMovieDto {

    private String name;

    private Integer lengthInMinutes;

    private String description;

    private Integer ageLimit;

}