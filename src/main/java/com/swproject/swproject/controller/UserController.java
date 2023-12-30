package com.swproject.swproject.controller;

import com.swproject.swproject.entity.User;
import com.swproject.swproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller // @RestController 대신 @Controller 사용
@RequestMapping("/")
public class UserController{

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registrationForm() {
        return "register"; // HTML 뷰 반환
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttrs) {
        try {
            User newUser = userService.registerNewUser(user);
            redirectAttrs.addFlashAttribute("user", newUser);
            return "redirect:/logs"; // 성공 페이지로 리디렉션
        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", e.getMessage());
            return "redirect:/register"; // 에러 시, 다시 등록 폼으로 리디렉션
        }
    }

}

