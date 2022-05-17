package com.leeahwi.book.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
public class Application {
    /*
        앞으로 만들 프로젝트의 메인 클래스
        @SpringBootApplication으로 인해
        스프링 부트의 자동설정
        스프링 Bean 읽기, 생성 자동
        @SpringBootApplication 있는 위치부터 설정을 읽기에
        위 클래스는 항상 프로젝트 최 상단 위치
     */
    public static void main(String[] args){
        // 내장 WAS (Web Application Server) 실행
        SpringApplication.run(Application.class, args);

    }
}
