/**
 * 
 */
package com.cts.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author HP
 *
 */
@Document
public class User {
	
	private String username;
	private String password;
	private boolean enable;
	private String authorities;
	private boolean locked;
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
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public String getAuthorities() {
		return authorities;
	}
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	
}
