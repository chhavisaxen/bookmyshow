package com.bookmyshow.enums;


import com.fasterxml.jackson.annotation.JsonCreator;

public enum ShowDisplayType {

    TWO_D(1L, "2D"),
    THREE_D(2L, "3D"),
    FOUR_DX(3L, "4DX");

    private final Long id;
    private final String value;

    ShowDisplayType(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Long getId() { return id; }

    @JsonCreator
    public static ShowDisplayType fromText(String text) {
        return ShowDisplayType.valueOf(text.toUpperCase());
    }

    public static ShowDisplayType fromId(Long id) {
        for (ShowDisplayType subscriptionType : ShowDisplayType.values()) {
            if (subscriptionType.getId().equals(id)) {
                return subscriptionType;
            }
        }
        return null;
    }
}