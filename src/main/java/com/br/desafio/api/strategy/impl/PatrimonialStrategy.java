package com.br.desafio.api.strategy.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.br.desafio.api.strategy.CategoryStrategy;

import lombok.extern.log4j.Log4j2;
@Component
@Log4j2
public class PatrimonialStrategy implements CategoryStrategy{

	@Override
	public BigDecimal calculate(BigDecimal pb, BigDecimal iof, BigDecimal cofins, BigDecimal pis) {
		try {
			return pb.add(pb.multiply(iof)).add(pb.multiply(pis));
		}catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}


}
