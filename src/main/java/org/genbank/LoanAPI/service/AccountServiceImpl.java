package org.genbank.LoanAPI.service;

import org.genbank.LoanAPI.model.Account;
import org.genbank.LoanAPI.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> getAccount(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account deposit(Integer id, double amount) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setAccountBalance(account.getAccountBalance() + amount);
        return accountRepository.save(account);
    }

    @Override
    public Account withdraw(Integer id, double amount) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getAccountBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        account.setAccountBalance(account.getAccountBalance() - amount);
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccount() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public List<Account> getAllAccountPaging(Integer pageNo, Integer pageSize) {
        Pageable pg = PageRequest.of(pageNo, pageSize);
        Page<Account> pagResult = accountRepository.findAll(pg);

        if(pagResult.hasContent()) {
            return pagResult.getContent();
        }
        else {
            return new ArrayList<Account>();
        }
    }
}
