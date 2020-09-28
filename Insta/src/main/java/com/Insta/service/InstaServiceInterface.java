package com.Insta.service;

import java.util.List;

import com.Insta.entity.InstaUser;


public interface InstaServiceInterface {

	int createprofileservice(InstaUser iu);

	
	List<InstaUser> friendProfile(InstaUser iu);

	boolean loginProfile(InstaUser iu);

}
