package org.genbank.LoanAPI.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

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

	public Account() {

	}

	public Account(Double accountBalance, Character status, Integer loanId, User user) {
		this.accountBalance = accountBalance;
		this.status = status;
		this.loanId = loanId;
		this.user = user;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountBalance=" + accountBalance + ", status=" + status
				+ ", loanId=" + loanId + ", user=" + user + "]";
	}

}
