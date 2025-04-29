package com.shiyu.quiz.app.controller;
import com.shiyu.quiz.app.model.Question;
import com.shiyu.quiz.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {


    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    //{category} means it's a variable in the URL - path variable
    @GetMapping("category/{cate}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable("cate")  String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
}
