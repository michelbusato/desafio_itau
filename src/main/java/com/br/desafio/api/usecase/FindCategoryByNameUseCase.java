package com.br.desafio.api.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.desafio.api.model.Category;
import com.br.desafio.api.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RequiredArgsConstructor
@Log4j2
public class FindCategoryByNameUseCase {
	
	@Autowired
	CategoryRepository repository;

	public Optional<Category> handle(String category) {	
		try {
			return repository.findByNameEqualsIgnoreCase(category);
		}catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	

}
