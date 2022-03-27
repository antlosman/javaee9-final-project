package com.javaee9.javaee9finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Clock;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; // it's a primary key
    String header;
    String content;
    String author;
    ZonedDateTime creationTimeStamp;
    ZonedDateTime updateTimeStamp; // in case we need to update/edit post

    @PrePersist
    private void setInitialTimestamp() {
        ZonedDateTime timestamp = ZonedDateTime.now(Clock.systemUTC());
        creationTimeStamp = timestamp;
        updateTimeStamp = timestamp;
    }

    @PreUpdate
    private void setUpdateTimestamp() {
        updateTimeStamp = ZonedDateTime.now(Clock.systemUTC());
    }
}
