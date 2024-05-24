package com.bookmyshow.repository;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UsersRepository extends JpaRepository<Users, Long> {
}
