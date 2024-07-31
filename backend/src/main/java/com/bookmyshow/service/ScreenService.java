package com.bookmyshow.service;

import com.bookmyshow.dto.request.CreateScreenDto;
import com.bookmyshow.dto.request.UpdateScreenDto;
import com.bookmyshow.entity.Screen;
import com.bookmyshow.repository.ScreenRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ScreenService {

    private static final Logger logger = LoggerFactory.getLogger(ScreenService.class);

    @Autowired
    private ScreenRepository screenRepository;

    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    public Screen getScreenById(Long id) {
        logger.info("Fetching screen by id: " + id);
        return screenRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public Screen createScreen(CreateScreenDto createScreenDto) {
        logger.info("Creating screen: " + createScreenDto.getName());
        Screen screen = new Screen();
        screen.setName(createScreenDto.getName());

        return screenRepository.save(screen);
    }

    public void deleteScreenById(Long id) {
        if (screenRepository.existsById(id)) {
            screenRepository.deleteById(id);
            logger.info("Screen with id " + id + " deleted");
        } else {
            throw new EntityNotFoundException("Screen with id " + id + " not found");
        }
    }

    public Screen updateScreen(Long id, UpdateScreenDto updateScreenDto) {
        logger.info("Updating screen: " + updateScreenDto.getName());
        Screen screen = screenRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (updateScreenDto.getName() != null) {
            screen.setName(updateScreenDto.getName());
        }
        if (updateScreenDto.getDescription() != null) {
            screen.setDescription(updateScreenDto.getDescription());
        }
        if (updateScreenDto.getAgeLimit() != null) {
            screen.setAgeLimit(updateScreenDto.getAgeLimit());
        }
        if (updateScreenDto.getLengthInMinutes() != null) {
            screen.setLengthInMinutes(updateScreenDto.getLengthInMinutes());
        }

        return screenRepository.save(screen);
    }
}



