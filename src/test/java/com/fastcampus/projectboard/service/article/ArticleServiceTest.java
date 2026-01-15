package com.fastcampus.projectboard.service.article;

import com.fastcampus.projectboard.controller.article.payload.response.ArticleReadResponse;
import com.fastcampus.projectboard.enums.SearchType;
import com.fastcampus.projectboard.repository.article.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DisplayName("비지니스 로직 - 게시글 ")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService sut;

    @Mock
    private ArticleRepository articleRepository;

    @Test
    @DisplayName("게시글 검색 시 게시글 리스트 반환")
    void given_search_parameters_when_searching_articles_then_return_article_list() {
        // Given

        // When
        Page<ArticleReadResponse> articles = sut.getArticles(SearchType.CONTENT, "");

        // Then
        assertThat(articles).isNotNull();
    }

    @Test
    @DisplayName("게시글 검색 시 게시글 반환")
    void given_search_parameters_when_searching_article_then_return_article() {
        // Given

        // When
        ArticleReadResponse article = sut.getArticle(1L);

        // Then
        assertThat(article).isNotNull();
    }
}