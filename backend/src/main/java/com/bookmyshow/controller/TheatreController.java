package com.bookmyshow.controller;

import com.bookmyshow.dto.request.CreateTheatreDto;
import com.bookmyshow.dto.response.TheatreResponseDto;
import com.bookmyshow.entity.Theatre;
import com.bookmyshow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")


public class TheatreController {
    @Autowired
    private TheatreService theatreService;


    @GetMapping("/all")
    public ResponseEntity<List<TheatreResponseDto>> getAllTheatre() {
        List<Theatre> theatres = theatreService.getAllTheatre();
        return ResponseEntity.ok(TheatreResponseDto.toList(theatres));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheatreResponseDto> getTheatreById(@PathVariable Long id) {
        return ResponseEntity.ok(new TheatreResponseDto(theatreService.getTheatreById(id)));

    }

    @PostMapping
    public ResponseEntity<TheatreResponseDto> createTheatre(@RequestBody CreateTheatreDto createTheatreDto) {
        Theatre theatre = theatreService.createTheatre(createTheatreDto);
        TheatreResponseDto theatreResponseDto = new TheatreResponseDto(theatre);
        return ResponseEntity.ok(theatreResponseDto);
    }
}