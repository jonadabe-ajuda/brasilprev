package br.com.brasilprev.domain.customer;


import static org.junit.Assert.assertFalse;

import java.util.Set;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.brasilprev.application.customers.FactoryCustomers;
import br.com.brasilprev.domain.customers.entity.CustomersEntity;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class CustomersAddressTest {
	
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
				   .withCPFName("12345678901", "Teste da silva")
				   .addressComplete(null,100,null,null,null,"01010001")
				   .create();	
		violations = validator.validate(customersEntityNull);
        assertFalse(violations.isEmpty());
        
        
		CustomersEntity customersEntityBlank = new FactoryCustomers()
				   .withCPFName("12345678901", "Teste da silva")
				   .addressComplete("",0,"","","","01010001")
				   .create();	       
		violations = validator.validate(customersEntityBlank);
        assertFalse(violations.isEmpty());
	}
	
	@Test
	public void fieldSizeMin() {
		CustomersEntity customersEntity = new FactoryCustomers()
				   .withCPFName("12345678901", "Teste da silva")
				   .addressComplete("Rua", 
									100, 
									"Ba",
									"Ci",
						   			"Es",
						   			"01010001")
				   .create();			
		violations = validator.validate(customersEntity);
		assertFalse(violations.isEmpty());
	}	
	
	@Test
	public void fieldSizeMinCep() {
		CustomersEntity customersEntity = new FactoryCustomers()
				   .withCPFName("12345678901", "Teste da silva")
				   .addressComplete("Rua dos teste", 
									100, 
									"Bairro dos teste",
									"Cidade dos teste",
						   			"Estado dos teste",
						   			"0101")
				   .create();			
		violations = validator.validate(customersEntity);
		assertFalse(violations.isEmpty());
	}	
	

}
