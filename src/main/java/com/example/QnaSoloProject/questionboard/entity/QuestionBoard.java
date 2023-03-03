package com.example.QnaSoloProject.questionboard.entity;

import com.example.QnaSoloProject.audit.Auditable;
import com.example.QnaSoloProject.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter @Setter
@Entity
public class QuestionBoard extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionBoardId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private BoardStatus boardStatus = BoardStatus.QUESTION_REGISTRATION;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private BoardDisclosure disclosure = BoardDisclosure.PUBLIC;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public enum BoardStatus{
        QUESTION_REGISTRATION("질문 등록"),
        QUESTION_ANSWERED("답변 완료"),
        QUESTION_DELETE("질문 삭제");

        @Getter
        private String status;

        BoardStatus(String status) {
            this.status = status;
        }
    }

    public enum BoardDisclosure{
        PUBLIC("공개"),
        SECRET("비공개");

        @Getter
        private String status;

        BoardDisclosure(String status) {
            this.status = status;
        }
    }
}
