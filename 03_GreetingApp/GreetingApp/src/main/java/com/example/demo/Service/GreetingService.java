package com.example.demo.Service;
import com.example.demo.Models.*;
import com.example.demo.Repository.GreetingRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
@Service
public class GreetingService {
	@Autowired
	private GreetingRepository repo;
	public String createGreeting(String firstName,String lastName) {
		repo.save(new Greeting(firstName,lastName));
		return "Hello;) " + firstName+" "+lastName;
	}
	public List<Greeting> findAllGreetings(){
		return repo.findAll();
	}
	public Optional<Greeting> findGreetingById(Long id){
		return repo.findById(id);
		}
	public Greeting updateGreeting(Long id,String firstName,String lastName) {
		return repo.findById(id).map(greeting -> {greeting.setFirstName(firstName);
        greeting.setLastName(lastName);
        return repo.save(greeting);
	}).orElse(null);
	}
	public void deleteGreeting(Long id) {
		repo.deleteById(id);
	}
}
