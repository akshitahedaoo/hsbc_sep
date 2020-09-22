package com.easy.controller;

import java.io.BufferedReader;
import java.io.IOException;
//import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import com.easy.entity.easyuser;
import com.easy.service.easyservice;
import com.easy.service.easyserviceinterface;
import com.easy.utility.ServiceFactory;
import com.easy.utility.SortBy_Email;
import com.easy.utility.easyException;

public class easycontroller implements easycontrollerinterface {
	private easyserviceinterface es;
	
	public easycontroller() {
		es=ServiceFactory.createObject("adminservice");
		
	}

	public void createprofile() throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your Name : ");
		String name=null;
		try {
			name = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		System.out.println("Enter your email : ");
		String email=null;
		try {
			email = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Enter your password : ");
		String password=null;
		try {
			password = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Enter your address : ");
		String address=null;
		try {
			address = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		easyuser iu=new easyuser();
		iu.setName(name);
		iu.setEmail(email);
		iu.setPassword(password);
		iu.setAddress(address);
		

		int i=es.createprofileservice(iu);
		if(i>0) {
			System.out.println("profile created");
		}
		else {
			System.out.println("could not create profile");
		}
		
		
		
	}

	public void editprofile() throws Exception {
		// TODO Auto-generated method stub
		viewprofile();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("press 1 to edit password");
		System.out.println("press 2 to edit name");
		System.out.println("press 3 to edit email");
		System.out.println("press 4 to edit address");
		
		System.out.println("enter your choice ");
		int i=Integer.parseInt(br.readLine());
		
		
		//InstagramControllerInterface fi=new InstagramController();
		String name="aki";
		
		switch(i) {
		
		case 1:editprofilebypassword();
			break;
		case 2:editprofilebyemail();
			break;
		case 3:editprofilebyaddress();
			break;
		
		
		default:System.out.println("wrong choice");
		
		}
		es.editprofileservice();
	}

	private void editprofilebyaddress() {
		// TODO Auto-generated method stub
		
		
	}

	private void editprofilebyemail() {
		// TODO Auto-generated method stub
		
	}

	private void editprofilebypassword() {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Name  : ");
		String name=null;
		try {
			name = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		easyuser iu=new easyuser();
		iu.setName(name);
		System.out.println("Enter new password ");
		String password=null;
		try {
			password = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		iu.setPassword(password);
		try {
			if(es.editprofilebypasswordservice(iu)) {
				System.out.println("edited");
			}
			else System.out.println("edited");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteprofile() {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Name to delete : ");
		String name=null;
		try {
			name = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		easyuser iu=new easyuser();
		iu.setName(name);
		int i=es.deleteprofileservice(iu);
		if(i>0) {
			System.out.println("deleted");
		}
		else {
			System.out.println("doesnt exist");
		}
	}

	public void searchprofile()   {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Name to search : ");
		String name=null;
		try {
			name = br.readLine();
		
		easyuser iu=new easyuser();
		iu.setName(name);
		
		ArrayList<easyuser>uu=es.searchprofileservice(iu);
		System.out.println(uu.size()+"  users found");
		for(easyuser u:uu) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (easyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viewprofile() {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Name to search : ");
		String name=null;
		try {
			name = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		easyuser iu=new easyuser();
		iu.setName(name);
		easyuser uu=es.viewprofileservice(iu);
		if(uu!=null) {
			System.out.println("User Information is below");
			System.out.println("Name is : "+uu.getName());
			System.out.println("Password is : "+uu.getPassword());
			System.out.println("Email is : "+uu.getEmail());
			System.out.println("Address is : "+uu.getAddress());
		}
		else {
			System.out.println("User with Name : "+name+" not exist");
		}
		
		
	}

	public void viewallprofile()  {
		// TODO Auto-generated method stub
		
		ArrayList<easyuser>uu=es.viewallprofileservice();
		
		Collections.sort(uu, new SortBy_Email());
		System.out.println(uu.size()+"  users found");
		for(easyuser u:uu) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void userdetailwithhistory() {
		// TODO Auto-generated method stub
		Map<String,ArrayList<easyuser>> uu=es.userdetailwithhistoryservice();
		ArrayList<easyuser>  ll=uu.get("studentlist");
		for(easyuser u:ll) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		}
		ArrayList<easyuser>  ll1=uu.get("proflist");
		for(easyuser u:ll1) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		}
		
	}

}
