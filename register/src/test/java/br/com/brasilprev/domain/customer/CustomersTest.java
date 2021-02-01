package br.com.brasilprev.domain.customer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.brasilprev.application.customers.FactoryCustomers;
import br.com.brasilprev.domain.customers.entity.CustomersEntity;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class CustomersTest {
	
	private static Validator validator;
	private Set<ConstraintViolation<CustomersEntity>> violations;
		
	@BeforeAll
	public static void setUp() {
		 validator = Validation.byDefaultProvider()
				    .configure()
				    .messageInterpolator(new ParameterMessageInterpolator())
				    .buildValidatorFactory()
				    .getValidator();
	}	
		
	
	@Test
	public void nullAndEmpty() {
		CustomersEntity customersEntityNull = new FactoryCustomers()
				   .withCPFName("12345678901", null)
				   .addressComplete("Rua dos Tests", 
									100, 
									"Bairro teste",
									"Cidade teste",
						   			"Estado teste",
						   			"01010001")
				   .create();	
		violations = validator.validate(customersEntityNull);
        assertFalse(violations.isEmpty());
        
        
		CustomersEntity customersEntityBlank = new FactoryCustomers()
				   .withCPFName("12345678901", "")
				   .addressComplete("Rua dos Tests", 
									100, 
									"Bairro teste",
									"Cidade teste",
						   			"Estado teste",
						   			"01010001")
				   .create();	       
		violations = validator.validate(customersEntityBlank);
        assertFalse(violations.isEmpty());
	}
	
	@Test
	public void fieldSizeMin() {
		CustomersEntity customersEntity = new FactoryCustomers()
				   .withCPFName("12345678901", "Mar")
				   .addressComplete("Rua dos Tests", 
									100, 
									"Bairro teste",
									"Cidade teste",
						   			"Estado teste",
						   			"01010001")
				   .create();			
		violations = validator.validate(customersEntity);
		assertFalse(violations.isEmpty());
	}	
	
	@Test
	public void fieldValid() {
		CustomersEntity customersEntity = new FactoryCustomers()
				   .withCPFName("12345678901", "Testa da Silva")
				   .addressComplete("Rua dos Tests", 
									100, 
									"Bairro teste",
									"Cidade teste",
						   			"Estado teste",
						   			"01010001")
				   .create();		
		violations = validator.validate(customersEntity);
        assertTrue(violations.isEmpty());
	}
	

}
