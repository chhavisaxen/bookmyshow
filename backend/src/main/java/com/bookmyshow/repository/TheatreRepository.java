package com.bookmyshow.repository;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Long> {
    @Query(value = "select * from theatre ", nativeQuery = true)
    List<Theatre> findAll();

}

