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

    private final PostRepository postRepository; // without this dependency PostService won't be able to read the data
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
        log.debug("result: {}", result); // by default the debug is disabled, we can activate this feature inside the application.properties
        log.info("number of read posts: [{}]", result.size());
        return result
                .stream() // stream of posts
                .map(post -> postConvertor.fromEntityToDto(post))// == .map(postConvertor::fromEntityToDto)
//                .collect(Collectors.toList());
                .toList();
        // so we're starting from the list of posts: var result List<Post>
        // changing that list to stream of posts: .stream()
        // and using a .map method (what is a hidden loop for every item which is type Post) with the help of
        // postConvertor we change every Post entity to DTO
        // and the last step .collect or .toList() - is just gathering items from the stream to the list
    }

    // receipt
    // 1. convert to entity from dto
    // 2. store entity into db
    // 3. return to client dto based on stored entity (with id and creationTimestamp and updateTimestamp)
    public PostDto createNewPost(PostDto toStore) {

//        log.info("creating new post: [{}]", toStore);
//        var entityToStore = postConvertor.fromDtoToEntity(toStore);
//        var storedEntity = postRepository.save(entityToStore);
//        var result = postConvertor.fromEntityToDto(storedEntity);
//        log.info("created post: [{}]", result);
//        return result;

        log.info("creating new post: [{}]", toStore);

        var entity = postConvertor.fromDtoToEntity(toStore);
        postRepository.save(entity);
        var result = postConvertor.fromEntityToDto(entity);

        log.info("created post: [{}]", result);
        return result;
    }
}
