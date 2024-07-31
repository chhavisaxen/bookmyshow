package com.bookmyshow.controller;

import com.bookmyshow.dto.request.CreateMovieDto;
import com.bookmyshow.dto.request.UpdateMovieDto;
import com.bookmyshow.dto.response.MovieResponseDto;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.service.MovieService;
import jakarta.persistence.PostUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<MovieResponseDto>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(MovieResponseDto.toList(movies));
    }
    @GetMapping("/fetch/{id}")
    public ResponseEntity<MovieResponseDto> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(new MovieResponseDto(movieService.getMovieById(id)));

    }
    @PostMapping
    public ResponseEntity<MovieResponseDto> createMovie(@RequestBody CreateMovieDto createMovieDto) {
        Movie movie = movieService.createMovie(createMovieDto);
        MovieResponseDto movieResponseDto = new MovieResponseDto(movie);
        return ResponseEntity.ok(movieResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovieById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllMovies() {
        movieService.deleteAllMovies();
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<MovieResponseDto> updateMovie(@PathVariable Long id,@RequestBody UpdateMovieDto updateMovieDto) {
        Movie movie = movieService.updateMovie(id, updateMovieDto);
        MovieResponseDto movieResponseDto = new MovieResponseDto(movie);
        return ResponseEntity.ok(movieResponseDto);}


}