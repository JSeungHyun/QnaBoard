package com.example.QnaSoloProject.member.dto;

import com.example.QnaSoloProject.member.entity.Member;
import com.example.QnaSoloProject.validator.NotSpace;
import lombok.Getter;

@Getter
public class MemberPatchDto {

    private long memberId;

    private String password;

    @NotSpace(message = "회원 이름은 공백이 아니어야 합니다")
    private String name;

    private Member.MemberStatus memberStatus;



    public void setMemberId(long memberId){
        this.memberId = memberId;
    }
}
