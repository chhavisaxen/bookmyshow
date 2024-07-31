package com.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "screen")
public @Data class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCREEN_SEQ")
    @SequenceGenerator(sequenceName = "screen_id_seq", initialValue = 1, allocationSize = 1, name = "SCREEN_SEQ")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "theatre_id", referencedColumnName = "id")
    private Theatre theatre;

}