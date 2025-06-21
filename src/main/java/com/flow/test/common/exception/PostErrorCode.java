package com.flow.test.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PostErrorCode implements ErrorCode {

    POST_NOT_FOUND(40401, "요청한 게시글을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    DUPLICATE_EXTENSION(40001, "중복된 확장자가 존재합니다.", HttpStatus.BAD_REQUEST),
    EMPTY_EXTENSION(40002, "최소 하나 이상의 확장자를 선택하거나 입력해야 합니다.", HttpStatus.BAD_REQUEST),
    TOO_MANY_EXTENSIONS(40003, "확장자는 최대 200개까지만 등록 가능합니다.", HttpStatus.BAD_REQUEST),
    INVALID_EXTENSION(40004, "유효하지 않은 확장자입니다.", HttpStatus.BAD_REQUEST),
    POST_SAVE_FAIL(50001, "게시글 저장 중 서버 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final String message;
    private final HttpStatus status;
}
