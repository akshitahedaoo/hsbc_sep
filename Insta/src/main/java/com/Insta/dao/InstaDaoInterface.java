package com.Insta.dao;

import java.util.List;

import com.Insta.entity.InstaUser;

public interface InstaDaoInterface {

	int createprofiledao(InstaUser iu);

	boolean loginProfile(InstaUser iu);

	List<InstaUser> friendlistdao(InstaUser iu);

}
