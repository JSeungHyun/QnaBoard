package com.example.QnaSoloProject.questionboard.service;

import com.example.QnaSoloProject.admin.admin;
import com.example.QnaSoloProject.member.entity.Member;
import com.example.QnaSoloProject.member.service.MemberService;
import com.example.QnaSoloProject.questionboard.entity.QuestionBoard;
import com.example.QnaSoloProject.questionboard.repository.QuestionBoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class QuestionBoardService {

    private final QuestionBoardRepository questionBoardRepository;
    private final MemberService memberService;

    public QuestionBoardService(QuestionBoardRepository questionBoardRepository, MemberService memberService) {
        this.questionBoardRepository = questionBoardRepository;
        this.memberService = memberService;
    }

    public QuestionBoard createPost(QuestionBoard questionBoard){
        questionBoard.setMember(memberService.findVerifiedMember(questionBoard.getMember().getMemberId()));
        questionBoardRepository.save(questionBoard);
        return questionBoard;
    }

    public QuestionBoard updatePost(QuestionBoard questionBoard){
        QuestionBoard findPost = findVerifiedQuestionBoard(questionBoard.getQuestionBoardId());
        // 관리자나 작성자가 아닌 경우
        if (!(questionBoard.getMember().getEmail().equals(admin.INSTANCE.getEmail()) && !(findPost.getMember().getMemberId().equals(questionBoard.getMember().getMemberId())))){
            throw new RuntimeException(); // 권한 없음
        }
        // 이미 작업 완료된 게시글
        if ((findPost.getBoardStatus().equals(QuestionBoard.BoardStatus.QUESTION_ANSWERED)) || (findPost.getBoardStatus().equals(QuestionBoard.BoardStatus.QUESTION_DELETE))){
            throw new RuntimeException();
        }
        // QUESTION_ANSWERED로의 변경은 관리자만 가능
         if (questionBoard.getBoardStatus().equals(QuestionBoard.BoardStatus.QUESTION_ANSWERED)){
             if (questionBoard.getMember().getEmail().equals(admin.INSTANCE.getEmail())){
                findPost.setBoardStatus(QuestionBoard.BoardStatus.QUESTION_ANSWERED);
             }else{
                 throw new RuntimeException(); // 권한 없음
             }

         }
         Optional.ofNullable(questionBoard.getDisclosure()).ifPresent(status -> findPost.setDisclosure(status));
         Optional.ofNullable(questionBoard.getTitle()).ifPresent(title -> findPost.setTitle(title));
         Optional.ofNullable(questionBoard.getContent()).ifPresent(content -> findPost.setContent(content));
         questionBoardRepository.save(findPost);
         return findPost;
    }
    private QuestionBoard findVerifiedQuestionBoard(long QuestionBoardId) {
        Optional<QuestionBoard> optionalQuestionBoard = questionBoardRepository.findById(QuestionBoardId);
        QuestionBoard findQuestionBoard = optionalQuestionBoard.orElseThrow(() ->
                new RuntimeException()); // 게시물 없음으로 변경
        return findQuestionBoard;
    }
}
