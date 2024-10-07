package com.br.desafio.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.desafio.api.model.Quotation;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation, Long> {

	
	
	
	
	
}
