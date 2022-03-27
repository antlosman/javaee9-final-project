package com.javaee9.javaee9finalproject.repository;

import com.javaee9.javaee9finalproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
