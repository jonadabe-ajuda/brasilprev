package br.com.brasilprev.application.customers;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.brasilprev.application.customers.command.RecoverCustomerCPF;
import br.com.brasilprev.application.customers.command.UpdateCustomer;
import br.com.brasilprev.application.customers.dto.CustomerDTO;
import br.com.brasilprev.infra.customers.RepositoryCustomersMysql;

class UpdateCustomerTest {

	@Test
	void update() {

			UpdateCustomer updateCustomer = new UpdateCustomer(new RepositoryCustomersMysql("brasil-prev"));
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCpf("12345678913");
			customerDTO.setName("Cliente treza");
			customerDTO.setStreet("Rua dos treza");
			customerDTO.setNumber(12);
			customerDTO.setDistrict("Bairro treza");
			customerDTO.setCity("Cidade treza");
			customerDTO.setState("Estado treza");
			customerDTO.setZipCode("01500010");
			updateCustomer.execute(customerDTO);
			
			RecoverCustomerCPF findCustomerCPF = new RecoverCustomerCPF(new RepositoryCustomersMysql("brasil-prev"));
			assertEquals("Cliente treza", findCustomerCPF.execute("12345678913").getName());

	}
	
}
