package br.com.brasilprev.infra.customers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.brasilprev.application.customers.FactoryCustomers;
import br.com.brasilprev.domain.customers.entity.CustomersEntity;
import br.com.brasilprev.domain.customers.model.Customers;
import br.com.brasilprev.domain.repository.RepositoryCustomer;


/**
 * Repository customers with jpa used in mysql
 *  
 * @author jonadabe
 * @param  methods Constructor RepositoryCustomer
 * @param  methods insertCustomer CustomersEntity
 * @param  methods updateCustomer CustomersEntity
 * @param  methods deleteCustomer CustomersEntity
 * @param  methods findByCustomer Strng cpf
 * @param  methods convertToCustomerEntity Customers
 * @param  methods convertToCustomer CustomersEntity
 * @return findByCustomer CustomerEntity
 * @return listaAllCustomers List<CustomersEntity>
 */
public class RepositoryCustomersMysql implements RepositoryCustomer {
	
	private final String unitPersistence;
	
	public RepositoryCustomersMysql(String unitPersistence) {
		super();
		this.unitPersistence = unitPersistence;
	}

	public void insertCustomer(CustomersEntity customersEntity) {
		EntityManager em = entityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(convertToCustomer(customersEntity));
		em.getTransaction().commit();
		
	}

	public void updateCustomer(CustomersEntity customersEntity) {
		EntityManager em = entityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Customers customer =  bankFindByCustomer(em, customersEntity.getCpf().getNumber());
		customer.setName(customersEntity.getName());
		customer.setStreet(customersEntity.getAddress().getStreet());
		customer.setNumber(customersEntity.getAddress().getNumber());
		customer.setDistrict(customersEntity.getAddress().getDistrict());
		customer.setCity(customersEntity.getAddress().getCity());
		customer.setState(customersEntity.getAddress().getState());
		customer.setZipCode(customersEntity.getAddress().getZipCode());
		em.getTransaction().commit();		
		
	}

	public void deleteCustomer(CustomersEntity customersEntity) {
		EntityManager em = entityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Customers customer =  bankFindByCustomer(em, customersEntity.getCpf().getNumber());
		em.remove(customer);
		em.getTransaction().commit();
	}	
	
	public CustomersEntity findByCustomer(String cpf) {
		EntityManager em = entityManagerFactory().createEntityManager();
		return convertToCustomerEntity(bankFindByCustomer(em,cpf));
	}

	public List<CustomersEntity> listaAllCustomers() {

		EntityManager em = entityManagerFactory().createEntityManager();
		String sql = "SELECT customers FROM Customers customers ";
		Query query = em.createQuery(sql);
		List<Customers> listCustomers = new ArrayList<Customers>();
		List<CustomersEntity> listCustomersEntity = new ArrayList<CustomersEntity>();
		listCustomers = query.getResultList();
		listCustomers.forEach( customer -> {
			listCustomersEntity.add(convertToCustomerEntity(customer));
		});
		return listCustomersEntity;
	}
	
	private Customers bankFindByCustomer(EntityManager em, String cpf) {
		String sql = "SELECT customers FROM Customers customers where customers.cpf = :cpf ";
		Query query = em.createQuery(sql);
		query.setParameter("cpf",cpf);
		query.setMaxResults(1);
		return (Customers) query.getSingleResult();		
	}
	
	private CustomersEntity convertToCustomerEntity( Customers customer ) {
		CustomersEntity customersEntity = new FactoryCustomers()
		   .withCPFName(customer.getCpf(), customer.getName())
		   .addressComplete(customer.getStreet(), 
							customer.getNumber(), 
							customer.getDistrict(),
							customer.getCity(),
				   			customer.getState(),
				   			customer.getZipCode())
		   .create();		
		return customersEntity;
	}
	
	private Customers convertToCustomer( CustomersEntity customerEntity ) {
		Customers customer = new Customers();
		customer.setCpf(customerEntity.getCpf().getNumber());
		customer.setName(customerEntity.getName());
		customer.setStreet(customerEntity.getAddress().getStreet());
		customer.setNumber(customerEntity.getAddress().getNumber());
		customer.setDistrict(customerEntity.getAddress().getDistrict());
		customer.setCity(customerEntity.getAddress().getCity());
		customer.setState(customerEntity.getAddress().getState());
		customer.setZipCode(customerEntity.getAddress().getZipCode());
		return customer;
	}
	
	
	private EntityManagerFactory entityManagerFactory() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitPersistence);
		return emf; 
	}



}
