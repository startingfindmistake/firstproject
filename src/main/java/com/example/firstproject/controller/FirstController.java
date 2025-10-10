package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        //model 객체가 "철수" 값을 "username"에 연결해 웹 브라우저로 보냄
        model.addAttribute("username", "철수");

        return "greetings"; // greetings.mustache 파일 반환
    }

    @GetMapping("/bye") //url 요청 접수
    public String SeeYouNext(Model model) {    //메서드 작성, Model객체 받아오기
        model.addAttribute("nickname", "홍길동");   // 모델 변수 등록하기
        return "goodbye";   //goodbye.mustache 반환
    }

}
