package com.easy.view;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import com.easy.controller.easycontroller;
import com.easy.controller.easycontrollerinterface;
import com.easy.utility.ControllerFactory;

public class easyview {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String cc="y";
		while(cc.equals("y")) {
		System.out.println("*********MAIN MENU*************");
		System.out.println("Press 1 to create profile");
		System.out.println("Press 2 to edit profile");
		System.out.println("Press 3 to delete profile");
		System.out.println("Press 4 to view profile");
		System.out.println("Press 5 to search profile");
		System.out.println("Press 6 to viewall profile");
		System.out.println("press 8 to view userdetail with history");
		System.out.println("enter your choice");
		int i=Integer.parseInt(br.readLine());
		easycontrollerinterface ei;
		 ei=ControllerFactory.createObject("adminservice");
		
		switch(i) {
		case 1:ei.createprofile();
			break;
		case 2:ei.editprofile();
			break;
		case 3:ei.deleteprofile();
			break;
		case 4:ei.viewprofile();
			break;
		case 5:ei.searchprofile();
			break;
		case 6:ei.viewallprofile();
			break;
		case 7:ei.userdetailwithhistory();
			break;
		default:System.out.println("wrong choice");
		}
		System.out.println("do you want to continue press y/n");
		cc=br.readLine();
		}
		
}


}
	


