package com.benghuai3.bean;

import java.util.List;

public class User {

	private Integer id;
	private String name;
	private String account;
	private String password;
	private String headPic;
	private List<Log>log;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	public List<Log> getLog() {
		return log;
	}
	public void setLog(List<Log> log) {
		this.log = log;
	}
	
}
