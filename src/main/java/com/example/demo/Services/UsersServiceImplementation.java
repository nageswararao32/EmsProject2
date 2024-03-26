package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entities.Users;
import com.example.demo.Repos.UsersRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsersServiceImplementation implements UsersService {
	
	@Autowired
	
	UsersRepository repo;
	
	@Override
	public String addUsers(Users users) {
		// TODO Auto-generated method stub
		repo.save(users);
		return "User added successfully...!";
	}

	@Override
	public boolean emailExists(String email) {
		// TODO Auto-generated method stub
		if(repo.findByEmail(email)==null) {
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public boolean validateUser(String email, String password) {
		Users user = repo.findByEmail(email);
		if(user == null) {
			return false;
		}
		String db_pass = user.getPassword();
		if(password.equals(db_pass)) {
			return true;
		}else{
		return false;
		}
	}

	@Override
	public String getRole(String email) {
		
		Users user = repo.findByEmail(email);

		return user.getRole();
	}

	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		
		repo.save(user);
	}

	@Override
	public boolean isPrimeOrNot(String email) {
		
		Users u = repo.findByEmail(email);
		
		if(u == null) {
			
			return false;
		}
		
		boolean status = u.isPremium();
		
		if(status) {
		
		System.out.println(u.getUsername()+" is a prime User: "+status);
		
		}else {
			System.out.println(u.getUsername()+" is Not prime User: "+status);
				
		}
		return status;
	}

	@Override
	public Users getUserDeatils(String email) {
		
		Users u = repo.findByEmail(email);
		
		System.out.println("User Deatils:  "+u.getUsername());
		
		return u;
	}

	@Override
	public Users updatePassword(String password, String email) {
		
		Users u = repo.findByEmail(email);
		
		u.setPassword(password);
		
		System.out.println("Password Updated successfully");
		
		return	repo.save(u);	
	}

	@Override
	public List<Users> getUserDetails() {
		
		return repo.findAll();
	}

	@Override
	public void deleteUser(Users usr) {
		
		repo.delete(usr);
		
		System.out.println("User deleted at repoSide");
	}

	
	@Override
	public Users findUserByID(Integer id) {
		
		return repo.findById(id).orElse(null);
	}

	@Override
	public Users updateUserData(Integer id, String username, String email, String password) {
		
		Users u = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
		
		u.setUsername(username);
		
		u.setEmail(email);
		
		u.setPassword(password);
		
		return repo.save(u);
	}

	

	

	

}
