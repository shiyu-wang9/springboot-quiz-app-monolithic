package com.shiyu.quiz.app.repository;

import com.shiyu.quiz.app.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
