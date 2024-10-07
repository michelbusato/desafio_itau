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

@Component

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







	public BigDecimal handle(Optional<Category> category, BigDecimal value) {	
		
		BigDecimal iof = BigDecimal.ZERO;		
		BigDecimal pis = BigDecimal.ZERO;		
		BigDecimal cofins = BigDecimal.ZERO;	
		
		switch (category.get().getName()) {
		case VIDA: {
			iof = category.get().getIof().divide(new BigDecimal("100"));
			pis = category.get().getPis().divide(new BigDecimal("100"));			
			return vidaStrategy.calculate(value, iof, cofins, pis);
		}
		case AUTO: {
			iof = category.get().getIof().divide(new BigDecimal("100"));
			pis = category.get().getPis().divide(new BigDecimal("100"));
			cofins = category.get().getConfins().divide(new BigDecimal("100"));
			return autoStrategy.calculate(value, iof, cofins, pis);
		}
		case VIAGEM: {
			iof = category.get().getIof().divide(new BigDecimal("100"));
			pis = category.get().getPis().divide(new BigDecimal("100"));	
			cofins = category.get().getConfins().divide(new BigDecimal("100"));
			return viagemStrategy.calculate(value, iof, cofins, pis);
		}
		case RESIDENCIAL: {
			iof = category.get().getIof().divide(new BigDecimal("100"));
			cofins = category.get().getConfins().divide(new BigDecimal("100"));
			return residencialStrategy.calculate(value, iof, cofins, pis);
		}
		case PATRIMONIAL: {
			iof = category.get().getIof().divide(new BigDecimal("100"));
			pis = category.get().getPis().divide(new BigDecimal("100"));			
			return patrimonialStrategy.calculate(value, iof, cofins, pis);
		}
		default:
			return BigDecimal.ZERO;
		}	
		
		
	}

	

}
