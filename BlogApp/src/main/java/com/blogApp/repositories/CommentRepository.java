package com.blogApp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogApp.models.Comment;
import com.blogApp.models.Customer;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
    
    @Query("SELECT c FROM Customer c WHERE c.custId = :custId")
    Optional<Customer> findByCustId(@Param("custId") Integer custId);
}
