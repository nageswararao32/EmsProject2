package com.example.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Amount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int amount;
	
	private String email;

	public Amount() {
		super();
	}

	public Amount(long id, int amount, String email) {
		super();
		this.id = id;
		this.amount = amount;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Amount [id=" + id + ", amount=" + amount + ", email=" + email + "]";
	}
}

