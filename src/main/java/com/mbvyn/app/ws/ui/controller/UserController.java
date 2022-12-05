package com.mbvyn.app.ws.ui.controller;

import org.springframework.web.bind.annotation.*;

import com.mbvyn.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get user was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
	}

	@GetMapping(path = "/{userId}")
	public UserRest getUser(@PathVariable String userId) {
		
		UserRest returnValue = new UserRest();
		returnValue.setEmail("test@test.com");
		returnValue.setFirstName("Bohdan");
		returnValue.setLastName("Vynnytskyi");
		
		return returnValue;
	}

	@PostMapping
	public String createUser() {
		return "create user was called";
	}

	@PutMapping
	public String updateUser() {
		return "update user was called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}
}