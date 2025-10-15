package com.example.firstproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article; //Article 클래스 임포트 확인
import com.example.firstproject.repository.ArticleRepository;

import ch.qos.logback.core.model.Model;
import lombok.extern.slf4j.Slf4j;

@Slf4j      // 데이터를 확인하는 로깅 기능을 위한 어노테이션 추가
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

        log.info(form.toString()); // 아래 주석한줄 내용을 대체하는 로깅 코드 추가
        //System.out.println(form.toString());        //DTO에 폼 데이터가 잘 담겼는지 확인

        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info(article.toString());   // 아래 주석한줄 내용을 대체하는 로깅 코드 추가
        //System.out.println(article.toString());     // DTO가 엔티티로 잘 변환되는지 확인 출력

        // 2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);       // article 엔티티를 저장해 saved 객체에 반환
        log.info(saved.toString());     // 아래 주석한줄 내용을 대체하는 로깅 코드 추가
        //System.out.println(saved.toString());       // article이 DB에 잘 저장되는지 확인 출력
        return "";
    }


    
    @GetMapping("/articles/{id}") // 데이터 조회 요청 접수
    public String show(@PathVariable Long id) {     // 매개변수로 id 받아 오기
        log.info("id= " + id);  // id를 잘 받았는지 확인하는 로그 찍기

        // 1. id를 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // .orElse 설명: id 값으로 데이터를 찾을 때 해당 id 값이 없으면 null을 반환해라
        // 2. 모델에 데이터 등록하기
        // 3. 뷰 페이지 반환하기


        return "";

    //@PathVariable은 URL 요청으로 들어온 전달값을 컨트롤러의 매개변수로 가져오는 어노테이션
    }
}
