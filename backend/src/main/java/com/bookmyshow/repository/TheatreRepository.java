package com.bookmyshow.repository;

import com.bookmyshow.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Long> {

}

