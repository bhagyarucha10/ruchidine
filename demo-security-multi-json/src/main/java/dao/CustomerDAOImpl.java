package dao;



	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.dao.DataAccessException;
	import org.springframework.dao.EmptyResultDataAccessException;
	import org.springframework.jdbc.core.RowMapper;
	import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
	import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
	import org.springframework.jdbc.core.namedparam.SqlParameterSource;
	import org.springframework.jdbc.support.GeneratedKeyHolder;
	import org.springframework.jdbc.support.KeyHolder;
	import org.springframework.stereotype.Repository;
	import org.springframework.util.StringUtils;

	import Model.Customer;
import Model.Product;

	@Repository
	public class CustomerDAOImpl  {

		
		    private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);
		 
		    @Autowired
		    private SessionFactory sessionFactory;
		     
		    public void setSessionFactory(SessionFactory sf){
		        this.sessionFactory = sf;
		    }
		 
		  
		    public void addCustomer(Customer p)
		    {
		        Session session = this.sessionFactory.getCurrentSession();
		        session.persist(p);
		        logger.info("Customer saved successfully, Customer Details="+p);
		    }
		 
		  
		   public void updateCustomer(Customer c) {
		        Session session = this.sessionFactory.getCurrentSession();
		        session.update(c);
		        logger.info("Customer updated successfully, Customer Details="+c);
		    }
		 
		   @SuppressWarnings("unchecked")
		   
		    public List<Customer> listCustomer() {
		        Session session = this.sessionFactory.getCurrentSession();
		        List<Customer> customer = session.createQuery("from Customer").list();
		        for(Customer p : customer)
		        {
		            logger.info("Customer List::"+p);
		        }
		        return customer;
		    }
		 
		    
		    public Customer getCustomerById(int id) {
		        Session session = this.sessionFactory.getCurrentSession();      
		        Customer p = (Customer) session.load(Customer.class, new Integer(id));
		        logger.info("Customer loaded successfully, Customer details="+p);
		        return p;
		    }
		 

		    public void removeCustomer(int id) {
		        Session session = this.sessionFactory.getCurrentSession();
		        Customer p = (Customer) session.load(Customer.class, new Integer(id));
		        if(null != p){
		            session.delete(p);
		        }
		        logger.info("Customer deleted successfully, customer details="+p);
		    }
		 
		}
		
