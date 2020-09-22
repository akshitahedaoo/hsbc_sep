package com.easy.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.easy.entity.easyuser;
import com.easy.utility.easyException;

public interface easyserviceinterface {

	int createprofileservice(easyuser iu) throws IOException ;

	void editprofileservice() throws Exception;

	int deleteprofileservice(easyuser iu) ;
	
	boolean editprofilebypassword(easyuser  iu) throws easyException;

	easyuser viewprofileservice(easyuser iu) ;

	void searchprofileservice() ;

	ArrayList<easyuser> viewallprofileservice() ;

	ArrayList<easyuser> searchprofileservice(easyuser iu) throws easyException ;

	boolean editprofilebypasswordservice(easyuser iu) throws Exception;

	Map<String, ArrayList<easyuser>> userdetailwithhistoryservice();

}
