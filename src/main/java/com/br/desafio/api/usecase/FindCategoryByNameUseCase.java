package com.br.desafio.api.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.desafio.api.model.Category;
import com.br.desafio.api.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindCategoryByNameUseCase {
	
	@Autowired
	CategoryRepository repository;

	public Optional<Category> handle(String category) {		
		return repository.findByNameEqualsIgnoreCase(category);
	}

	

}
