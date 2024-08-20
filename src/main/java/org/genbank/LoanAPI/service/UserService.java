package org.genbank.LoanAPI.service;

import org.genbank.LoanAPI.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User saveUser(User user);
    /*public Optional<User> getUserById(Long id);*/
    public User getUserById(Long id);
    public User updateUser(User user,Long id);
    public List<User> getAllUser();
}
