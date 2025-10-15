package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity //엔티티 선언 (이 어노테이션이 붙은 크래스를 기반으로 DB에 테이블이 생성 됩니다. 테이블 이름은 클래스 이름과 동일하게 Article로 생성됩니다.)
public class Article {
    @Id     //엔티티 대표값 지정
    @GeneratedValue     // 자동 생성 기능 추가(숫자가 자동으로 매겨짐)
    private Long id;
    @Column     // title 필드 선언, DB 테이블의 title 열과 연결됨
    private String title;
    @Column     // content 필드 선언, DB 테이블의 content 열과 연결됨
    private String content;

    //Article 생성자 추가
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // toString() 메서드 추가
    @Override
    public String toString() {
        return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
    }

    
    
}
