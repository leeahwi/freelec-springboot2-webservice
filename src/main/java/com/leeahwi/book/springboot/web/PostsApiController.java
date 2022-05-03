package com.leeahwi.book.springboot.web;
import com.leeahwi.book.springboot.domain.posts.PostsRepository;
import com.leeahwi.book.springboot.service.posts.PostsService;
import com.leeahwi.book.springboot.web.dto.PostsResponseDto;
import com.leeahwi.book.springboot.web.dto.PostsSaveRequestDto;
import com.leeahwi.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    //REST에서 CRUD는 다음과 같이 HTTP Method에 매핑
    //생성(create) - POST
    //읽기(read) - GET
    //수정(Update) - PUT
    //삭제(delete) - DELETE
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
