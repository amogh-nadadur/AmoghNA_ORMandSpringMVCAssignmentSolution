package com.CRMApp;

import java.util.List;

public interface CustomerService {

	public List<Customer> getcustomerList();

	public List<Customer> searchBy(String sName);

	public void deleteById(int id);

	public void save(Customer customer);

	public void updateById(Customer customer);

	public Customer findById(int theId);

}