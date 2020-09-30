package com.facebook2.service;



import java.util.List;

import com.facebook2.dao.facebook2daointerface;
import com.facebook2.entity.facebook2user;
import com.facebook2.utility.DaoFactory;



public class facebook2service implements facebook2serviceinterface {
	
	private facebook2daointerface di=null;
	public facebook2service() {
		di=DaoFactory.createObject("adminservice");
	}

	public int createprofileservice(facebook2user iu) {
		// TODO Auto-generated method stub
		return di.createprofiledao(iu);
	
	}
	
	public int checkemail(facebook2user iu) {
		return di.checkemaildao(iu);
	}
	
	
	@Override
	public boolean loginProfile(facebook2user f) {
		// TODO Auto-generated method stub
		return di.loginProfile(f);
	}
	
	public List<facebook2user> friendProfile(facebook2user f) {
		// TODO Auto-generated method stub
		return di.friendlistdao(f);
	}
	
	public List<facebook2user> country() {
		// TODO Auto-generated method stub
		return di.countrydao();
	}
	
	public List<facebook2user> state(facebook2user f) {
		// TODO Auto-generated method stub
		return di.statedao(f);
	}
	
	public List<facebook2user> city(facebook2user f) {
		// TODO Auto-generated method stub
		return di.citydao(f);
	}
	
	

}
