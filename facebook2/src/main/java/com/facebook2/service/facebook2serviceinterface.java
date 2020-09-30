package com.facebook2.service;

import java.util.List;

import com.facebook2.entity.facebook2user;

public interface facebook2serviceinterface {
	public int createprofileservice(facebook2user iu) ;

	public int checkemail(facebook2user iu);
	public boolean loginProfile(facebook2user f);
	public List<facebook2user> country();
	public List<facebook2user> state(facebook2user f);
	List<facebook2user> friendProfile(facebook2user fe);
	List<facebook2user> city(facebook2user f);
	
}
