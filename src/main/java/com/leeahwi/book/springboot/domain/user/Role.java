package com.leeahwi.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
    각 사용자의 권한을 관리할 Enum 클래스 Role을 생성
 */

@Getter
@RequiredArgsConstructor    //선언된 모든 final 필드가 포함된 생성자 생성
public enum Role {

    //스프링 시큐리티에서는 권한 코드에 항상 ROLE_이 앞에 있어야만 함
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
