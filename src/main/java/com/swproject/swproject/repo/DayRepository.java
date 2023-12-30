package com.swproject.swproject.repo;

import java.util.List;

import com.swproject.swproject.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DayRepository extends JpaRepository<Day, Long> {
	List<Day> findByLogId(Long logId);
}