package com.javaee9.javaee9finalproject.converter;

import com.javaee9.javaee9finalproject.dto.PostDto;
import com.javaee9.javaee9finalproject.entity.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Clock;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostConvertorTest {

    @Autowired
    PostConvertor postConvertor;

    @Test
    void fromDtoToEntity() {
        // 2022-03-27T10:47:11.913791600Z
        ZonedDateTime now = ZonedDateTime.now(Clock.systemUTC());
        System.out.println("time now is: " + now);
        ZonedDateTime creationTimeStamp = ZonedDateTime.now(Clock.systemUTC());
        ZonedDateTime updateTimeStamp = ZonedDateTime.now(Clock.systemUTC());
        PostDto dto = new PostDto(1L,
                "my header",
                "long content",
                "just me",
                creationTimeStamp.toString(),
                updateTimeStamp.toString()
                );
        Post entity = postConvertor.fromDtoToEntity(dto);

        Assertions.assertEquals(dto.header(), entity.getHeader());
        Assertions.assertEquals(creationTimeStamp, entity.getCreationTimeStamp());
    }

    @Test
    void fromEntityToDto() {
    }
}