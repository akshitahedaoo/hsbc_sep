package com.easy.utility;

import com.easy.service.easyservice;
import com.easy.service.easyserviceinterface;

public class ServiceFactory {
	
		private ServiceFactory() {
		}
		
		public static easyserviceinterface createObject(String nn) {
			easyserviceinterface is=null;
			if(nn.equals("adminservice")) {
				is=new easyservice();
			}
			return is;
		}
}
