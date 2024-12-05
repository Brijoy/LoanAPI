package org.genbank.LoanAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.genbank.LoanAPI.model.User;

/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    Integer accountNo;
    Double accountBalance;
    Character status;
    Integer loanId;


    *//*@JsonBackReference
    @OneToOne(mappedBy = "account")*//*
    private User user;
}*/

public record AccountDto(Integer accountNo,
        Double accountBalance,
        Character status,
        Integer loanId,
User user){

}