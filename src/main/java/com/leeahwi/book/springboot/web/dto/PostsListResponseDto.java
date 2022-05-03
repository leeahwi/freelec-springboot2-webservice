package com.leeahwi.book.springboot.web.dto;

import com.leeahwi.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private final Long id;
    private final String title;
    //private final String content;
    private final String author;
    private final LocalDateTime modifiedData;

    public PostsListResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        //this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.modifiedData = entity.getModifiedData();
    }


}
