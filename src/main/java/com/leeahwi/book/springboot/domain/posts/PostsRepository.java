package com.leeahwi.book.springboot.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Entity 클래스, PK 타입> 상속하면 기본 CRUD 메소드가 자동 생성됨
//Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다.
public interface PostsRepository extends JpaRepository<Posts,Long>{


}
