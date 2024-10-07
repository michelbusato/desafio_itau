package com.br.desafio.api.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.desafio.api.dto.QuotationRequestDTO;
import com.br.desafio.api.dto.QuotationResponseDTO;
import com.br.desafio.api.model.Category;
import com.br.desafio.api.model.Quotation;
import com.br.desafio.api.usecase.CalculatePriceUseCase;
import com.br.desafio.api.usecase.FindCategoryByNameUseCase;
import com.br.desafio.api.usecase.SaveQuotationUseCase;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/v1/api/quotation")
@Tag(name = "Quotation", description = "Quotation management APIs")
@Log4j2
public class QuotationController {

	private final String CATEGORIA_NAO_INFORMADA = "Campo categoria não informada";
	private final String VALOR_NAO_INFORMADO = "Campo valor não informado";
	private final String CATEGORIA_INFORMADA_INVALIDA = "Categoria Invalida";
	private final String TARIFA_BASE_INFORMADA_INVALIDA = "Tarifa Base Invalida";

	private FindCategoryByNameUseCase findCategoryByNameUseCase;
	private CalculatePriceUseCase calculatePriceUseCase;
	private SaveQuotationUseCase saveQuotationUseCase;


	public QuotationController(FindCategoryByNameUseCase findCategoryByNameUseCase, CalculatePriceUseCase calculatePriceUseCase, SaveQuotationUseCase saveQuotationUseCase) {
		super();
		this.findCategoryByNameUseCase = findCategoryByNameUseCase;
		this.calculatePriceUseCase = calculatePriceUseCase;
		this.saveQuotationUseCase = saveQuotationUseCase;
	}



	@PostMapping("/")
	public ResponseEntity<?> create(@Valid @RequestBody QuotationRequestDTO dto) {
		try {
			log.info("start create quotation");

			if(dto.getCategory() == null || dto.getCategory().isBlank() || dto.getCategory().isEmpty()) {
				return new ResponseEntity<>(CATEGORIA_NAO_INFORMADA, HttpStatus.BAD_REQUEST);
			}

			if(dto.getValue() == null) {
				return new ResponseEntity<>(VALOR_NAO_INFORMADO, HttpStatus.BAD_REQUEST);
			}
			
			if (dto.getValue() == null || dto.getValue().compareTo(new BigDecimal(0)) < 1) {
				return new ResponseEntity<>(TARIFA_BASE_INFORMADA_INVALIDA, HttpStatus.BAD_REQUEST);
			}
			
			log.info("find category {}", dto.getCategory());
			Optional<Category> category = findCategoryByNameUseCase.handle(dto.getCategory());

			BigDecimal valorTarifado = BigDecimal.ZERO;

			if(category.isPresent()) {
				log.info("calculate price tarifed with price base{}", dto.getValue());
				valorTarifado = calculatePriceUseCase.handle(category.get(), dto.getValue());
				log.info("price tarifed withe price base{}", dto.getValue());
			}else {
				return new ResponseEntity<>(CATEGORIA_INFORMADA_INVALIDA, HttpStatus.BAD_REQUEST);
			}

			log.info("save quotation in bd ");
			Quotation objBd = saveQuotationUseCase.handle(category.get(), valorTarifado, dto.getValue());
		
			if(objBd != null) {
				log.info("save sucess quotation in bd with uuid {}", objBd.getUuid());
				QuotationResponseDTO responseDTO = QuotationResponseDTO.
						builder()
						.categoria(category.get().getName())
						.nome(category.get().getDescription())
						.precoBase(dto.getValue())
						.id(objBd.getUuid())
						.precoTarifado(valorTarifado.setScale(2)).build();

				return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);


			}

			log.info("end create quotation");		
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

}
