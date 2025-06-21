package com.flow.test.presentation;

import com.flow.test.application.PostService;
import com.flow.test.dto.PostCreateRequest;
import com.flow.test.dto.PostResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
@Tag(name = "게시글", description = "게시글 관련 API")
public class PostController {

    private final PostService postService;

    @PostMapping
    @Operation(summary = "게시글 생성", description = "게시글과 파일 확장자 목록을 저장합니다.")
    @ApiResponse(responseCode = "200", description = "등록 성공")
    public PostResponse createPost(
            @RequestBody @Valid PostCreateRequest request
    ) {
        return postService.createPost(request);
    }
}
