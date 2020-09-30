package com.facebook2.utility;

import com.facebook2.service.facebook2service;
import com.facebook2.service.facebook2serviceinterface;

public class ServiceFactory {
	private ServiceFactory() {
	}
	
	public static facebook2serviceinterface createObject(String nn) {
		facebook2serviceinterface is=null;
		if(nn.equals("adminservice")) {
			is=new facebook2service();
		}
		return is;
	}

}
