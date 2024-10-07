package com.br.desafio.api.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Quotation")
@Getter
@Setter
@EqualsAndHashCode
public class Quotation {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "uuid")
	private String uuid;
	
	@Column(name = "name")
	private String name;
		
	@Column(name = "value_base")
	private BigDecimal valueBase;
	
	@Column(name = "value_tarifed")
	private BigDecimal valueTarifed;
	
	@ManyToOne(fetch = FetchType.LAZY)	 
	private Category category;

}
