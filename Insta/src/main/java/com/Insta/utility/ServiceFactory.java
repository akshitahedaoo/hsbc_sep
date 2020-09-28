package com.Insta.utility;

import com.Insta.service.InstaService;
import com.Insta.service.InstaServiceInterface;

public class ServiceFactory {
	private ServiceFactory() {
	}
	
	public static InstaServiceInterface createObject(String nn) {
		InstaServiceInterface is=null;
		if(nn.equals("adminservice")) {
			is=new InstaService();
		}
		return is;
	}

}
