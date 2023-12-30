package com.swproject.swproject.service;

import com.swproject.swproject.entity.User;
import com.swproject.swproject.repo.FindIDRepository;
import com.swproject.swproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FindIDService {

    @Autowired
    private FindIDRepository findIDRepository;

    public String findUserId(String name, LocalDate dateOfBirth){
        return findIDRepository.findByNameAndDateOfBirth(name, dateOfBirth)
                .map(User::getUserId)
                .orElse("해당 정보와 일치하는 사용자가 없습니다.");
    }


}
