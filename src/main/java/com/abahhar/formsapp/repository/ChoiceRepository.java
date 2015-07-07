package com.abahhar.formsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abahhar.formsapp.domain.Choice;

public interface ChoiceRepository extends JpaRepository<Choice, Integer> {

}
