package com.user.role.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Laxman.Nikam User Roll
 */
@Entity
@Table(name = "user_roll")
public class UserRoll implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	public UserRoll() {
		super();
	}

	@Id
	@Column(name = "rollId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rollId;

	@Column(name = "roll_name", length = 255)
	private String rollName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "userRoll")
	private List<User> userList;


	public Integer getRollId() {
		return rollId;
	}

	public void setRollId(Integer rollId) {
		this.rollId = rollId;
	}

	public String getRollName() {
		return rollName;
	}

	public void setRollName(String rollName) {
		this.rollName = rollName;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
