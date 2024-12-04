package org.genbank.LoanAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "USER_INFO")
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "user_name", nullable = false)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "email_id", unique = true, length = 100, nullable = false)
	private String emailId;
	@Column(name = "roles", nullable = false)
	private String roles;
	//@CreationTimestamp
	@Column(updatable = false, name = "created_at")
	private Date createdAt;

	//@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

	public UserInfo() {
	}

	public UserInfo( String userName, String password, String emailId, String roles, Date createdAt, Date updatedAt) {

		this.username = userName;
		this.password = password;
		this.emailId = emailId;
		this.roles = roles;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"userId=" + userId +
				", userName='" + username + '\'' +
				", password='" + password + '\'' +
				", emailId='" + emailId + '\'' +
				", roles='" + roles + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				'}';
	}


}
