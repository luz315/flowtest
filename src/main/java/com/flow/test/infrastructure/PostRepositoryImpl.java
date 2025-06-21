package com.flow.test.infrastructure;

import com.flow.test.domain.entity.Post;
import com.flow.test.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostJpaRepository postJpaRepository;

    @Override
    public Post save(Post news) {
        return postJpaRepository.save(news);
    }

}
