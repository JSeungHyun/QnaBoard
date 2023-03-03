package com.example.QnaSoloProject.questionboard.mapper;

import com.example.QnaSoloProject.questionboard.dto.QuestionPostDto;
import com.example.QnaSoloProject.questionboard.dto.QuestionResponseDto;
import com.example.QnaSoloProject.questionboard.entity.QuestionBoard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionBoard questionPostDtoToQuestionBoard(QuestionPostDto questionPostDto);

    @Mapping(source = "member.memberId", target = "memberId")
    @Mapping(source = "member.name", target = "name")
    QuestionResponseDto questionBoardToQuestionResponseDto(QuestionBoard questionBoard);
}
