package com.example.QnaSoloProject.questionboard.dto;

import com.example.QnaSoloProject.questionboard.entity.QuestionBoard;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class QuestionResponseDto {
    private long questionBoardId;
    private String title;
    private String content;
    private String name;
    private long memberId;
    private LocalDateTime modifiedAt;
    private QuestionBoard.BoardStatus boardStatus;
    private QuestionBoard.BoardDisclosure disclosure;
}
