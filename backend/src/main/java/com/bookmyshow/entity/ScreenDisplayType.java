package com.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "screen_display_type")
public @Data class ScreenDisplayType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCREEN_DISPLAY_TYPE_SEQ")
    @SequenceGenerator(sequenceName = "screen_display_type_id_seq", initialValue = 1, allocationSize = 1, name = "SCREEN_DISPLAY_TYPE_SEQ")
    private Long id;

    private Long screenId;

    private Long displayTypeId;
}