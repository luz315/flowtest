package com.flow.test.domain.repository;

import com.flow.test.domain.entity.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository {
    Post save(Post post);
}
