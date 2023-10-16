package com.jwtAuth.controller;

import com.jwtAuth.model.AuthenticationRequest;
import com.jwtAuth.model.AuthenticationResponse;
import com.jwtAuth.model.UserModel;
import com.jwtAuth.repository.UserRepository;
import com.jwtAuth.services.UserServices;
import com.jwtAuth.utils.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserServices userServices;

	@Autowired
	private JwtUtils jwtUtils;

	@GetMapping("/welcome")
	private String testingToken() {
		return "Welcome to DASHBOARD " + SecurityContextHolder.getContext().getAuthentication().getName();
	}

	@PostMapping("/authreg")
	private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		String username = authenticationRequest.getEmailId();
		String password = authenticationRequest.getPassWord();
		UserModel userModel = new UserModel();
		userModel.setEmail(username);
		userModel.setPassword(password);
		try {
			userRepository.save(userModel);
		} catch (Exception e) {
			throw new Exception("Invalid", e);
		}
		return ResponseEntity.ok(new AuthenticationResponse("Successful subscription for client " + username));

	}

	@PostMapping("/auth")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		String username = authenticationRequest.getEmailId();
		String password = authenticationRequest.getPassWord();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception e) {
			throw new Exception("Invalid", e);

		}
		UserDetails loadeduser = userServices.loadUserByUsername(username);
		String generatedToken = jwtUtils.generateToken(loadeduser);

		return ResponseEntity.ok(new AuthenticationResponse(generatedToken));

	}

}
