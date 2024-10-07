package com.br.desafio.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CategoryResponseDTO {
	
	@JsonProperty(value = "nome")
	private String name;
	@JsonProperty(value = "descricao")
	private String description;

}
