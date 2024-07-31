package com.bookmyshow.dto.response;


import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Theatre;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public @Data class TheatreResponseDto {
    private Long id;
    private String name;
    private String city;


    public TheatreResponseDto(Theatre theatre) {
        this.id = theatre.getId();
        this.name = theatre.getName();
        this.city = theatre.getCity();
    }
    public static List<TheatreResponseDto> toList(List<Theatre> theatres) {
        List<TheatreResponseDto> theatreResponseDtos = new ArrayList<>();
        for (Theatre theatre : theatres) {
            theatreResponseDtos.add(new TheatreResponseDto(theatre));
        }
        return theatreResponseDtos;
    }
}
