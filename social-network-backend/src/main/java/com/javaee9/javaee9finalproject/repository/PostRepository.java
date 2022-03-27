package com.javaee9.javaee9finalproject.repository;

import com.javaee9.javaee9finalproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByCreationTimestampGreaterThan(ZonedDateTime boundary);

    // @Query uses names from entity not from table (JPQL feature)
    @Query("""
        SELECT p.author
        FROM Post p
        WHERE p.creationTimeStamp >= :boundary 
""")
    List<Post> queryAllRecentPosts(@Param("boundary")ZonedDateTime boundary);

    default List<Post> readAllRecentPosts(ZonedDateTime boundary) {
        return findAllByCreationTimestampGreaterThan(boundary);
    }

}
