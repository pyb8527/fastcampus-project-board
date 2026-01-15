package com.fastcampus.projectboard.controller.article.payload.response;

import java.io.Serializable;
import java.time.LocalDateTime;


public record ArticleReadResponse(
        LocalDateTime createdAt,
        String createdBy,
        String title,
        String content,
        String hashTag
) implements Serializable {

    public static ArticleReadResponse of(
            LocalDateTime createdAt,
            String createdBy,
            String title,
            String content,
            String hashTag
    ) {
        return new ArticleReadResponse(createdAt, createdBy, title, content, hashTag);
    }
}
