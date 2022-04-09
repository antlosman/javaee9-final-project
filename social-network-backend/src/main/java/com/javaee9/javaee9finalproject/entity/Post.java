package com.javaee9.javaee9finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.Clock;
import java.time.ZonedDateTime;

// expected behavior of entity is to read the object from the database and translate it to DTO
// and give it controller, so thanks to that there will be no accidental interaction with the
// database
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // without this annotation Spring doesn't know how to convert this Post class to table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; // it's a primary key
    String header;
    @NotEmpty
    @Size(min = 3, message = "Your post is too short :)")
    String content;
    @NotEmpty
    @Size(min = 3, message = "Author name is too short :)")
    String author;
    ZonedDateTime creationTimeStamp;
    ZonedDateTime updateTimeStamp; // in case we need to update/edit post

    // after we created the fields, we create an interface in frontend, model package, Post.ts

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
