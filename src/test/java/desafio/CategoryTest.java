package desafio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;

import com.br.desafio.api.dto.CategoryResponseDTO;
import com.br.desafio.api.repository.CategoryRepository;
import com.br.desafio.api.usecase.FindAllCategoryDTOUseCase;

@ExtendWith(MockitoExtension.class)
@TestPropertySource("classpath:application-test.properties")

class CategoryTest {

	@InjectMocks
	  FindAllCategoryDTOUseCase service;

	  @Mock
	  CategoryRepository dao;
	
	
	@Test
	void test() {
		List<CategoryResponseDTO> empList = service.handle();
		assertEquals(0, empList.size());

	}

}
