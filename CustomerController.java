package com.CRMApp;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/")
	public String customersList(Map<String, List<Customer>> map)
	{
		List<Customer> customers = this.customerService.getcustomerList();
		map.put("customers", customers);
		return "index";
	}

	@GetMapping("/cusEditForm")
	public String studentsList(int id) {
		System.out.println(id);
		return "cusEditForm";
	}

	@GetMapping("/search")
	public String searchBook(@RequestParam(required = false) String sName,
			Map<String, List<Customer>> map)
	{
		List<Customer> customers = this.customerService.searchBy(sName);
		map.put("customers", customers);
		return "index";
	}


	@GetMapping("/delete")
	public  String deleteStudentForm(@RequestParam int id)
	{
		customerService.deleteById(id);
		return "redirect:/";
	}

	@GetMapping("/add")
	public String addBook(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "registrationForm";
	}	

	@PostMapping("/save")
	public String addOrUpdateBook(Customer customer)
	{
		System.out.println("saving "+customer);
		this.customerService.save(customer);
		return "redirect:/";
	}


	@PostMapping("/updateInfo") 
	public String UpdateInfo(Customer customer) {
		System.out.println("Updating "+customer);
		this.customerService.updateById(customer); 
		return "redirect:/"; 
	}	
}		
