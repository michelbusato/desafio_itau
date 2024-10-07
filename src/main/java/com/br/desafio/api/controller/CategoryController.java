package com.br.desafio.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.desafio.api.dto.CategoryResponseDTO;
import com.br.desafio.api.usecase.FindAllCategoryDTOUseCase;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/v1/api/quotation")
@Tag(name = "Category", description = "Category management APIs")
@Log4j2
public class CategoryController {
	
	FindAllCategoryDTOUseCase findAllCategoryUseCase;	
	
	
	public CategoryController(FindAllCategoryDTOUseCase findAllCategoryUseCase) {
		super();
		this.findAllCategoryUseCase = findAllCategoryUseCase;
	}

	@GetMapping("/")
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategory() {		
		log.debug("start find all category");
		List<CategoryResponseDTO> list = findAllCategoryUseCase.handle();
		log.debug("end find all category");		
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
