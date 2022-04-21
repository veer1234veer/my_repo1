package com.zensar.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

	//** Path Parameter based API versioning**/
	@GetMapping(value="/api/contact/v1",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)  // Old API
	public Contact getContact()
	{
		return new Contact("Tom",12345);
	}
	
	@GetMapping(value="/api/contact/v2",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)  // New API
	public Contact2 getContact2()
	{
		return new Contact2("Jerry",56789);
	}
	
	//** Query Parameter based API versioning**/
	@GetMapping(value="/api/contact",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,params = "version=v1")  // Old API
	public Contact getContactQeuryV1()
	{
		return new Contact("Tommy",12345);
	}
	
	@GetMapping(value="/api/contact",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,params = "version=v2")  // Old API
	public Contact2 getContactQeuryV2()
	{
		return new Contact2("Tommy",12345);
	}
	
     	//** Query Parameter based API versioning**/
		@GetMapping(value="/api/contact",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,headers = "version=v1")  // Old API
		public Contact getContactHederV1()
		{
			return new Contact("Tommy",12345);
		}
		
		@GetMapping(value="/api/contact",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,headers = "version=v2")  // Old API
		public Contact getContactHederV2()
		{
			return new Contact("Jerry",12345);
		}
		
		//** Content Negotiation based API versioning**/
		@GetMapping(value="/api/contact",produces="application/contact.v1+json")  // Old API
		public Contact getContactContentNegoV1()
		{
			return new Contact("Tommy",12345);
		}
		
		@GetMapping(value="/api/contact",produces="application/contact.v2+json")  // Old API
		public Contact2 getContactContentNegoV2()
		{
			return new Contact2("johny",12345);
		}
		
}

class Contact{
	private String name;
	private int mobile;
	
	public Contact(String name, int mobile) {
		super();
		this.name = name;
		this.mobile = mobile;
	}
	public Contact() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", mobile=" + mobile + "]";
	}
	
	
}




class Contact2{
	private String name;
	private int mobileNo;
	public Contact2(String name, int mobileNo) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
	}
	public Contact2() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "Contact2 [name=" + name + ", mobileNo=" + mobileNo + "]";
	}
	
}

