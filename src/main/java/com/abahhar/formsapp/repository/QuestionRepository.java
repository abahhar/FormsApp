package com.abahhar.formsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abahhar.formsapp.domain.Question;

public interface QuestionRepository<T extends Question>
		extends JpaRepository<T, Integer> {

}
