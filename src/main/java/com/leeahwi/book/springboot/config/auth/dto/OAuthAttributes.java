package com.leeahwi.book.springboot.config.auth.dto;

import com.leeahwi.book.springboot.domain.user.Role;
import com.leeahwi.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String,Object> attributes, String nameAttributeKey, String name
    , String email, String picture){
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    //OAuth2User 에서 반환하는 사용자 정보는 Map이기 때문에 값 하나하나를 변환해주어야 함
    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String,Object> attributes){
        if("naver".equals(registrationId)){
            return ofNaver("id",attributes);
        }

        return ofGoogle(userNameAttributeName,attributes);
    }

    public static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String,Object> attributes){
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    //response.get 안하고 attributes.get 하니 naver 로그인 회원 결과가 resultCode,message,response 세 타입이라서
    //이중 response 타입 선택 안하고 get하니 당연히 값이 없는것
    public static OAuthAttributes ofNaver(String userNameAttributeName, Map<String,Object> attributes){
        Map<String,Object> response = (Map<String,Object>)attributes.get("response");
        return OAuthAttributes.builder()
                .name((String)response.get("name"))
                .email((String)response.get("email"))
                .picture((String)response.get("profileImage"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    //User 엔티티 생성
    //OAuthAttributes에서 엔티티를 생성하는 시점은 처음 가입할 때
    //가입할 때의 기본 권한을 GUEST로 주기 위해서 role 빌더값에는 Role.GUEST를 사용한다.
    //OAuthAttributes
    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }


}
