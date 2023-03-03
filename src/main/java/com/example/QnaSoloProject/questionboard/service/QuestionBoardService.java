package com.example.QnaSoloProject.questionboard.service;

import com.example.QnaSoloProject.questionboard.entity.QuestionBoard;
import com.example.QnaSoloProject.questionboard.repository.QuestionBoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionBoardService {

    private final QuestionBoardRepository questionBoardRepository;

    public QuestionBoardService(QuestionBoardRepository questionBoardRepository) {
        this.questionBoardRepository = questionBoardRepository;
    }

    public QuestionBoard createPost(QuestionBoard questionBoard){
        return questionBoardRepository.save(questionBoard);
    }
}
