
package Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


@Entity
@Table(name="customer")
public class Customer {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	@NotEmpty
	String name;
	 @NotEmpty @Email
	public String email;
	 	public int phone;
	public String password;
	public String confirmpassword;
	public Customer()
	{
	
	
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}