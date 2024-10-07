package com.br.desafio.api.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class QuotationResponseDTO {
	
	private String id;
	private String nome;
	private String categoria;
	@JsonProperty(value = "preco_base")
	private BigDecimal precoBase;
	@JsonProperty(value =  "preco_tarifado")
	private BigDecimal precoTarifado;
	


}
