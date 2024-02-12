package com.preOrder.api.repository;

import com.preOrder.api.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
//    Optional<ArrayList<Post>> findAllById(Long id);
    Optional<ArrayList<Post>> findAllByAuthorId(Long authorId);
}
