package com.javaee9.javaee9finalproject.dto;

public record PostDto(Long id,
                      String header,
                      String content,
                      String author,
                      String creationTimeStamp,
                      String updateTimeStamp) {

}



