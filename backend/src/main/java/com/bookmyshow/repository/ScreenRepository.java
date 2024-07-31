package com.bookmyshow.repository;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from screen where id = :id", nativeQuery = true)
    void deleteById(Long id);

}
