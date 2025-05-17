package com.example.demo.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
@Table(name="greetings")
public class Greeting {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String message;
	 public Greeting() {}
	public Greeting(String firstname,String lastname) {
		this.firstName=firstname;
		this.lastName=lastname;
		this.message=generateMessage(firstname,lastname);
	}
	private String generateMessage(String firstName,String lastName) {
		if(firstName!=null&&lastName!=null) {
			return "Helloo "+firstName+" "+lastName+"!!!";
		}else if(firstName!=null) {
			return "Heyyy;) "+firstName;
		}else if(lastName!=null) {
			return "Hellooo there ;-) "+lastName;
		}
		return "Helloo😁 from Greeting Application created by Developer Bhakya";
	}
	public Long getId() {return id;}
	public void setId(Long id) {this.id=id;}
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
		this.message = generateMessage(this.firstName, this.lastName);
		}
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {
		this.lastName=lastName;
	    this.message = generateMessage(this.firstName, this.lastName);
}
	public String getMessage() {return message;}
}
