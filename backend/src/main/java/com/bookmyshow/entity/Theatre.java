package com.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "theatre")
public @Data class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "THEATRE_SEQ")
    @SequenceGenerator(sequenceName = "theatre_id_seq", initialValue = 1, allocationSize = 1, name = "THEATRE_SEQ")
    private Long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "city", length = 300, nullable = false)
    private String city;

}