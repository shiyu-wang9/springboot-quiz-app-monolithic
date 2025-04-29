package com.shiyu.quiz.app.service;

import com.shiyu.quiz.app.repository.QuestionRepository;
import com.shiyu.quiz.app.repository.QuizRepository;
import com.shiyu.quiz.app.model.Question;
import com.shiyu.quiz.app.model.QuestionWrapper;
import com.shiyu.quiz.app.model.Quiz;
import com.shiyu.quiz.app.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizRepository.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);

        // we want to transfer the quiz to quiz wrapper (no right_answer field)
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> quesitonsForUser = new ArrayList<>();

        for(Question q: questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(),q.getOption3(), q.getOption4());
            quesitonsForUser.add(qw);
        }

        return new ResponseEntity<>(quesitonsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;

        for(Response response: responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
