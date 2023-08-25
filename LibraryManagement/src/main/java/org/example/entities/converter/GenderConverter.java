package org.example.entities.converter;

import org.example.enums.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author longnguyen on 17/08/2023
 * @project IntelliJ IDEA
 */
@Converter
public class GenderConverter implements AttributeConverter<Gender, Boolean> {

    @Override
    public Boolean convertToDatabaseColumn(Gender attribute) {
        return attribute.getValue();
    }

    @Override
    public Gender convertToEntityAttribute(Boolean dbData) {
        return dbData ? Gender.MALE : Gender.FEMALE;
    }
}
