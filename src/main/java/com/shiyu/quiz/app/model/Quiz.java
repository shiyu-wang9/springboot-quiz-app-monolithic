package com.shiyu.quiz.app.model;

import jakarta.persistence.*;

import java.util.List;
import lombok.Data;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    // one quiz can have multiple questions; one question may appear in different quiz
    @ManyToMany
    private List<Question> questions;
}
