package com.swproject.swproject.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "log", cascade = CascadeType.ALL)
    private List<Day> days = new ArrayList<>();

    public Log() {
        this.title = "null";
        this.content = "null";
        this.createdAt = LocalDateTime.now();
    }

    public Log(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();;
    }

}

