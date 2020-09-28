package com.wa.service;

import java.util.List;

import com.wa.dao.wadaointerface;
import com.wa.entity.wauser;
import com.wa.utility.DaoFactory;



public class waservice implements waserviceinterface {
	private wadaointerface di=null;
	public waservice() {
		di=DaoFactory.createObject("adminservice");
	}

	@Override
	public int createprofileservice(wauser iu) {
		// TODO Auto-generated method stub
		return di.createprofiledao(iu);
		
	}
	
	public boolean loginProfile(wauser iu) {
		// TODO Auto-generated method stub
		return di.loginProfile(iu);
	}

	
	@Override
	public List<wauser> friendProfile(wauser iu) {
		// TODO Auto-generated method stub
		return di.friendlistdao(iu);
	}



}
