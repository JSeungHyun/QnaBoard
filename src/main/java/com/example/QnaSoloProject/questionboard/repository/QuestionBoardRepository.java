package com.example.QnaSoloProject.questionboard.repository;

import com.example.QnaSoloProject.questionboard.entity.QuestionBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionBoardRepository extends JpaRepository<QuestionBoard, Long> {
}
