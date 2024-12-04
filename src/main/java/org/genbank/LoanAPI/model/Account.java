package org.genbank.LoanAPI.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_master")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "account_no")
	Integer accountNo;
	@Column(name = "account_balance")
	Double accountBalance;
	@Column(name = "status")
	Character status;
	@Column(name = "loan_id")
	Integer loanId;
	

	@JsonBackReference
	@OneToOne(mappedBy = "account")
	private User user;

	public Account(Double accountBalance, Character status, Integer loanId, User user) {
		this.accountBalance = accountBalance;
		this.status = status;
		this.loanId = loanId;
		this.user = user;
	}



	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountBalance=" + accountBalance + ", status=" + status
				+ ", loanId=" + loanId + ", user=" + user + "]";
	}

}
