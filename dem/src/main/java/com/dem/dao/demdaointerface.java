package com.dem.dao;

import java.util.List;

import com.dem.entity.demuser;

public interface demdaointerface {

	List<demuser> viewprofiledao();

	List<demuser> createprofiledao(demuser uu1) throws Exception;

	void deleteprofileservice(int id) ;

	void editprofileservice(demuser user,int id) throws Exception;

}
