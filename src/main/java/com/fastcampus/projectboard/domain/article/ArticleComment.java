package com.fastcampus.projectboard.domain.article;

import com.fastcampus.projectboard.domain.common.AuditingFields;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Entity
@ToString
@NoArgsConstructor
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})

/*
    게시글 댓글 도메인
 */
public class ArticleComment extends AuditingFields {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 게시글
     */
    @Setter
    @ManyToOne(optional = false)
    private Article article;

    /**
     * 댓글 내용
     */
    @Setter
    @Column(nullable = false, length = 500)
    private String content;

    /**
     * 필드 값 지정
     *
     * @param article 게시글 도메인
     * @param content 댓글 내용
     */
    private ArticleComment(Article article, String content) {
        this.article = article;
        this.content = content;
    }

    /**
     * 생성자
     *
     * @param article 게시글 도메인
     * @param content 댓글 내용
     * @return ArticleComment
     */
    public static ArticleComment of(Article article, String content) {
        return new ArticleComment(article, content);
    }

    /**
     * 동일한 댓글 도메인 인지 확인
     *
     * @param o the reference object with which to compare.
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleComment that)) return false;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
