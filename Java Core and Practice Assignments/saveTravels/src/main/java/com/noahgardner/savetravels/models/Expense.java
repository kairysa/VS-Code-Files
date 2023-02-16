package com.noahgardner.savetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Must not be blank")
	@Size(min = 5, max = 100, message="Must be between 5 and 100 characters")
	private String expenseName;
	
	@NotNull(message="Must not be blank")
	@Size(min = 5, max = 100, message="Must be between 5 and 100 characters")
	private String vendor;
	
	@NotNull(message="Must not be blank")
	@Min(value = 0, message = "Cannot be negative")
	private Double amount;
	
	@NotNull(message="Must not be blank")
	@Size(min = 5, max = 400, message="Must be between 5 and 400 characters")
	private String description;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	// CONSTRUCTORS //
	public Expense() {}
	
	public Expense(String expenseName, String vendor, Double amount, String description) {
		this.expenseName = expenseName;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
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

	public String getExpenseName() {
		return expenseName;
	}

	public String getVendor() {
		return vendor;
	}

	public Double getAmount() {
		return amount;
	}
	
	public String getDescription() {
		return description;
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

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
