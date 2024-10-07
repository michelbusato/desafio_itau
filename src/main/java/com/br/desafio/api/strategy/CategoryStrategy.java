package com.br.desafio.api.strategy;

import java.math.BigDecimal;

public interface CategoryStrategy {
	
	BigDecimal calculate(BigDecimal pb, BigDecimal iof, BigDecimal cofins, BigDecimal pis);

}
