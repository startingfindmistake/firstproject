package com.example.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article; //Article 클래스 임포트 확인
import com.example.firstproject.repository.ArticleRepository;

@Controller // 컨트롤러 선언

public class ArticleController {
    @Autowired // 스프링 부트가 미리 생성해 놓은 리파지터리 객체 주입(DI)
    private ArticleRepository articleRepository;       // articleRepository 객체 선언
    @GetMapping("/articles/new")    // URL 요청 접수
    public String newArticleForm() {    // 메서드 생성 및 반환값 작성
        return "articles/new";
    }

    @PostMapping("/articles/create")    //URL 요청 접수
    public String createArticle(ArticleForm form) {     // 메서드 생성 및 반환값 작성, 폼 데이터로 DTO로 받기
        System.out.println(form.toString());        //DTO에 폼 데이터가 잘 담겼는지 확인
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        System.out.println(article.toString());     // DTO가 엔티티로 잘 변환되는지 확인 출력
        // 2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);       // article 엔티티를 저장해 saved 객체에 반환
        System.out.println(saved.toString());       // article이 DB에 잘 저장되는지 확인 출력
        return "";
    }
    
}
