package com.bookmyshow.dto.response;

import com.bookmyshow.entity.Screen;
import com.bookmyshow.entity.Theatre;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public @Data class ScreenResponseDto {
    private Long id;

    private String name;

    private TheatreResponseDto theatre;


    public ScreenResponseDto(Screen screen, Theatre theatre) {
        this.id = screen.getId();
        this.name = screen.getName();
        this.theatre = new TheatreResponseDto(theatre);
    }

    public static List<ScreenResponseDto> toList(List<Screen> screens, Theatre theatre) {
        List<ScreenResponseDto> screenResponseDtos = new ArrayList<>();
        for (Screen screen : screens) {
            screenResponseDtos.add(new ScreenResponseDto(screen,theatre));
        }
        return screenResponseDtos;
    }

}