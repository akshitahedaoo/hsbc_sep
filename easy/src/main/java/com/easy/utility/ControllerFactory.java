package com.easy.utility;

import com.easy.controller.easycontroller;
import com.easy.controller.easycontrollerinterface;

public class ControllerFactory {
	private ControllerFactory() {
	}
	
	public static easycontrollerinterface createObject(String nn) {
		easycontrollerinterface is=null;
		if(nn.equals("adminservice")) {
			is=new easycontroller();
		}
		return is;
	}
}
