package com.example.QnaSoloProject.member.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Getter
public class MemberPostDto {

    @NotBlank(message = "이름을 입력하세요.")
    private String name;

    @NotBlank(message = "email은 필수 입력 사항입니다.")
    @Email
    private String email;

    @NotBlank(message = "password를 입력해주세요")
    private String password;

}
