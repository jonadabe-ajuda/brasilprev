package br.com.brasilprev.application.customers.command;

import br.com.brasilprev.domain.customers.entity.CustomersEntity;
import br.com.brasilprev.domain.repository.RepositoryCustomer;

public class FindCustomerCPF {
	
	private final RepositoryCustomer repositoryCustomer;

	public FindCustomerCPF(RepositoryCustomer repositoryCustomer) {
		this.repositoryCustomer = repositoryCustomer;
	}
	
	public CustomersEntity execute ( String cpf ) {
		return repositoryCustomer.findByCustomer(cpf);
	}	
		

}
