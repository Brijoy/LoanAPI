package org.genbank.LoanAPI.service.serviceImpl;

import lombok.AllArgsConstructor;
import org.genbank.LoanAPI.dto.AccountDto;
import org.genbank.LoanAPI.exception.ResourceNotFoundException;
import org.genbank.LoanAPI.mapper.AccountMapper;
import org.genbank.LoanAPI.model.Account;
import org.genbank.LoanAPI.repository.AccountRepository;
import org.genbank.LoanAPI.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto)
    {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto getAccount(Integer accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new ResourceNotFoundException("Account is not exists with given number : " + accountId)
        );
        return AccountMapper.mapToAccountDto(account);

    }

    @Override
    public AccountDto deposit(Integer id, double amount) {
        //Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        AccountDto accountDto = getAccount(id);
        accountDto.setAccountBalance(accountDto.getAccountBalance() + amount);
        Account saveaccount = accountRepository.save(AccountMapper.mapToAccount(accountDto));
        return AccountMapper.mapToAccountDto(saveaccount);
    }

    @Override
    public AccountDto withdraw(Integer id, double amount) {
        //Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        AccountDto accountDto = getAccount(id);
        if (accountDto.getAccountBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        accountDto.setAccountBalance(accountDto.getAccountBalance() - amount);
        return AccountMapper.mapToAccountDto(accountRepository.save(AccountMapper.mapToAccount(accountDto)));
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
