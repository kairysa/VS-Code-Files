package com.noahgardner.burgerlist.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burgers")
public class Burger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Must not be blank")
	@Size(min = 5, max = 200, message="Must be between 5 and 200 characters")
	private String burgerName;
	
	@NotNull(message="Must not be blank")
	@Size(min = 5, max = 200, message="Must be between 5 and 200 characters")
	private String restaurantName;
	
	@NotNull(message="Must not be blank")
	@Min(value=0, message="Must be between 0 and 5")
	@Max(value=5, message="Must be between 0 and 5")
	private Integer rating;
	
	@NotNull(message="Must not be blank")
	@Size(min = 5, max = 400, message="Must be between 5 and 400 characters")
	private String notes;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // CONSTRUCTORS //
    public Burger() {}
	
    public Burger(
    		String burgerName,
    		String restaurantName,
    		Integer rating,
			String notes) {
		this.burgerName = burgerName;
		this.restaurantName = restaurantName;
		this.rating = rating;
		this.notes = notes;
	}
    
    @PrePersist
    protected void onCreate() {
    	this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = new Date();
    }

    // GETTERS AND SETTERS //
	public Long getId() {
		return id;
	}

	public String getBurgerName() {
		return burgerName;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public Integer getRating() {
		return rating;
	}

	public String getNotes() {
		return notes;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}   
}
