package com.facebook2.dao;

import java.util.List;

import com.facebook2.entity.facebook2user;

public interface facebook2daointerface {

	int createprofiledao(facebook2user iu);

	boolean loginProfile(facebook2user f);

	List<facebook2user> friendlistdao(facebook2user f);

	


	int checkemaildao(facebook2user iu);

	List<facebook2user> countrydao();

	List<facebook2user> statedao(facebook2user f);

	List<facebook2user> citydao(facebook2user f);

	

}
