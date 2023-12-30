package com.swproject.swproject.service;

import com.swproject.swproject.entity.Day;
import com.swproject.swproject.entity.Log;
import com.swproject.swproject.repo.DayRepository;
import com.swproject.swproject.repo.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class DayService {

    private final DayRepository dayRepository;

    @Autowired
    public DayService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }
    public List<Day> getCommentsByLogId(Long logId) {
        return dayRepository.findByLogId(logId);
    }
    public void saveDay(Day day) {
        dayRepository.save(day);
    }
}