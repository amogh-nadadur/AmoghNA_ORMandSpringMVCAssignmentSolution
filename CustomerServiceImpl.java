package com.CRMApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getcustomerList() {
		//System.out.println(this.sessionFactory);
		Session session = this.sessionFactory.openSession();
		List<Customer> list1 = session.createQuery("from Customer").list();
		session.close();
		return list1;
	}
	
	@Override
	public List<Customer> searchBy(String sName) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String query="";
		if(sName.length()!=0) {
			query ="from Customer where firstName like '%"+sName+"%'";
		}			
		else {
			System.out.println("Cannot search without input data");
			
		}
			
		System.out.println(query);
		
		tx.commit();
		session.clear();
		List<Customer> customers = session.createQuery(query).list();
		System.out.println(customers);
		return customers;
	}
	
	@Override
	public void save(Customer theCustomer) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(theCustomer);
		tx.commit();
		session.close();

	}
		
	
	
	/*
	 * @Override public void updateById(int id) {
	 * 
	 * Session session = this.sessionFactory.openSession(); Transaction tx =
	 * session.beginTransaction(); session.saveOrUpdate(theCustomer); tx.commit();
	 * session.close();
	 * }
	 */
	 
	 
	
	@Override
	public Customer findById(int theId) {
		Session session = this.sessionFactory.openSession();
		Customer customer = session.get(Customer.class, theId);
		session.close();
		return customer;
	}

	@Override
	public void deleteById(int theId) {
		Session session = this.sessionFactory.openSession();
		Customer customer = findById(theId);
		if(customer!=null)
		{
			Transaction tx = session.beginTransaction();
			session.delete(customer);
			tx.commit();
		}
		session.close();
	}


	public void updateById(Customer theCustomer) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(theCustomer);
		tx.commit();
		session.close();

	}
}