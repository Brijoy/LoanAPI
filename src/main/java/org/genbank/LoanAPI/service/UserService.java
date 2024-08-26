package org.genbank.LoanAPI.service;

import org.genbank.LoanAPI.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User saveUser(User user);
    /*public Optional<User> getUserById(Long id);*/
    
    @Cacheable(value = "user",key = "#id" )
    public User getUserById(Long id);
    public User updateUser(User user,Long id);
    
    @CacheEvict(value = "users",allEntries = true)
    public List<User> getAllUser();
}
