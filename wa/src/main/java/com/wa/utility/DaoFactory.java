package com.wa.utility;

import com.wa.dao.wadao;
import com.wa.dao.wadaointerface;

public class DaoFactory {
	private DaoFactory() {
	}
	
	public static wadaointerface createObject(String nn) {
		wadaointerface is=null;
		if(nn.equals("adminservice")) {
			is=new wadao();
		}
		return is;
	}


}
