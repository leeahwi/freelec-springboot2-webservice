package com.leeahwi.book.springboot.web;
import com.leeahwi.book.springboot.domain.posts.Posts;
import com.leeahwi.book.springboot.domain.posts.PostsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void 메인페이지_로딩(){
        //when
        String body = this.restTemplate.getForObject("/",String.class);

        assertThat(body).contains("스프링 부트로 시작하는 웹서비스");
    }

    @Test
    public void 게시글_등록페이지_로딩(){
        //when
        String body = this.restTemplate.getForObject("/posts/save/",String.class);

        assertThat(body).contains("게시글 등록");
    }

    @Test
    public void 게시글_수정페이지_로딩(){
        //given
        Posts savedPosts = postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());


        String url = "/posts/update/" + savedPosts.getId();

        //when
        String body = this.restTemplate.getForObject(url ,String.class);

        assertThat(body).contains("게시글 수정");
    }

}
