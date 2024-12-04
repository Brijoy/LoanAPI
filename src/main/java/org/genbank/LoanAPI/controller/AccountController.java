package org.genbank.LoanAPI.controller;

import org.genbank.LoanAPI.dto.AccountDto;
import org.genbank.LoanAPI.model.Account;
import org.genbank.LoanAPI.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccount() {
        // List<Account> option = accountService.getAllAccount().orElseThrow(() -> new RuntimeException("Account's not found"));
        return  ResponseEntity.ok(accountService.getAllAccount());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable("id") Integer accountId) {
        //return accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        return ResponseEntity.ok(accountService.getAccount(accountId));
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Integer id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("accountBalance");
        return new ResponseEntity<>(accountService.deposit(id, amount),HttpStatus.CREATED);
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Integer id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("accountBalance");
        return new ResponseEntity<>(accountService.withdraw(id, amount),HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccountPaging(@RequestParam (defaultValue ="0")Integer pageNo,
                                                             @RequestParam(defaultValue ="10")Integer pageSize){
        List<Account> list = accountService.getAllAccountPaging(pageNo,pageSize);
        return new ResponseEntity<List<Account>>(list,new HttpHeaders(), HttpStatus.OK);
    }
}