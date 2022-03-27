package com.javaee9.javaee9finalproject.controller;

import com.javaee9.javaee9finalproject.entity.Post;
import com.javaee9.javaee9finalproject.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/post")
public class PostController {

    // providing dependency
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    //-----------------------------------------------------

    // /readRecentPosts - never every!!!!
    // /post?boundary= vs /posts/resent
    @GetMapping("/recent")
    public List<Post> readRecentPosts() {
        log.info("reading recent posts");
        return postService.readRecentPosts();
    }
}
