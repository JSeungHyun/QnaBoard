package com.example.QnaSoloProject.questionboard.mapper;

import com.example.QnaSoloProject.member.entity.Member;
import com.example.QnaSoloProject.questionboard.dto.QuestionBoardPatchDto;
import com.example.QnaSoloProject.questionboard.dto.QuestionBoardPostDto;
import com.example.QnaSoloProject.questionboard.dto.QuestionBoardResponseDto;
import com.example.QnaSoloProject.questionboard.entity.QuestionBoard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionBoard questionPostDtoToQuestionBoard(QuestionBoardPostDto questionBoardPostDto);
    QuestionBoard questionPatchDtoToQuestionBoard(QuestionBoardPatchDto questionBoardPatchDto);

    @Mapping(source = "member.name",target = "name")
    QuestionBoardResponseDto questionBoardToQuestionResponseDto(QuestionBoard questionBoard);
}
