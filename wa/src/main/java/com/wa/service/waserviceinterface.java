package com.wa.service;

import java.util.List;

import com.wa.entity.wauser;

public interface waserviceinterface {

	int createprofileservice(wauser iu);

	List<wauser> friendProfile(wauser iu);


	boolean loginProfile(wauser iu);

}
