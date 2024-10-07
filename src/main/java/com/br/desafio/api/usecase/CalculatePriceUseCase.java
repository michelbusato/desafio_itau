package com.br.desafio.api.usecase;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.br.desafio.api.model.Category;
import com.br.desafio.api.strategy.impl.AutoStrategy;
import com.br.desafio.api.strategy.impl.PatrimonialStrategy;
import com.br.desafio.api.strategy.impl.ResidencialStrategy;
import com.br.desafio.api.strategy.impl.ViagemStrategy;
import com.br.desafio.api.strategy.impl.VidaStrategy;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class CalculatePriceUseCase {

	private final String VIDA = "VIDA";
	private final String AUTO = "AUTO";
	private final String VIAGEM = "VIAGEM";
	private final String RESIDENCIAL = "RESIDENCIAL";
	private final String PATRIMONIAL = "PATRIMONIAL";



	VidaStrategy vidaStrategy;
	ViagemStrategy viagemStrategy;
	ResidencialStrategy residencialStrategy;
	PatrimonialStrategy patrimonialStrategy;
	AutoStrategy autoStrategy;


	public CalculatePriceUseCase(VidaStrategy vidaStrategy, ViagemStrategy viagemStrategy,
			ResidencialStrategy residencialStrategy, PatrimonialStrategy patrimonialStrategy,
			AutoStrategy autoStrategy) {
		super();
		this.vidaStrategy = vidaStrategy;
		this.viagemStrategy = viagemStrategy;
		this.residencialStrategy = residencialStrategy;
		this.patrimonialStrategy = patrimonialStrategy;
		this.autoStrategy = autoStrategy;
	}


	public BigDecimal handle(Category category, BigDecimal value) {	
		try {
			BigDecimal iof = BigDecimal.ZERO;		
			BigDecimal pis = BigDecimal.ZERO;		
			BigDecimal cofins = BigDecimal.ZERO;	

			switch (category.getName()) {
			case VIDA: {
				log.info("use strategy for VIDA");
				iof = category.getIof().divide(new BigDecimal("100"));
				pis = category.getPis().divide(new BigDecimal("100"));			
				return vidaStrategy.calculate(value, iof, cofins, pis);
			}
			case AUTO: {
				log.info("use strategy for AUTO");
				iof = category.getIof().divide(new BigDecimal("100"));
				pis = category.getPis().divide(new BigDecimal("100"));
				cofins = category.getConfins().divide(new BigDecimal("100"));
				return autoStrategy.calculate(value, iof, cofins, pis);
			}
			case VIAGEM: {
				log.info("use strategy for VIAGEM");
				iof = category.getIof().divide(new BigDecimal("100"));
				pis = category.getPis().divide(new BigDecimal("100"));	
				cofins = category.getConfins().divide(new BigDecimal("100"));
				return viagemStrategy.calculate(value, iof, cofins, pis);
			}
			case RESIDENCIAL: {
				log.info("use strategy for RESIDENCIAL");
				iof = category.getIof().divide(new BigDecimal("100"));
				cofins = category.getConfins().divide(new BigDecimal("100"));
				return residencialStrategy.calculate(value, iof, cofins, pis);
			}
			case PATRIMONIAL: {
				log.info("use strategy for PATRIMONIAL");
				iof = category.getIof().divide(new BigDecimal("100"));
				pis = category.getPis().divide(new BigDecimal("100"));			
				return patrimonialStrategy.calculate(value, iof, cofins, pis);
			}
			default:
				return BigDecimal.ZERO;
			}	
		}catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}


	}



}
