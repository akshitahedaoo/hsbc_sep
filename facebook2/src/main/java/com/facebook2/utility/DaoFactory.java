package com.facebook2.utility;

import com.facebook2.dao.facebook2dao;
import com.facebook2.dao.facebook2daointerface;

public class DaoFactory {
	
	private DaoFactory() {
	}
	
	public static facebook2daointerface createObject(String nn) {
		facebook2daointerface is=null;
		if(nn.equals("adminservice")) {
			is=new facebook2dao();
		}
		return is;
	}
}
