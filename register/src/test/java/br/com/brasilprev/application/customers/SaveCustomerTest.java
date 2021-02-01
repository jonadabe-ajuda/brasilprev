package br.com.brasilprev.application.customers;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import br.com.brasilprev.application.customers.command.RecoverCustomerCPF;
import br.com.brasilprev.application.customers.command.SaveCustomer;
import br.com.brasilprev.application.customers.dto.CustomerDTO;
import br.com.brasilprev.infra.customers.RepositoryCustomersMysql;


public class SaveCustomerTest {

	@Test
	@Disabled("Test executed in enviroment develop")
	public void saveCustomer() {
		SaveCustomer saveCustomer = new SaveCustomer(new RepositoryCustomersMysql("brasil-prev"));
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCpf("12345678924");
		customerDTO.setName("Cliente tres");
		customerDTO.setStreet("Rua dos teste");
		customerDTO.setNumber(12);
		customerDTO.setDistrict("Bairro teste");
		customerDTO.setCity("Cidade teste");
		customerDTO.setState("Estado teste");
		customerDTO.setZipCode("01500001");
		saveCustomer.execute(customerDTO);
		
		RecoverCustomerCPF findCustomerCPF = new RecoverCustomerCPF(new RepositoryCustomersMysql("brasil-prev"));
		assertEquals("Cliente um", findCustomerCPF.execute("12345678901").getName());
		
	}

}
