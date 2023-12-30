package com.swproject.swproject.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.swproject.swproject.entity.Day;
import com.swproject.swproject.entity.Log;
import com.swproject.swproject.repo.DayRepository;
import com.swproject.swproject.repo.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    public Log getLogById(Long id) {
        return logRepository.findById(id).orElse(null);
    }

    public void saveLog(Log log) {
        log.setCreatedAt(LocalDateTime.now());
        logRepository.save(log);
    }

    public void deleteLog(Long id) {
        logRepository.deleteById(id);
    }
}
