package com.wa.dao;

import java.util.List;

import com.wa.entity.wauser;

public interface wadaointerface {

	int createprofiledao(wauser iu);

	boolean loginProfile(wauser iu);

	List<wauser> friendlistdao(wauser iu);

}
