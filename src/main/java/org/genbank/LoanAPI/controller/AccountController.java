package org.genbank.LoanAPI.controller;

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
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.createAccount(account),HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccount() {
        // List<Account> option = accountService.getAllAccount().orElseThrow(() -> new RuntimeException("Account's not found"));
        return  ResponseEntity.ok(accountService.getAllAccount());
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Integer id) {
        return accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @PostMapping("/{id}/deposit")
    public Account deposit(@PathVariable Integer id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("accountBalance");
        return accountService.deposit(id, amount);
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Account> withdraw(@PathVariable Integer id, @RequestBody Map<String, Double> request) {
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