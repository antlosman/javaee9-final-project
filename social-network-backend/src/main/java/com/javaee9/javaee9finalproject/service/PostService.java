package com.javaee9.javaee9finalproject.service;

import com.javaee9.javaee9finalproject.converter.PostConvertor;
import com.javaee9.javaee9finalproject.dto.PostDto;
import com.javaee9.javaee9finalproject.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final PostConvertor postConvertor;

    public PostService(PostRepository postRepository, PostConvertor postConvertor) {
        this.postRepository = postRepository;
        this.postConvertor = postConvertor;
    }

    // TODO
    // migrate to dto
    // use exception handler for dealing internal issues

    public List<PostDto> readRecentPosts() {
        // 1. read all records - filter based on creation timestamp - this approach is not very good because we need to
        // read a lot of data
        // 2. create boundary timestamp - in Java
        ZonedDateTime boundary = ZonedDateTime.now(Clock.systemUTC()).minusDays(1);
        // 2. ask database of posts created after that boundary
        return readRecentPosts(boundary);
    }

    public List<PostDto> readRecentPosts(ZonedDateTime boundary) {
        var result = postRepository.queryAllRecentPosts(boundary);
        log.debug("result: {}", result);
        log.info("number of read posts: [{}]", result.size());
        return result
                .stream()
                .map(post -> postConvertor.fromEntityToDto(post))// == .map(postConvertor::fromEntityToDto)
                .collect(Collectors.toList());
    }
}
