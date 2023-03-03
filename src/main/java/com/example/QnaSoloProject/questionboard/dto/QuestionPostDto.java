package com.example.QnaSoloProject.questionboard.dto;

import com.example.QnaSoloProject.member.entity.Member;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
public class QuestionPostDto {

    @Positive
    private long memberId;

    @NotBlank(message = "제목을 입력하세요.")
    private String title;

    @NotBlank(message = "내용을 입력하세요.")
    private String content;



    public Member getMember(){
        Member member = new Member();
        member.setMemberId(memberId);
        return member;
    }
}
