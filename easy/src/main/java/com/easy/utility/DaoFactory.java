package com.easy.utility;

import com.easy.dao.easydao;
import com.easy.dao.easydaointerface;

public class DaoFactory {
	private DaoFactory() {
	}
	
	public static easydaointerface createObject(String nn) {
		easydaointerface is=null;
		if(nn.equals("adminservice")) {
			is=new easydao();
		}
		return is;
	}

}
