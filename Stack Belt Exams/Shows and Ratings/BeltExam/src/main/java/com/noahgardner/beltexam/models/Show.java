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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="shows")
public class Show {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Title cannot be blank")
	@Size(min=2, message="Title must be at least 2 characters")
	private String title;
	
	@NotBlank(message = "Network cannot be blank")
	@Size(min=2, message="Network must be at least 2 characters")
	private String network;
	
	@NotBlank(message = "Description cannot be blank")
	@Size(min=2, max=400, message="Description must be between 10 and 400 characters")
	private String description;
	
	@OneToMany(mappedBy="show", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Rating> ratings;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
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
	public Show() {}
	
	// GETTERS AND SETTERS //
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
