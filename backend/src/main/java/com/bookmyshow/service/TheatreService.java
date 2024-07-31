package com.bookmyshow.service;

import com.bookmyshow.dto.request.CreateMovieDto;
import com.bookmyshow.dto.request.CreateTheatreDto;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Theatre;
import com.bookmyshow.repository.TheatreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service

public class TheatreService {
    private static final Logger logger = LoggerFactory.getLogger(TheatreService.class);
    @Autowired
    private TheatreRepository theatreRepository;
    public List<Theatre> getAllTheatre() {
        return theatreRepository.findAll();
    }

      public Theatre getTheatreById(Long id) {
        logger.info("Fetching theatre by id: " + id);
        return theatreRepository.findById(id).orElseThrow(NullPointerException::new);
    }
    public Theatre createTheatre(CreateTheatreDto createTheatreDto) {
        logger.info("Creating Theatre: " + createTheatreDto.getName());
        Theatre theatre = new Theatre();
        theatre.setName(createTheatreDto.getName());
        theatre.setCity(createTheatreDto.getCity());

        return theatreRepository.save(theatre);
    }
}
