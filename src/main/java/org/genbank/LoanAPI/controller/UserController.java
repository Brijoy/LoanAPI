package org.genbank.LoanAPI.controller;

import org.genbank.LoanAPI.model.User;
import org.genbank.LoanAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User creatUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    
    @GetMapping("/{id}")
    public User getAccount(@PathVariable Long id) {
        return userService.getUserById(id);
        
    }
    
    
    @PutMapping("/update/{id}")
	public User updateUser(@RequestBody User user, @PathVariable("id") Long id ) {
		return userService.updateUser(user, id);
	}


}
