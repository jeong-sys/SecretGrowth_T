package com.swproject.swproject.controller;

import com.swproject.swproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String loginForm() {
        return "login"; // 로그인 페이지 반환
    }

    @PostMapping("/login")
    public String login(@RequestParam String userId, @RequestParam String password, RedirectAttributes redirectAttrs) {
        if (loginService.authenticate(userId, password)) {
            return "redirect:/logs";
        } else {
            redirectAttrs.addFlashAttribute("loginError", "ID 또는 비밀번호가 잘못되었습니다.");
            return "redirect:/login";
        }
    }
}
