package io.demo.springboot.controller;


import java.util.Arrays;
import java.util.List;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.demo.springboot.model.Customer;
import io.demo.springboot.service.customerService;

@RestController
public class CustomerController {
	
	@Autowired
	private RestTemplate restTemplate;
		
	private static final Logger logger = Logger.getLogger("CustomerController");
	
		@Autowired
		private customerService custService;
		@PostMapping("/AddCustomer")
		public Customer addCustomer(@RequestBody Customer customer) {
			logger.info(" addCustomer method start");
			return custService.saveCustomer(customer);
		}
		@PostMapping("/AddCustomers")
		public List<Customer> addCustomers(@RequestBody List<Customer> customer) {
			logger.info(" addCustomers method start");
			return custService.saveCustomers(customer);
		}
		@GetMapping("/GetCustomer")
		public List<Customer> findAllCustomer(){
			logger.info(" findAllCustomers method start");
			return custService.getCustomer();
		
}
		
		@GetMapping("/response")
		public  List<Object> getrest(){
			logger.info(" findAllCustomers method start");
			
			 String url="https://mocki.io/v1/d4867d8b-b5d5-4a48-a4ab-79131b5809b8";
			   Object[] list=restTemplate.getForObject(url,Object[].class);
			   return Arrays.asList(list);
}
		
		@GetMapping("/responsep")
		public  String getrests(){
			
			   return "hello world";
}
		@DeleteMapping("/DeleteCustomer/{id}")
		public String deleteCustomer(@PathVariable int id){
			logger.info(" deleteCustomer method start");
			return custService.deleteCustomer(id);
}
}

