package com.easy.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.easy.entity.easyuser;
import com.easy.utility.easyException;

public interface easydaointerface {

	int createprofiledao(easyuser iu) throws IOException;

	void editprofiledao()throws Exception;

	int deleteprofiledao(easyuser iu)  ;

	easyuser viewprofiledao(easyuser iu) ;

	ArrayList<easyuser> searchprofiledao(easyuser iu) throws easyException ;


	ArrayList<easyuser> viewallprofiledao() ;

	boolean editprofilebypassworddao(easyuser iu);

	void deleteprofiledao();

	Map<String, ArrayList<easyuser>> userdetailwithhistorydao();

	

}
