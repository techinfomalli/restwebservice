package com.malli.rest.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@RequestMapping(method=RequestMethod.GET,path="/HelloWorld")
		public String helloWorld() {
		return "Hello World";	
	}
	
	@GetMapping(path="/HelloWorld-Bean")
	public HelloWorldBean helloWorldBean() {
	return new HelloWorldBean( "HelloWorld");
}
	
	
	@GetMapping(path="/HelloWorld-Bean/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
	return new HelloWorldBean(String.format("HelloWorld, %s", name));
}
	
	

	@GetMapping(path="/HelloWorld-Bean/{name}")
	public HelloWorldBean helloWorldBean1(@PathVariable String name) {
	return new HelloWorldBean( "HelloWorld"+name);
}


}
