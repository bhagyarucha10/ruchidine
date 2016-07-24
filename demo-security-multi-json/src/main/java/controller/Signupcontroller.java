
package controller;
import dao.*;
import Model.*;


	import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
	import org.springframework.ui.ModelMap;
	import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	

	@Controller
	@RequestMapping("/customer")
	public class Signupcontroller {
		
		@Autowired
				CustomerServiceImpl customerService;
		 
		 @Qualifier(value="customerService")
		    public void setCustomerService(CustomerServiceImpl ps){
		        this.customerService = ps;
		    }
		 
		 
		@RequestMapping(value = "/signup",method=RequestMethod.POST)
		public String addCustomer(@Valid @ModelAttribute ("customer") Customer customer,BindingResult result) {

			if (result.hasErrors()) {
				return "registrationform";
			} else {
		
				if(customer.getId()==0)
		    	{
		    		this.customerService.addCustomer(customer);
		    		System.out.println("hi"+customer.getId());
		    	}
		    	else
		    	{
		           
		    	
		    		this.customerService.updateCustomer(customer);
		    	}
		    
				return "index";
			}

		}

		@RequestMapping(method = RequestMethod.GET)
		public String displayCustomerForm(ModelMap model) {

			model.addAttribute("customer", new Customer());
			return "registrationform";

		}

	}

