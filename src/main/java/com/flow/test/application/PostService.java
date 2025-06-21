package com.flow.test.application;

import com.flow.test.dto.PostCreateRequest;
import com.flow.test.domain.entity.File;
import com.flow.test.domain.entity.Post;
import com.flow.test.domain.repository.PostRepository;
import com.flow.test.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {private final PostRepository postRepository;
    private final FileService fileService;

    public PostResponse createPost(PostCreateRequest request) {

        Post post = Post.create(request.title(), request.content());

        List<File> files = fileService.createFiles(
                post,
                request.uploadedExtensions(),
                request.checkedTypes()
        );
        post.addFile(files);

        postRepository.save(post);
        return PostResponse.from(post);
    }
}
