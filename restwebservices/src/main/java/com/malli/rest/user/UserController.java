package com.malli.rest.user;

import java.net.URI;
import java.rmi.ServerError;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	@Autowired
	public UserDaoService repository;
	

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		System.out.println("RAMRAMRMA");
		return repository.findAll();

	}

	@GetMapping("/users/{id}")
	public User retrieveAllUsers(@PathVariable int id) {
		User user = repository.findById(id);
		if (user == null)
			 throw new UserNotFoundException("UserNotFoundException id "+id);
			// throw new UserNotFoundException();

			// throw new RuntimeException("ramram");
			// throw new ServerError("ramram", null);

			System.out.println(user);
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = repository.save(user);
		System.out.println(savedUser);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		//public void createUser(@PathVariable int id) {
		
		try{
			repository.deleteById(id);
		}catch(IndexOutOfBoundsException e){
			 throw new UserNotFoundException("UserNotFoundException id "+id);
		}
		//User deleteUser = repository.findById(id);
		//repository.deleteById(id);
//		System.out.println("Deleted");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build()
				.toUri();
		return ResponseEntity.created(location).build();
		//return ResponseEntity.accepted().build();

		
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable int id, @RequestBody User user) {
		
		try{
			User user1 =repository.findById(id);
			if(user1==null)
				throw new UserNotFoundException("UserNotFoundException id "+id);
			user.setId(id);
			repository.update(user);
		}catch(IndexOutOfBoundsException e){
			 throw new UserNotFoundException("UserNotFoundException id "+id);
		}
		
	
	
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		
	}

	
	
	
	
}
