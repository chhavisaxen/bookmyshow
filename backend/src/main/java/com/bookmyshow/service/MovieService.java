package com.bookmyshow.service;

import com.bookmyshow.dto.request.CreateMovieDto;
import com.bookmyshow.dto.request.UpdateMovieDto;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        logger.info("Fetching movie by id: " + id);
        return movieRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public Movie createMovie(CreateMovieDto createMovieDto) {
        logger.info("Creating movie: " + createMovieDto.getName());
        Movie movie = new Movie();
        movie.setName(createMovieDto.getName());
        movie.setDescription(createMovieDto.getDescription());
        movie.setAgeLimit(createMovieDto.getAgeLimit());
        movie.setLengthInMinutes(createMovieDto.getLengthInMinutes());
        movie.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return movieRepository.save(movie);
    }

    public void deleteMovieById(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            logger.info("Movie with id " + id + " deleted");
        } else {
            throw new EntityNotFoundException("Movie with id " + id + " not found");
        }
    }

    public void deleteAllMovies() {
        movieRepository.deleteAll();
    }

    public Movie updateMovie(Long id, UpdateMovieDto updateMovieDto) {
        logger.info("Updating movie: " + updateMovieDto.getName());
        Movie movie = movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (updateMovieDto.getName() != null) {
            movie.setName(updateMovieDto.getName());
        }
        if (updateMovieDto.getDescription() != null) {
            movie.setDescription(updateMovieDto.getDescription());
        }
        if (updateMovieDto.getAgeLimit() != null) {
            movie.setAgeLimit(updateMovieDto.getAgeLimit());
        }
        if (updateMovieDto.getLengthInMinutes() != null) {
            movie.setLengthInMinutes(updateMovieDto.getLengthInMinutes());
        }

        return movieRepository.save(movie);
    }
}



