package com.malli.rest.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int userCount=3;
	
	static {
		users.add(new User(1,"Rama",new Date()));
		users.add(new User(2,"Sita",new Date()));
		users.add(new User(3,"Malli",new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
public User save(User user) {
		//if(user.getId() != 100) 
		user.setId(++userCount);
		users.add(user);
		return user;
	}
		

public User findById(int id) {
	for(User user:users) {
		if(user.getId()==id) {
			return user;
		}
	}
	return null;
}
public void deleteById(int id) {
users.remove(id);
System.out.println("Deleted!!");
}
public User update(User user) {
	
	for(User userl:users) {
		if(userl.getId()==user.getId()) {
		
			userl.setBirthdate(user.getBirthdate());
			userl.setName(user.getName());
			
			return userl;
		}
	}
	return user;
	
	
}
}
