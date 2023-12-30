package com.swproject.swproject.controller;

import java.util.List;

import com.swproject.swproject.entity.Day;
import com.swproject.swproject.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.swproject.swproject.service.LogService;
import com.swproject.swproject.service.DayService;

@Controller
@RequestMapping("/logs")
public class LogController {

    private final LogService logService;
    private final DayService dayService;

    @Autowired
    public LogController(LogService logService, DayService dayService) {
        this.logService = logService;
        this.dayService = dayService;
    }

    @GetMapping
    public String getAllLogs(Model model) {
        List<Log> logs = logService.getAllLogs();
        model.addAttribute("logs", logs);
        return "/list";
    }

    @GetMapping("/{id}")
    public String getLogById(@PathVariable(name = "id") Long log_id, Model model) {
        Log log = logService.getLogById(log_id);
        model.addAttribute("log", log);

        List<Day> comments = dayService.getCommentsByLogId(log_id);
        model.addAttribute("comments", comments);
        return "/detail";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("log", new Log());
        return "/create";
    }

    @PostMapping("/new")
    public String createLog(@ModelAttribute Log log) {
        logService.saveLog(log);
        return "redirect:/logs";
    }

    @GetMapping("/{id}/delete")
    public String deleteLog(@PathVariable(name = "id") Long id) {
        logService.deleteLog(id);
        return "redirect:/logs";
    }

    @GetMapping("/{logId}/new")
    public String showCommentForm(@PathVariable(name = "logId") Long logId, Model model) {
        Day day = new Day();
        Log log = logService.getLogById(logId);
        day.setLog(log);

        model.addAttribute("log", log);
        model.addAttribute("day", day);

        return "/commentForm";
    }

    @PostMapping("/{logId}/new")
    public String createComment(@ModelAttribute Day day, @PathVariable(name = "logId") Long logId) {
        Log log = logService.getLogById(logId);
        day.setLog(log);

        dayService.saveDay(day);
        return "redirect:/logs/" + logId;
    }


}
