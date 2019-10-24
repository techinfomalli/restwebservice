package com.malli.rest.helloworld;

public class HelloWorldBean  {
String message;

public HelloWorldBean(String message) {
	super();
	this.message = message;
}


@Override
public String toString() {
	return "HelloWorldBean [message=" + message + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}


public String getmessaged() {
	return message;
}


public void setmessaged(String message) {
	this.message = message;
}

}
