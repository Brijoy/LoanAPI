package org.genbank.LoanAPI.mapper;

import org.genbank.LoanAPI.dto.AccountDto;
import org.genbank.LoanAPI.model.Account;

public class AccountMapper {

    public static AccountDto mapToAccountDto(Account account){
        return new AccountDto(account.getAccountNo(),
                account.getAccountBalance(),
                account.getStatus(),
                account.getLoanId(),
                account.getUser());

    }

    public static Account mapToAccount(AccountDto accountDto){
        /*return new Account(accountDto.getAccountNo(),
                accountDto.getAccountBalance(),
                accountDto.getStatus(),
                accountDto.getLoanId(),
                accountDto.getUser());*/

        return new Account(accountDto.accountNo(),
                accountDto.accountBalance(),
                accountDto.status(),
                accountDto.loanId(),
                accountDto.user());

    }

}
