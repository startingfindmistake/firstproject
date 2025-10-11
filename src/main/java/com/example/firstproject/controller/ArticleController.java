package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.firstproject.dto.ArticleForm;

@Controller // 컨트롤러 선언

public class ArticleController {
    @GetMapping("/articles/new")    // URL 요청 접수
    public String newArticleForm() {    // 메서드 생성 및 반환값 작성
        return "articles/new";
    }

    @PostMapping("/articles/create")    //URL 요청 접수
    public String createArticle(ArticleForm form) {     // 메서드 생성 및 반환값 작성, 폼 데이터로 DTO로 받기
        System.out.println(form.toString());        //DTO에 폼 데이터가 잘 담겼는지 확인
        return "";
    }
    
}
