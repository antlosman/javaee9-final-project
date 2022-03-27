package com.javaee9.javaee9finalproject.converter;

public interface Converter<DTO, ENTITY> {
    ENTITY fromDtoToEntity(DTO dto);
    DTO fromEntityToDto(ENTITY entity);
}
