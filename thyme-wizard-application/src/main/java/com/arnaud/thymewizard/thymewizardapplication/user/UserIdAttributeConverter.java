//package com.arnaud.thymewizard.thymewizardapplication.user;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//import java.util.UUID;
//
//@Converter(autoApply = true)
//public class UserIdAttributeConverter implements AttributeConverter<UserId, String> {
//    @Override
//    public String convertToDatabaseColumn(UserId attribute) {
//        return attribute.toString();
//    }
//
//    @Override
//    public UserId convertToEntityAttribute(String dbData) {
//        return new UserId(UUID.fromString(dbData));
//    }
//}
