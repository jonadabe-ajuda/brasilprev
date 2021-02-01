package br.com.brasilprev.application.customers;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.Test;

import br.com.brasilprev.application.customers.command.DeleteCustomer;
import br.com.brasilprev.application.customers.command.RecoverCustomerCPF;
import br.com.brasilprev.application.customers.command.UpdateCustomer;
import br.com.brasilprev.application.customers.dto.CustomerDTO;
import br.com.brasilprev.infra.customers.RepositoryCustomersMysql;

class DeleteCustomerTest {

	@Test
	void delete() {
		DeleteCustomer deleteCustomer = new DeleteCustomer(new RepositoryCustomersMysql("brasil-prev"));
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCpf("12345678912");
		deleteCustomer.execute(customerDTO);
		
		RecoverCustomerCPF findCustomerCPF = new RecoverCustomerCPF(new RepositoryCustomersMysql("brasil-prev"));
		//assertThrows(Exception, findCustomerCPF.execute("12345678913").getName());
	}

}
