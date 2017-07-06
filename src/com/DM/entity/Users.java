package com.DM.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	
	@Column(name="typeOfUser")
	private int typeOfUser;
	
	@Column(name="passwordUser")
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="dustbinId")
	private int dustbinId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTypeOfUser() {
		return typeOfUser;
	}

	public void setTypeOfUser(int typeOfUser) {
		this.typeOfUser = typeOfUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDustbinId() {
		return dustbinId;
	}

	public void setDustbinId(int dustbinId) {
		this.dustbinId = dustbinId;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", typeOfUser=" + typeOfUser + ", password=" + password + ", name=" + name
				+ ", dustbinId=" + dustbinId + "]";
	}
	

}
