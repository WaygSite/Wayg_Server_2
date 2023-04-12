package com.project.Wayg.Entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RequestDTO {
    @Schema(description = "keyword", example = "string")
    private String keyword;
}
