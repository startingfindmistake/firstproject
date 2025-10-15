package com.example.firstproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.firstproject.entity.Article;


//Article: 관리 대상 엔티티의 클래스 타입
// Long: 관리 대상 엔티티의 대푯값 타입
public interface ArticleRepository extends CrudRepository<Article, Long>{

}
