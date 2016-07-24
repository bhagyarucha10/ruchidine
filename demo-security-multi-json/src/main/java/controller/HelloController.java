package controller;

import dao.ProductDAOImpl;
import dao.productServices;

import Model.*;


import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.io.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.google.gson.Gson;

	@EnableWebMvc
	@Controller
	public class HelloController  {
		
		@Autowired
		  public productServices productService;
		
		  
		/*@RequestMapping(value = "/signup", method = RequestMethod.POST)
		public String addCustomer(@Valid Customer customer, BindingResult result) {

			if (result.hasErrors()) {
				return "SignUpForm";
			} else {
				return "Done";
			}

		}

		@RequestMapping(method = RequestMethod.GET)
		public String displayCustomerForm(ModelMap model) {

			model.addAttribute("customer", new Customer());
			return "registrationform";

		}

		*/
		
		@RequestMapping(value="/mailModal")
		public String displayMail()

		{
			return "mailModal";

		}
		
		@Qualifier(value="productService")
	    public void setPersonService(productServices ps){
	        this.productService = ps;
	    }
		@RequestMapping("/login")
	    public String showIndex1()
	    {
	    	return "login";
	    }
		
		
		@RequestMapping("/prodDesc")
	    public String prodDesc()
	    {
	    	return "prodDesc";
	    }
		
		
		@RequestMapping("/")
	    public String showIndex()
	    {
	    	return "index";
	    }
		/* @RequestMapping("/index")
		    public String showIndexNow()
		    {
		    	return "index";
		    }*/
		@RequestMapping("/registertrationform")
	   public String addproduct1()
	    
	    {
			//ModelAndView modelAndView = new ModelAndView("addproduct");

			
	      //  modelAndView.addObject("product", new Product());

	    	return "registrationform";
	    }
		@RequestMapping("/logout")
		   public String logout()
		    
		    {
				//ModelAndView modelAndView = new ModelAndView("addproduct");

				
		      //  modelAndView.addObject("product", new Product());

		    	return "logout";
		    }
			
				    
		    	   
		@RequestMapping(value= "/productpage", method = RequestMethod.GET)
		    public String ListAllProducts(Model model)
		    {
		    	
		    	//model.addAttribute("product",new Product());
		    			model.addAttribute("listed",this.productService.listProduct());
		    	return "productpage";
		    	    }

		
		@RequestMapping("/productTableUsers")
		//@ResponseBody
		public ModelAndView showHome()
		{
			List<Product> listtojsp=new ArrayList<Product>();
			listtojsp=productService.listProduct();
			String json = new Gson().toJson(listtojsp);  // converting list into Google Gson object which is a string
			System.out.println(json);
			ModelAndView mv=new ModelAndView("productTableUsers");
			mv.addObject("myJson", json);
			return mv;
		}
		      
		 @RequestMapping("/details/{id}")
		    public String getProductById(@PathVariable("id") int id,Model model)
		    		
		    {
		    	
		    	model.addAttribute("product",this.productService.getProductById(id));
		    			model.addAttribute("listed",this.productService.listProduct());
		    	return "prodDesc";
		    	    }
 	
		     
		    @RequestMapping(value="/delete/{id}")
		   
		    public String removeProduct(@PathVariable("id") int id)
		    {
		    	this.productService.removeProduct(id);
		    	return "redirect:/productpage";
		    }
		    
		   

		     
		   
		    @RequestMapping(value= "/edit/{id}")
		    public String updateProduct(@ModelAttribute("product") Product p)
		    {
		    	
		            
		    	
		    	this.productService.updateProduct(p);
		    
		        
		    	return "index ";
		    }
		    @RequestMapping(value= "/addproduct", method = RequestMethod.GET)
		    public String addProduct(@ModelAttribute ("product") Product p)
		    	
		    {
		    	
		    	
		    	if(p.getId()==0)
		    	{
		    		this.productService.addProduct(p);
		    		//System.out.println("hi"+customer.getId());
		    	}
		    	else
		    	{
		           
		    	
		    		this.productService.updateProduct(p);
		    	}
		    	
		    
		        
		    	return "addproduct";
		    }
		    
		    @Autowired
			private JavaMailSender mailSender;
			
			@RequestMapping(value="/sendEmail", method = RequestMethod.POST)
		    public String doSendEmail(HttpServletRequest request) 
		    {
		        // takes input from e-mail form
		        String recipientAddress = request.getParameter("email");
		  
		        String fname=request.getParameter("first_name");
		        String subject ="musichub :: Your Friend Recommends..."+ request.getParameter("musichub alert");
		        String message = request.getParameter("comments");
		        String finalmessage="Hi "+fname+", "+" "+message+"!!! "+"Check this out!!!";
		         
		        // prints debug info
		        System.out.println("To: " + recipientAddress);
		        System.out.println("Subject: " + subject);
		        System.out.println("Message: " + finalmessage);
		         
		        // creates a simple e-mail object
		        SimpleMailMessage email = new SimpleMailMessage();
		        email.setTo(recipientAddress);
		        email.setSubject(subject);
		        email.setText(finalmessage);
		         
		        // sends the e-mail
		        mailSender.send(email);
		         
		        // forwards to the view named "Result"
		        return "redirect:/index";
		    }
			    
	}
		   