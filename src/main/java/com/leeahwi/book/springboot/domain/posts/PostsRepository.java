package com.leeahwi.book.springboot.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//JpaRepository<Entity 클래스, PK 타입> 상속하면 기본 CRUD 메소드가 자동 생성됨
//Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다.
public interface PostsRepository extends JpaRepository<Posts,Long>{

    //Create Repository Query
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();


}
