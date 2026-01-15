package com.fastcampus.projectboard.service.article;

import com.fastcampus.projectboard.controller.article.payload.response.ArticleReadResponse;
import com.fastcampus.projectboard.enums.SearchType;
import com.fastcampus.projectboard.repository.article.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleReadResponse> getArticles(SearchType searchType, String searchKeyword) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleReadResponse getArticle(long id) {
        return null;
    }
}
