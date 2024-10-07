package com.br.desafio.api.usecase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.desafio.api.dto.CategoryResponseDTO;
import com.br.desafio.api.model.Category;
import com.br.desafio.api.repository.CategoryRepository;
import com.br.desafio.api.util.ObjectMapperUtils;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class FindAllCategoryDTOUseCase {
	
	
	CategoryRepository repository;
	
	
	
	
	public FindAllCategoryDTOUseCase(CategoryRepository repository) {
		super();
		this.repository = repository;
	}




	public List<CategoryResponseDTO> handle() {
		log.info("findAllCategoryDTOUseCase: handle");
		List<Category> list = repository.findAll();
		if(list.isEmpty()) {
			return new ArrayList<>();
		}
		log.info("end findAllCategoryDTOUseCase: handle");
		return ObjectMapperUtils.mapAll(list, CategoryResponseDTO.class);
		
	}



	

}
