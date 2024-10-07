package com.br.desafio.api.usecase;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.desafio.api.model.Category;
import com.br.desafio.api.model.Quotation;
import com.br.desafio.api.repository.QuotationRepository;

@Component
public class SaveQuotationUseCase {
	
	@Autowired
	QuotationRepository quotationRepository;
	
	public Quotation handle(Category category, BigDecimal valorTarifado, BigDecimal valorBase) {
		
		Quotation quotation = new Quotation();
		
		quotation.setCategory(category);
		quotation.setUuid(UUID.randomUUID().toString());
		quotation.setValueBase(valorBase);
		quotation.setValueTarifed(valorTarifado);
		quotation.setName(category.getName());
		
		return quotationRepository.saveAndFlush(quotation);
		
		
	}

}
