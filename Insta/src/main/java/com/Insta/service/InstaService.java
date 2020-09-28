package com.Insta.service;

import java.util.List;

import com.Insta.dao.InstaDaoInterface;
import com.Insta.entity.InstaUser;
import com.Insta.utility.DaoFactory;



public class InstaService implements InstaServiceInterface{
	
	private InstaDaoInterface di=null;
	public InstaService() {
		di=DaoFactory.createObject("adminservice");
	}

	@Override
	public int createprofileservice(InstaUser iu) {
		// TODO Auto-generated method stub
		return di.createprofiledao(iu);
		
	}
	
	public boolean loginProfile(InstaUser iu) {
		// TODO Auto-generated method stub
		return di.loginProfile(iu);
	}

	@Override
	public List<InstaUser> friendProfile(InstaUser iu) {
		// TODO Auto-generated method stub
		return di.friendlistdao(iu);
	}


}
