package com.noahgardner.beltexam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name is required")
	@Size(min=3,message="Name must be at least 3 characters")
	private String name;
	
	@NotBlank(message="Email is required")
	@Email(message="Please enter a valid email")
	private String email;
	
	@NotBlank(message="Password is required")
	@Size(min=8,message="Password must be at least 8 characters")
	private String password;
	
	@Transient
	@NotBlank(message="Confirm password is required")
	private String confirm;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Rating> ratings;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Show> shows;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}
	
	// CONSTRUCTOR //
	public User() {}
	
	// GETTERS AND SETTERS //
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}	
	
}
