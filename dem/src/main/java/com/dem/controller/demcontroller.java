package com.dem.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dem.dao.demdaointerface;
import com.dem.entity.demuser;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class demcontroller {

	@Autowired
	demdaointerface dao;

	@GetMapping("casestudy")
	public List<demuser> viewprofile()throws Exception {


		 List<demuser> uu=new ArrayList<demuser>(); 
		 uu=dao.viewprofiledao();
		 return uu;
		 
	}
	
	@PostMapping("casestudy")
	public void createprofile(@RequestBody demuser user)throws Exception {
		
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		 System.out.println("enter name");
//		 String name=br.readLine();
//		 
//		 System.out.println("enter email");
//		 String email=br.readLine();
//		
//		 System.out.println("enter pswd");
//		 String password=br.readLine();
//		
//		 System.out.println("enter address");
//		 String address=br.readLine();
//		
//		 
//		 demuser uu1=new demuser();
//		 uu1.setName(name);
//		 uu1.setEmail(email);
//		 uu1.setPassword(password);
//		 uu1.setAddress(address);
//		 List<demuser> uu=new ArrayList<demuser>();
		 dao.createprofiledao(user);
//		 return uu;
		 
	}
	
	@DeleteMapping(value="/casestudy/{id}")
	public void deleteprofile(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Enter Name to delete : ");
//		String name=null;
//		name = br.readLine();
//		
//		demuser uu1=new demuser();
//		uu1.setName(name);
		dao.deleteprofileservice(id);
//		if(i>0) {
//			System.out.println("deleted");
//		}
//		else {
//			System.out.println("doesnt exist");
//		}
	}
	
	@PutMapping(value="/casestudy/{id}")
	public void editprofile( @RequestBody demuser user,@PathVariable("id") int id)throws Exception {

			dao.editprofileservice(user,id);

			
	}
	
}
