package com.example.demo.Controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entities.Amount;
import com.example.demo.Entities.Payment;
import com.example.demo.Entities.Users;
import com.example.demo.Repos.UsersRepository;
import com.example.demo.Services.UsersService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

@CrossOrigin("*")
@RestController
//@RequestMapping("/api/")
public class PaymentController {
	
	@Autowired
	
	UsersRepository repo;
	
	@Autowired
	
	UsersService service;
	
	@GetMapping("/pay")
	
	public String pay() {
		
		return "pay";
	}
	
	@CrossOrigin("http://localhost:3000")
	@PostMapping("/payment-success")
	public String paymentSuccess(@RequestBody Amount a) {
	
		//String mail =  (String) session.getAttribute("email");
		
		String mail = a.getEmail();
		
		System.out.println("Mail ID is:  "+mail);
		
		Users u = service.getUser(mail);
		
		System.out.println("Username is:  "+u);
		
		u.setPremium(true);
		
		service.updateUser(u);
		
		System.out.println("User Status Updated");
		
		return "User Status Updated";
	}
	
	@GetMapping("/payment-failure")
	public String paymentFailure() {
		return "customerHome";
	}
	
	@SuppressWarnings("finally")
	@PostMapping("/createOrder")
	@ResponseBody
	
	public String createOrder(@RequestBody Amount a) {
		
		int amount = a.getAmount();
		
		System.out.println("Amount is: "+amount);
		
		Order order = null;
		
		try {
			
			RazorpayClient razorpay = new RazorpayClient("rzp_test_zkDVBW3Y2aEfUv", "q70yS1HZS1mB5SYDNrMt8K1V");
			
			JSONObject orderRequest = new JSONObject();
			
			orderRequest.put("amount",amount*100);
			
			orderRequest.put("currency","INR");
			
			orderRequest.put("receipt", "order_rcptid_11");
			
			order = razorpay.orders.create(orderRequest);
			
		}catch(RazorpayException e) {
			
			e.printStackTrace();
		}finally {
			return order.toString();
		}
		
	}
	
	@PostMapping("/verify")
	@ResponseBody
	public boolean verifyPayment(@RequestBody Payment p) {
	    try {
	        // Initialize Razorpay client with your API key and secret
	    	
	    	String orderId = p.getOrderId();
	    	
	    	String paymentId = p.getPaymentId();
	    	
	    	String signature = p.getSignature();
	    	
	    	System.out.println(orderId+"    "+paymentId+"   "+signature);
	    	
	        RazorpayClient razorpayClient = new RazorpayClient("rzp_test_zkDVBW3Y2aEfUv", "q70yS1HZS1mB5SYDNrMt8K1V");
	        // Create a signature verification data string
	        String verificationData = orderId + "|" + paymentId;

	        // Use Razorpay's utility function to verify the signature
	        boolean isValidSignature = Utils.verifySignature(verificationData, signature, "q70yS1HZS1mB5SYDNrMt8K1V");

	        
	        System.out.println(isValidSignature);

	        return isValidSignature;

	    } catch (RazorpayException e) {
	        
	    	e.printStackTrace();
	        
	        return false;
	    }
	}
	
	
}
