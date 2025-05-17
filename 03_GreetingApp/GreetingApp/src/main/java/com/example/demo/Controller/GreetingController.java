package com.example.demo.Controller;

import com.example.demo.Models.Greeting;
import com.example.demo.Service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired
    private GreetingService service;
    @PostMapping("/")
    public String createGreeting(@RequestBody Greeting g) {
        return service.createGreeting(g.getFirstName(), g.getLastName());
    }

    @GetMapping("/{id}")
    public Optional<Greeting> getGreetedById(@PathVariable long id) {
    	return service.findGreetingById(id);
    }

    @GetMapping("/")
    public List<Greeting> getAllGreetings() {
        return service.findAllGreetings();
    }

    @PutMapping("/{id}")
    public void updateGreeting(@PathVariable long id,@RequestBody Greeting g) {
    	service.updateGreeting(id, g.getFirstName(), g.getLastName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreeting(@PathVariable Long id) {
        service.deleteGreeting(id);
        return ResponseEntity.noContent().build();
    }
}
