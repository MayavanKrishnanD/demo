package io.demo.springboot.service;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.demo.springboot.controller.CustomerController;
import io.demo.springboot.model.Customer;
import io.demo.springboot.repo.CustomerRepository;
@Service
public class customerService {
	private static final Logger logger=Logger.getLogger("customerService");
	@Autowired
	private CustomerRepository  repository ;

		
		public Customer saveCustomer(Customer customer) {
			logger.info(" customer method start");
		return	repository.save(customer);
		}
		public List<Customer>  saveCustomers(List<Customer> customers) {
			logger.info(" customers method start");
			return	repository.saveAll(customers);
}
		public List<Customer> getCustomer(){
			logger.info(" allcustomer method start");
			return repository.findAll();
			
		}
		public String deleteCustomer(int id ){
			logger.info("  Delete Customer method start");
			repository.deleteById(id);
			return "Customer removed || ";
}
}
