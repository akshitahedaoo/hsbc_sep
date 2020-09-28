package com.wa.utility;

import com.wa.service.waservice;
import com.wa.service.waserviceinterface;

public class ServiceFactory {
	private ServiceFactory() {
	}
	
	public static waserviceinterface createObject(String nn) {
		waserviceinterface is=null;
		if(nn.equals("adminservice")) {
			is=new waservice();
		}
		return is;
	}
}
