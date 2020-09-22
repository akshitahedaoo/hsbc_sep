package com.easy.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.easy.dao.easydao;
import com.easy.dao.easydaointerface;
import com.easy.entity.easyuser;
import com.easy.utility.DaoFactory;
import com.easy.utility.easyException;

public class easyservice implements easyserviceinterface{
	private easydaointerface di;
	public easyservice() {
		di=DaoFactory.createObject("adminservice");
	}

	public int createprofileservice(easyuser iu) throws IOException{
		// TODO Auto-generated method stub
		int i=di.createprofiledao(iu);
		return i;
	}

	public void editprofileservice()throws Exception {
		// TODO Auto-generated method stub
		di.editprofiledao();
	}

	public void deleteprofileservice() {
		// TODO Auto-generated method stub
		 di.deleteprofiledao();
			
	}

//	public void viewprofileservice() {
//		// TODO Auto-generated method stub
//		di.viewprofiledao();
//	}

	public ArrayList<easyuser> searchprofileservice(easyuser iu) throws easyException{
		// TODO Auto-generated method stub
		return di.searchprofiledao(iu);
	}

	public ArrayList<easyuser> viewallprofileservice() {
		// TODO Auto-generated method stub
		return di.viewallprofiledao();
		
	}

	public easyuser viewprofileservice(easyuser iu)  {
		// TODO Auto-generated method stub
		easyuser uu=di.viewprofiledao(iu);
		return uu;
		
	}

	public void searchprofileservice()  {
		// TODO Auto-generated method stub
		
	}

//	public void deleteprofileservice() throws Exception{
//		// TODO Auto-generated method stub
//		
//	}
	public boolean editprofilebypassword(easyuser iu) throws easyException{
		return di.editprofilebypassworddao(iu);
	}

	public int deleteprofileservice(easyuser iu){
		// TODO Auto-generated method stub
		int i=di.deleteprofiledao(iu);
		return 0;
	}

	

	public boolean editprofilebypasswordservice(easyuser iu) throws Exception {
		// TODO Auto-generated method stub
		return di.editprofilebypassworddao(iu);
	}

	@Override
	public Map<String, ArrayList<easyuser>> userdetailwithhistoryservice() {
		// TODO Auto-generated method stub
		return di.userdetailwithhistorydao();
	}

	
	
		
	}
	
	

