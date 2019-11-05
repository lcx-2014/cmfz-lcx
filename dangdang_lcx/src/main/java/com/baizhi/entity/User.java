package com.baizhi.entity;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
	private String id;
	private String email;
	private String password;
	private String salt;
	private String nickname;
	private String status;
	private String code;
	private Date createdate;
	public User() {
		super();
	}
	public User(String id, String email, String password, String salt,
			String nickname, String status, String code, Date createdate) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.nickname = nickname;
		this.status = status;
		this.code = code;
		this.createdate = createdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password
				+ ", salt=" + salt + ", nickname=" + nickname + ", status="
				+ status + ", code=" + code + ", createdate=" + createdate
				+ "]";
	}
	
}
