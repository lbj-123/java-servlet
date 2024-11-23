package com.example.news.beans;
public class User implements java.io.Serializable {
	private Integer id;
	private String username;
	private String password;
	private String gender;
	private String resume;
	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String username, String password, String role,
			String address) {
		this.username = username;
		this.password = password;
		this.gender = role;
		this.resume = address;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

}
