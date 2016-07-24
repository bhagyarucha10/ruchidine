package dao;

import java.util.List;
import Model.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomerDAOImpl;

@Service
public class CustomerServiceImpl {
     
	@Autowired
    private CustomerDAOImpl customerDAO;
 
    public void setPersonDAO(CustomerDAOImpl productDAO) {
        this.customerDAO = productDAO;
    }
 
   
   @Transactional
    public void addCustomer(Customer p) {
        this.customerDAO.addCustomer(p);
    }
 
  
    @Transactional
    public void updateCustomer(Customer p) {
        this.customerDAO.updateCustomer(p);
    }
 
  
    @Transactional
    public List<Customer> listCustomer() {
        return this.customerDAO.listCustomer();
    }
 
  
    @Transactional
    public Customer getCustomerById(int id) {
        return this.customerDAO.getCustomerById(id);
    }
 
 
    @Transactional
    public void removeCustomer(int id) 
    {
        this.customerDAO.removeCustomer(id);
    }
 
}


