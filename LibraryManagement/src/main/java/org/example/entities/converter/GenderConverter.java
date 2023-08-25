package org.example.entities.converter;

import org.example.enums.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author longnguyen on 17/08/2023
 * @project IntelliJ IDEA
 */
@Converter
public class GenderConverter implements AttributeConverter<Gender, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Gender attribute) {
        switch (attribute){
            case MALE:
                return 1;
            case FEMALE:
                return 0;
            default:
                return null;
        }
    }

    @Override
    public Gender convertToEntityAttribute(Integer dbData) {
        switch (dbData){
            case 0:
                return Gender.FEMALE;
            case 1:
                return Gender.MALE;
            default:
                return null;
        }
    }
}
