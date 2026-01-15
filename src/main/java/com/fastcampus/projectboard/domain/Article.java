package com.fastcampus.projectboard.domain;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


@Getter
@Entity
@ToString
@NoArgsConstructor
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})

/**
 * 게시글 도메인
 */
public class Article extends AuditingFields {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 제목
     */
    @Setter
    @Column(nullable = false)
    private String title;

    /**
     * 내용
     */
    @Setter
    @Column(nullable = false, length = 10000)
    private String content;

    /**
     * 해시태그
     */
    @Setter
    private String hashtag;

    /**
     * 댓글 객체
     *
     * <p>
     *     Set을 사용해 중복을 제거한다.
     * </p>
     */
    @OrderBy("id")
    @ToString.Exclude
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();


    /**
     * 필드 값 지정
     *
     * @param title   제목
     * @param content 내용
     * @param hashtag 해시태그
     */
    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    /**
     * 생성자
     *
     * @param title   제목
     * @param content 내용
     * @param hashtag 해시태그
     * @return Article
     */
    public static Article of(String title, String content, String hashtag) {
        return new Article(title, content, hashtag);
    }

    /**
     * ID 로 같은 object 인지 확인
     * <p>
     * ID 가 아직 없는 엔티티는 무조건 false
     * </p>
     *
     * @param o the reference object with which to compare.
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id != null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
