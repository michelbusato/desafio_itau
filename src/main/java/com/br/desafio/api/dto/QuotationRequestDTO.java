package com.br.desafio.api.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class QuotationRequestDTO {
	
	@JsonProperty(value = "nome")
	private String name;
	@JsonProperty(value = "categoria", required = true)
	private String category;
	@JsonProperty(value = "preco_base", required = true)
	private BigDecimal value;
	

}
