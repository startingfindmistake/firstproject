package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private String title;       // 제목을 받을 필드
    private String content;     // 내용을 받을 필드

    //전송 받은 제목과 내용을 필드에 저장하는 생성자 추가

    /*
     *  1. 생성자(Constructor) 만들기
    VS Code에서는 '빠른 수정(Quick Fix)' 또는 '소스 작업(Source Action)' 기능을 사용합니다.

    ArticleForm 클래스 내부의 빈 공간에 마우스 커서를 놓거나, 클래스 이름(public class ArticleForm)을 클릭합니다.

    왼쪽에 전구(💡) 아이콘이 나타나면 클릭합니다. (또는 단축키 Ctrl + .)

    나타나는 메뉴에서 **'Generate constructor...'**를 선택합니다.

    책의 그림처럼 생성자에 포함할 멤버 변수(title, content)를 선택하는 창이 나타납니다. 원하는 변수를 체크하고 OK를 누르면 코드가 자동으로 완성됩니다
     */

    /*  아래 내용을 @AllArgsConstructor
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }
    */

    // 데이터를 잘 받았는지 확인할 toString() 메서드 추가

    /*
    마찬가지로 클래스 내부의 빈 공간을 마우스 오른쪽 버튼으로 클릭합니다.

    메뉴에서 '소스 작업(Source Action...)'을 선택합니다. (전구 아이콘을 사용해도 됩니다.)

    나타나는 메뉴에서 'Generate toString()...'을 선택합니다.

    toString() 메서드에 포함할 필드를 선택하고 OK를 누르면 코드가 자동으로 추가됩니다
     */



     /* ToString 롬복으로 새 어노테이션 추가로 인해 주석 가능
    @Override
    public String toString() {
        return "ArticleForm [title=" + title + ", content=" + content + ", toString()=" + super.toString() + "]";
    }
    */


    public Article toEntity() {
        // 전달값은 Article 클래스의 생성자 형식에 맞게 작성하면 된다.
        return new Article(null, title, content);
    }
}
