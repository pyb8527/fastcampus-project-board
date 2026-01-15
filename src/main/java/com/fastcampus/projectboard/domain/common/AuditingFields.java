package com.fastcampus.projectboard.domain.common;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 각 도메인 객체의 기본 정보
 */
@Getter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditingFields {

    /**
     * 생성 일시
     */
    @CreatedDate
    @Column(nullable = false, updatable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    protected LocalDateTime createdAt;

    /**
     * 생성자
     */
    @CreatedBy
    @Column(nullable = false, length = 100)
    protected String createdBy;

    /**
     * 수정 일시
     */
    @LastModifiedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime modifiedAt;

    /**
     * 수정자
     */
    @LastModifiedBy
    @Column(nullable = false, length = 100)
    protected String modifiedBy;
}
