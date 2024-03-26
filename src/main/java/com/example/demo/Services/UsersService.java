package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entities.Users;

public interface UsersService {
	
	public String addUsers(Users users);

	public boolean emailExists(String email);

	public boolean validateUser(String email, String password);

	public String getRole(String email);

	public Users getUser(String email);

	public void updateUser(Users user);
	
	public boolean isPrimeOrNot(String email);
	
	public Users getUserDeatils(String email);
	
	public Users updatePassword(String password, String email);

	public List<Users> getUserDetails();

	public void deleteUser(Users usr);

	public Users findUserByID(Integer id);

	public Users updateUserData(Integer id, String username, String email, String password);


}
