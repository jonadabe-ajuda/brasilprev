package br.com.brasilprev.application.customers.command;

import br.com.brasilprev.application.customers.FactoryCustomers;
import br.com.brasilprev.application.customers.dto.CustomerDTO;
import br.com.brasilprev.domain.customers.entity.CustomersEntity;
import br.com.brasilprev.domain.repository.RepositoryCustomer;

public class SaveCustomer {
	
	private final RepositoryCustomer repositoryCustomer;

	public SaveCustomer(RepositoryCustomer repositoryCustomer) {
		this.repositoryCustomer = repositoryCustomer;
	}
	
	public void execute ( CustomerDTO customerDTO ) {
		CustomersEntity customersEntity = new FactoryCustomers()
										   .withCPFName(customerDTO.getCpf(), customerDTO.getName())
										   .addressComplete(customerDTO.getStreet(), 
												   			customerDTO.getNumber(), 
												   			customerDTO.getDistrict(),
												   			customerDTO.getCity(),
												   			customerDTO.getState(),
												   			customerDTO.getZipCode())
										   .create();
		
		repositoryCustomer.insertCustomer(customersEntity);
		
	}

}