package com.leeahwi.book.springboot.web;
import com.leeahwi.book.springboot.config.auth.LoginUser;
import com.leeahwi.book.springboot.config.auth.dto.SessionUser;
import com.leeahwi.book.springboot.domain.user.User;
import com.leeahwi.book.springboot.service.posts.PostsService;
import com.leeahwi.book.springboot.web.dto.PostsResponseDto;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    //User의 Session 담을 거임
    private final HttpSession httpSession;


    //mustache starter 덕분에 앞의 경로와 뒤의 확장자는 자동으로 지정
    //사실상 '/'가 아닌 /src/main/resouces/templates 에 뒷 확장자 .mustache 붙음 여기서든 index 반환하므로 index.mustache
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts",postsService.findAllDesc());

        if(user != null){
            model.addAttribute("userName",user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";    //최종적으로 /posts/save 호출시 posts-save.mustache를 호출하게 됨
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id,Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }
}
