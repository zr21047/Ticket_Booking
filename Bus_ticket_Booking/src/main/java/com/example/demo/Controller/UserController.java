package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.ForgotPassword;
import com.example.demo.Entity.LoginRequest;
import com.example.demo.Entity.User;
import com.example.demo.Exception.EmailChecking;
import com.example.demo.Exception.PasswordMismatchException;
import com.example.demo.Exception.PhonenumberCheck;
import com.example.demo.Exception.UserNotFound;
import com.example.demo.Repo.UserRepo;

@RestController
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@PostMapping("/registration")
	public String loginUser(@RequestBody User user) {
		
		user.setVisibility(1);
		Optional<User> findByemailaddress = userRepo.findByemailaddress(user.getEmail());
		if(findByemailaddress.isPresent()) {
			throw new EmailChecking("Email is already existed...");
		}
		Optional<User> findByPhonenumber = userRepo.findByPhonenumber(user.getPhonenumber());
		
		if(findByPhonenumber.isPresent()) {
			throw new PhonenumberCheck("PhoneNumber is already exist");
		}
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		
		userRepo.save(user);
		
		return "Successfully Registered";
		
		
	}
	
	@PostMapping("/login")
    public User getLoginDetails(@RequestBody LoginRequest loginRequest) {
        Optional<User> findByPhonenumber = userRepo.findByPhonenumber(loginRequest.getPhonenumber());
        if (findByPhonenumber.isPresent()) {
            User user = findByPhonenumber.get();
            boolean matches = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
            if (matches) {
                return user;
            }
            throw new UserNotFound("Incorrect Password");
        }
        throw new UserNotFound("PhoneNumber is not found");
    }
	
	
	@PostMapping("/forgotPassword")
	public String addForgotPasswordDetails(@RequestBody ForgotPassword forgotPassword) {
		Optional<User> findByEmail = userRepo.findByemailaddress(forgotPassword.getPhonenumber());
		if (findByEmail.isPresent()) {
			if (forgotPassword.getNewpassword().equals(forgotPassword.getConfirmPassword())) {
				String encode = passwordEncoder.encode(forgotPassword.getNewpassword());
				User user = findByEmail.get();
				user.setPassword(encode);
				userRepo.save(user);
				return "Password changed successfully";
			}
			throw new PasswordMismatchException("Password and Confirmed password are Mismatch");
		}
		return "Please provide Email_Address in login page";
	}
	
	

}
