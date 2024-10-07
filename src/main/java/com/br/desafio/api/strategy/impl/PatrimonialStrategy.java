package com.br.desafio.api.strategy.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.br.desafio.api.strategy.CategoryStrategy;
@Component
public class PatrimonialStrategy implements CategoryStrategy{

	@Override
	public BigDecimal calculate(BigDecimal pb, BigDecimal iof, BigDecimal cofins, BigDecimal pis) {
		return pb.add(pb.multiply(iof)).add(pb.multiply(pis));
	}
	

}
