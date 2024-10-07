package com.br.desafio.api.usecase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.desafio.api.dto.CategoryResponseDTO;
import com.br.desafio.api.model.Category;
import com.br.desafio.api.repository.CategoryRepository;
import com.br.desafio.api.util.ObjectMapperUtils;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindAllCategoryDTOUseCase {
	
	@Autowired
	CategoryRepository repository;
	
	
	public List<CategoryResponseDTO> handle() {
		List<Category> list = repository.findAll();
		if(list.isEmpty()) {
			return new ArrayList<>();
		}
		
		return ObjectMapperUtils.mapAll(list, CategoryResponseDTO.class);
		
	}



	

}
