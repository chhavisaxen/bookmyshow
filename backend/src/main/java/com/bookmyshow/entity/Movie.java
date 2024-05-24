package com.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "movies")
public @Data class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVIES_SEQ")
    @SequenceGenerator(sequenceName = "movies_id_seq", initialValue = 1, allocationSize = 1, name = "MOVIES_SEQ")
    private Long id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "length_in_minutes")
    private Integer lengthInMinutes;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "age_limit")
    private Integer ageLimit;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

}