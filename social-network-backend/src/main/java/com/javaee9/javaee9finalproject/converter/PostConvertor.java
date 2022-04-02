package com.javaee9.javaee9finalproject.converter;

import com.javaee9.javaee9finalproject.dto.PostDto;
import com.javaee9.javaee9finalproject.entity.Post;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

// todo: possible clash with frontend date format
@Component
public class PostConvertor implements Converter<PostDto, Post> {
    @Override
    public Post fromDtoToEntity(PostDto postDto) {
        return Post.builder()
                .id(postDto.id())
                .header(postDto.header())
                .content(postDto.content())
                .author(postDto.author())
                .creationTimeStamp(ZonedDateTime.parse(postDto.creationTimeStamp()))
                .updateTimeStamp(ZonedDateTime.parse(postDto.updateTimeStamp()))
                .build();
        // thanks to that we have a @Builder annotation in the Post entity we can use build() method that
        // converts Post.builder to builder
    }

    @Override
    public PostDto fromEntityToDto(Post post) {
        return new PostDto(
                post.getId(),
                post.getHeader(),
                post.getContent(),
                post.getAuthor(),
                post.getCreationTimeStamp().toString(),
                post.getUpdateTimeStamp().toString()
                );
    }
}
