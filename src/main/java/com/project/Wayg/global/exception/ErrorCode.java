package com.project.Wayg.global.exception;

import lombok.Getter;

import java.util.Arrays;
@Getter
public enum ErrorCode {
    PAGE_NOT_FOUND(404, "NotFound", "존재하지 않는 데이터입니다."),
    CATEGORY_NOT_SEARCH(400, "InvalidParams", "필수데이터 누락, 또는 형식과 다른 데이터를 요청하셨습니다."),
    KEYWORD_NOT_SEARCH(400, "InvalidParams", "필수데이터 누락, 또는 형식과 다른 데이터를 요청하셨습니다");

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    private int status;
    private String code;
    private String message;

    public static ErrorCode valueOfCode(String errorCode) {
        return Arrays.stream(values())
                .filter(value -> value.code.equals(errorCode))
                .findAny()
                .orElse(null);
    }
}