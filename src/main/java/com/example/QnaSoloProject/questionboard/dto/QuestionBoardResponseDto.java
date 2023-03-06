package com.example.QnaSoloProject.questionboard.dto;

import com.example.QnaSoloProject.questionboard.entity.QuestionBoard;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;


@Getter
@Setter
public class QuestionBoardResponseDto {
    @Positive
    private long questionBoardId;

    private String title;
    private String content;

    private String name;

    private LocalDateTime modifiedAt;
    private QuestionBoard.BoardStatus boardStatus;
    private QuestionBoard.BoardDisclosure disclosure;

}
