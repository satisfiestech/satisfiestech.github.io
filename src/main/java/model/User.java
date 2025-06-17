package model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;  // Store encrypted password
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	public CharSequence getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	
	public void setPassword(String password) {
	    this.password = password;
	}
	
	public void setEmail(String email) {
	    this.email = email;
	}

    // Getters & Setters
	
	
}

