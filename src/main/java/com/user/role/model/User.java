package com.user.role.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Laxman.Nikam User
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Column(name = "user_name", length = 255)
	private String userName;

	@Column(name = "password", length = 255)
	private String password;

	@Column(name = "mobile_no")
	private Long mobileNo;
	 
	@Column(name = "email_id", length = 255)
	private String emailId;
	
	@Column(name = "authorize",length = 15)
	private String authorize;

	@Column(name="approveuser")
	private boolean approveUser;

	@ManyToOne
	@JoinColumn(name = "rollId")
	private UserRoll userRoll;

	@JsonIgnore
	@OneToMany(mappedBy = "personUser")
	private List<Person> personList;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public UserRoll getUserRoll() {
		return userRoll;
	}

	public void setUserRoll(UserRoll userRoll) {
		this.userRoll = userRoll;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthorize() {
		return authorize;
	}

	public void setAuthorize(String authorize) {
		this.authorize = authorize;
	}


	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}


	public boolean isApproveUser() {
		return approveUser;
	}

	public void setApproveUser(boolean approveUser) {
		this.approveUser = approveUser;
	}
}
