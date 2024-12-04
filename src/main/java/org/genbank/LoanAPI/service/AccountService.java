package org.genbank.LoanAPI.service;

import org.genbank.LoanAPI.dto.AccountDto;
import org.genbank.LoanAPI.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public AccountDto createAccount(AccountDto account);
    //public Optional<Account> getAcc(Integer id);
    public AccountDto getAccount(Integer accountId);
    /*public Account deposit(Integer id, double amount);
    public Account withdraw(Integer id, double amount);*/
    public AccountDto deposit(Integer id, double amount);
    public AccountDto withdraw(Integer id, double amount);
    public List<Account> getAllAccount();
    public List<Account> getAllAccountPaging(Integer pageNo,Integer pageSize);
}
