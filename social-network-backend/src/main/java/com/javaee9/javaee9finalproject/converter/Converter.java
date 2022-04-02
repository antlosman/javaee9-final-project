package com.javaee9.javaee9finalproject.converter;

// here DTO and ENTITY are just placeholders for classes
public interface Converter<DTO, ENTITY> {
    ENTITY fromDtoToEntity(DTO dto);
    DTO fromEntityToDto(ENTITY entity);
}
