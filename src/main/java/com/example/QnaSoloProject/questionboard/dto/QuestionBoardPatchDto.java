package com.example.QnaSoloProject.questionboard.dto;

import com.example.QnaSoloProject.member.entity.Member;
import com.example.QnaSoloProject.questionboard.entity.QuestionBoard;
import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
public class QuestionBoardPatchDto {

    @Positive
    private long memberId;
    private String title;
    private String content;
    private QuestionBoard.BoardStatus boardStatus;
    private QuestionBoard.BoardDisclosure boardDisclosure;

    public Member getMember(){
        Member member = new Member();
        member.setMemberId(memberId);
        return member;
    }
}
