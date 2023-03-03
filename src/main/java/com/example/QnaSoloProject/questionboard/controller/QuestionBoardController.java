package com.example.QnaSoloProject.questionboard.controller;


import com.example.QnaSoloProject.member.entity.Member;
import com.example.QnaSoloProject.questionboard.dto.QuestionPostDto;
import com.example.QnaSoloProject.questionboard.entity.QuestionBoard;
import com.example.QnaSoloProject.questionboard.mapper.QuestionMapper;
import com.example.QnaSoloProject.questionboard.service.QuestionBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/board")
@Validated
public class QuestionBoardController {

    private final QuestionBoardService questionService;
    private final QuestionMapper mapper;

    public QuestionBoardController(QuestionBoardService questionService, QuestionMapper mapper) {
        this.questionService = questionService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionPostDto questionPostDto){
        QuestionBoard questionBoard = mapper.questionPostDtoToQuestionBoard(questionPostDto);
        questionService.createPost(questionBoard);
        return new ResponseEntity(mapper.questionBoardToQuestionResponseDto(questionBoard), HttpStatus.OK);
    }
}
