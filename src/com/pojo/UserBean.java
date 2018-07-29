package com.pojo;

public class UserBean {

	private int id;
	private String username;
	private String password;
	private int levle;			//权限

	public int getLevle() {
		return levle;
	}
	public void setLevle(int levle) {
		this.levle = levle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", username=" + username + ", password="
				+ password + ", levle=" + levle + "]";
	}
	
}
