package com.example.QnaSoloProject.questionboard.controller;


import com.example.QnaSoloProject.questionboard.dto.QuestionBoardPatchDto;
import com.example.QnaSoloProject.questionboard.dto.QuestionBoardPostDto;
import com.example.QnaSoloProject.questionboard.entity.QuestionBoard;
import com.example.QnaSoloProject.questionboard.mapper.QuestionMapper;
import com.example.QnaSoloProject.questionboard.service.QuestionBoardService;
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
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionBoardPostDto questionBoardPostDto){
        QuestionBoard questionBoard = mapper.questionPostDtoToQuestionBoard(questionBoardPostDto);
        questionService.createPost(questionBoard);
        return new ResponseEntity(mapper.questionBoardToQuestionResponseDto(questionBoard), HttpStatus.OK);
    }

    @PatchMapping("/{board-id}")
    public ResponseEntity patchQuestion(@PathVariable("board-id") long boardId,
                                        @Valid @RequestBody QuestionBoardPatchDto questionBoardPatchDto){
        QuestionBoard questionBoard = mapper.questionPatchDtoToQuestionBoard(questionBoardPatchDto);
        questionBoard.setQuestionBoardId(boardId);
        questionService.updatePost(questionBoard);
        return new ResponseEntity(mapper.questionBoardToQuestionResponseDto(questionBoard), HttpStatus.OK);
    }
}
