package com.flow.test.presentation;

import com.flow.test.application.PostService;
import com.flow.test.dto.PostCreateRequest;
import com.flow.test.dto.PostResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public PostResponse createPost(
            @RequestBody @Valid PostCreateRequest request
    ) {
        return postService.createPost(request);
    }
}
