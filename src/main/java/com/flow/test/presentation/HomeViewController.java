package com.flow.test.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeViewController {

    @GetMapping("/")
    public String showHomePage() {
        return "post-form"; // templates/post-form.html이 랜더링됨
    }
}
