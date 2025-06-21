package com.flow.test.dto;

import com.flow.test.domain.entity.File;
import com.flow.test.domain.entity.Post;

import java.util.List;

public record PostResponse(
    Long id,
    String title,
    String content,
    List<String> fixedExtensions,
    List<String> customExtensions
) {

    public static PostResponse from(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getFileList().stream()
                        .filter(File::isFixed)
                        .map(File::getExtension)
                        .toList(),
                post.getFileList().stream()
                        .filter(file -> !file.isFixed())
                        .map(File::getExtension)
                        .toList()
        );
    }
}
