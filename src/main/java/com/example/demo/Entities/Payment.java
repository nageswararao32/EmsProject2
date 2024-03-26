package com.example.demo.Entities;

public class Payment {
	
	private String orderId; 
	private String paymentId; 
	private String signature;
	private String email;
	
	public Payment() {
		super();
	}

	public Payment(String orderId, String paymentId, String signature, String email) {
		super();
		this.orderId = orderId;
		this.paymentId = paymentId;
		this.signature = signature;
		this.email = email;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Payment [orderId=" + orderId + ", paymentId=" + paymentId + ", signature=" + signature + ", email="
				+ email + "]";
	}
	
	
	
}
