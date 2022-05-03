package com.leeahwi.book.springboot.domain.user;
import com.leeahwi.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    //키 값
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //속성
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)    //JPA로 데이터베이스로 저장할 때 Enum 값의 형태를 결정하는 annotation
    //기본적으로 int로 저장되나 이러면 그 값이 무슨 코드인지 알 수 없기에 문자열로 저장될 수 있도록 바꿈
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.getRoleKey();
    }

}
