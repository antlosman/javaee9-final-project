package com.javaee9.javaee9finalproject.controller;

import com.javaee9.javaee9finalproject.dto.PostDto;
import com.javaee9.javaee9finalproject.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/post")
public class PostController {

    //-----------------------------------------------------
    // providing dependency
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    //-----------------------------------------------------

    // /readRecentPosts - never every!!!!
    // /post?boundary= vs /posts/resent
    @GetMapping("/recent")
    // we shouldn't use entities inside the controller, because there could be some changes in the entity during the
    // transaction, that's why we use DTO
    // From the controller perspective there should be a data, but it does not need to know where data comes from.
    // So when we just return the Post to the controller, controller has a list of the posts, so the controller knows
    // that it is an entity, and it comes from the database. That's why we should use some kind of abstraction,
    // because if we want to use data not from the database, but for example from other service from the file, it will
    // be hard to change the source of the data, and it will be much easier to do it with dto - this is the primary
    // reason why we use dto instead of entity
    public List<PostDto> readRecentPosts() {
        log.info("reading recent posts");
        return postService.readRecentPosts();
    }

    // this is just an example why whe need to use converter
    @GetMapping("recent/{id}")
    public PostDto findPostById(@PathVariable("id") Long postId) {
        // todo: finish implementation
        // 1. read Post by id form database
        // 2. convert Post ingo PostDto
        // 3. return to user
        return null;
    }
}
