package com.flow.test.dto;

import com.flow.test.domain.entity.FileType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record PostCreateRequest(

    @NotBlank(message = "제목은 필수입니다.")
    String title,

    @NotBlank(message = "내용은 필수입니다.")
    String content,

    @Size(max = 200, message = "최대 200개의 확장자만 업로드할 수 있습니다.")
    List<@Size(max = 20, message = "확장자는 최대 20자까지 가능합니다.") String> uploadedExtensions,

    List<@Size(max = 20, message = "확장자는 최대 20자까지 가능합니다.") String> checkedTypes
) {}
