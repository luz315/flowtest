package com.flow.test.presentation;

import com.flow.test.application.PostService;
import com.flow.test.dto.PostCreateRequest;
import com.flow.test.dto.PostResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/views/posts")
public class PostViewController {

    private final PostService postService;

    @GetMapping("/new")
    public String newPostForm(Model model) {
        model.addAttribute("postRequest", new PostCreateRequest("", "", List.of(), List.of()));
        return "post-form";
    }

    @PostMapping
    public String createPost(
            @Valid @ModelAttribute("postRequest") PostCreateRequest request,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "post-form";
        }

        PostResponse response = postService.createPost(request);
        model.addAttribute("post", response);
        return "post-result";
    }
}