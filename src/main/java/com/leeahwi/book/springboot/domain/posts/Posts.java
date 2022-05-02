package com.leeahwi.book.springboot.domain.posts;
import com.leeahwi.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor  //기본 생성자 자동 추가 == public Posts() {}
@Entity //테이블과 링크될 클래스 나타냄
public class Posts extends BaseTimeEntity {

    @Id //테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙 나타냄
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 칼럼을 나타냄 선언 없어도 자동적으로 필드는 모두 칼럼이 됨
    //문자열 경우 VARCHAR(255) 기본인데 사이즈를 500으로 늘리고 싶거나 타입을 TEXT로 바꾸고 싶을때 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //Setter가 없는 상호아에서의 DB 삽입 방법
    //기본적으로는 생성자를 통해 최종값을 채운 후 DB에 삽입하는 것
    //값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경하는 것을 전제로 함
    //@Builder를 통해 제공되는 빌더 클래스 사용
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }



}
