package com.javaee9.javaee9finalproject.repository;

import com.javaee9.javaee9finalproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.List;

// we need repository because we are going to read data from the database
// we create interface because Spring is going to generate for us all required methods
// Spring is going to implement that interface at runtime and provide us some object - bean
// and this bean will be managed by Spring and provide us required methods
public interface PostRepository extends JpaRepository<Post, Long> {

// Always try to filter as much as you can on database side

    // it is the same method as queryAllRecentPosts, but all logic is hidden by the Spring
    List<Post> findAllByCreationTimeStampGreaterThan(ZonedDateTime boundary);

// ---------------------------------------------------------------------------------------------------------------------
    // @Query uses names from entity not from table (JPQL feature)
    // """ - opening parameter
    // here we're like saying to Spring and Hibernate, please during the building that query, use a named parameter
    // and that named parameter is actually parameter provided in queryAllRecentPosts method (@Param("boundary")

    // if we need some complicated queries use @Query annotation and not Spring support for queries based on methods names
    @Query("""
        SELECT p
        FROM Post p
        WHERE p.creationTimeStamp >= :boundary 
    """)
    List<Post> queryAllRecentPosts(@Param("boundary")ZonedDateTime boundary);
// ---------------------------------------------------------------------------------------------------------------------


    // it's just an alias for longer method name
    default List<Post> readAllRecentPosts(ZonedDateTime boundary) {
        return findAllByCreationTimeStampGreaterThan(boundary);
    }

}
