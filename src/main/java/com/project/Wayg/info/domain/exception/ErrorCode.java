package com.project.Wayg.info.domain.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class ErrorCode implements EnumModel{

//        INVALID_CODE(400, "C001", "Invalid Code"),
//        RESOURCE_NOT_FOUND(204, "C002", "Resource not found"),
//        EXPIRED_CODE(400, "C003", "Expired Code"),
//
//        // AWS
//        AWS_ERROR(400, "A001", "aws client error");

        private int status;
        private String code;
        private String message;
        private String detail;

        ErrorCode(int status, String code, String message) {
            this.status = status;
            this.message = message;
            this.code = code;
        }

        @Override
        public String getKey() {
            return this.code;
        }

        @Override
        public String getValue() {
            return this.message;
        }
}
