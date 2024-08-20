package org.genbank.LoanAPI.service;


import org.genbank.LoanAPI.exception.AccountNotFoundException;
import org.genbank.LoanAPI.exception.UserNotFoundException;
import org.genbank.LoanAPI.model.Account;
import org.genbank.LoanAPI.model.Name;
import org.genbank.LoanAPI.model.User;
import org.genbank.LoanAPI.repository.AccountRepository;
import org.genbank.LoanAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    @Override
    public User saveUser(User user) {
        Name name = new Name(user.getName().getFirstName(),
                user.getName().getMiddleName(),user.getName().getLastName());
        System.out.println(name);

        Account acc = new Account(
                user.getAccount().getAccountBalance(),user.getAccount().getStatus(),
                user.getAccount().getLoanId(),
                user);


        Account id = accountRepository.save(acc);
       // user.getAccount(id.setAccountNo());
        user.getAccount().setAccountNo(id.getAccountNo());

        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
		 User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return user;
    }

    @Transactional
    @Override
    public User updateUser( User user,Long id) {
       User user1 = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        user1.getName().setFirstName(user.getName().getFirstName());
        user1.getName().setMiddleName(user.getName().getMiddleName());
        user1.getName().setLastName(user.getName().getLastName());
        
        Account account = accountRepository.findById(user.getAccount().getAccountNo()).orElseThrow(AccountNotFoundException::new);
        account.setAccountBalance(user.getAccount().getAccountBalance());
        account.setStatus(user.getAccount().getStatus());
        
        accountRepository.save(account);
        
        return userRepository.save(user1);
    }

    @Override
    public List<User> getAllUser() {
    	 List<User> users = new ArrayList<>();
    	    Iterable<User> userAll = userRepository.findAll();
    	    for (User customer : userAll) {
    	        users.add(customer);
    	    }
    	 return users;
    	
        
    }
}
