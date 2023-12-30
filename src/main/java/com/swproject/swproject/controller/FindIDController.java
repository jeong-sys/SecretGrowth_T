package com.swproject.swproject.controller;

import com.swproject.swproject.entity.User;
import com.swproject.swproject.repo.UserRepository;
import com.swproject.swproject.service.FindIDService;
import com.swproject.swproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/")
public class FindIDController {

    @Autowired
    private FindIDService findIDService;

    @GetMapping("/findUserId")
    public String findUserIdForm() {
        return "findUserId";
    }

    @PostMapping("/findUserId")
    public String findUserId(@RequestParam String name, @RequestParam String dateOfBirth, RedirectAttributes redirectAttrs) {
        String userId = findIDService.findUserId(name, LocalDate.parse(dateOfBirth));
        redirectAttrs.addFlashAttribute("userId", userId);
        return "redirect:/findUserId";
    }
}
