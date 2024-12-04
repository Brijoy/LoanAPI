package org.genbank.LoanAPI.model;

import jakarta.persistence.*;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users_master")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;


    //@EmbeddedId
    @Embedded
    private Name name;
    @JsonManagedReference
    @OneToOne
    //(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_no",referencedColumnName = "account_no")
    private Account account;

   public User() {}


    public User(Name name, Account account) {
        this.name = name;
        this.account = account;
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", account=" + account + "]";
	}
    
    
}
