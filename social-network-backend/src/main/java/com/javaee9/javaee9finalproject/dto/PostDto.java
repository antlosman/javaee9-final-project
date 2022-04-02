package com.javaee9.javaee9finalproject.dto;

import java.time.ZonedDateTime;

// when we create DTO don't need to use all the fields from entity, but if in the future we need to convert dto to entity
// there could be a problem, as not all the fields represented
public record PostDto(Long id,
                      String header,
                      String content,
                      String author,
//                      ZonedDateTime creationTimeStamp,
                      String creationTimeStamp, // we can use String instead because it will be sent as a JSON
                      // and all the fields inside the JSON are strings and numbers
                      String updateTimeStamp) {

}

// From the perspective of the controller, this class is just a data and string is just a set of characters.



