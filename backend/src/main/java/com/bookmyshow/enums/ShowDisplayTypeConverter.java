package com.bookmyshow.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ShowDisplayTypeConverter implements AttributeConverter<ShowDisplayType, Long> {
    @Override
    public Long convertToDatabaseColumn(ShowDisplayType type) {
        if (type == null) {
            return null;

        }
        return type.getId();
    }

    @Override
    public ShowDisplayType convertToEntityAttribute(Long data) {
        if (data == null) {
            return null;
        }
        return ShowDisplayType.fromId(data);
    }
}
