package com.example.QnaSoloProject.questionboard.mapper;

import com.example.QnaSoloProject.member.entity.Member;
import com.example.QnaSoloProject.questionboard.dto.QuestionPostDto;
import com.example.QnaSoloProject.questionboard.dto.QuestionResponseDto;
import com.example.QnaSoloProject.questionboard.entity.QuestionBoard;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-03T01:57:54+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public QuestionBoard questionPostDtoToQuestionBoard(QuestionPostDto questionPostDto) {
        if ( questionPostDto == null ) {
            return null;
        }

        QuestionBoard questionBoard = new QuestionBoard();

        questionBoard.setTitle( questionPostDto.getTitle() );
        questionBoard.setContent( questionPostDto.getContent() );

        return questionBoard;
    }

    @Override
    public QuestionResponseDto questionBoardToQuestionResponseDto(QuestionBoard questionBoard) {
        if ( questionBoard == null ) {
            return null;
        }

        QuestionResponseDto questionResponseDto = new QuestionResponseDto();

        questionResponseDto.setName( questionBoardMemberName( questionBoard ) );
        questionResponseDto.setMember( questionBoard.getMember() );
        questionResponseDto.setQuestionBoardId( questionBoard.getQuestionBoardId() );
        questionResponseDto.setTitle( questionBoard.getTitle() );
        questionResponseDto.setContent( questionBoard.getContent() );
        questionResponseDto.setModifiedAt( questionBoard.getModifiedAt() );
        questionResponseDto.setBoardStatus( questionBoard.getBoardStatus() );
        questionResponseDto.setDisclosure( questionBoard.getDisclosure() );

        return questionResponseDto;
    }

    private String questionBoardMemberName(QuestionBoard questionBoard) {
        if ( questionBoard == null ) {
            return null;
        }
        Member member = questionBoard.getMember();
        if ( member == null ) {
            return null;
        }
        String name = member.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
