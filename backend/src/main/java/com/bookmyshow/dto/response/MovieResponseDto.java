package com.bookmyshow.dto.response;
import com.bookmyshow.entity.Movie;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public @Data class MovieResponseDto {
    private Long id;

    private String name;

    private Integer lengthInMinutes;

    private String description;

    private Integer ageLimit;

    private Timestamp createdAt;

    public MovieResponseDto(Movie movie) {
        this.id = movie.getId();
        this.name = movie.getName();
        this.lengthInMinutes = movie.getLengthInMinutes();
        this.description = movie.getDescription();
        this.ageLimit = movie.getAgeLimit();
        this.createdAt = movie.getCreatedAt();
    }

    public static List<MovieResponseDto> toList(List<Movie> movies) {
        List<MovieResponseDto> movieResponseDtos = new ArrayList<>();
        for (Movie movie : movies) {
            movieResponseDtos.add(new MovieResponseDto(movie));
        }
        return movieResponseDtos;
    }

}