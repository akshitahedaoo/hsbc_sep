package com.Insta.utility;

import com.Insta.dao.InstaDao;
import com.Insta.dao.InstaDaoInterface;

public class DaoFactory {
	private DaoFactory() {
	}
	
	public static InstaDaoInterface createObject(String nn) {
		InstaDaoInterface is=null;
		if(nn.equals("adminservice")) {
			is=new InstaDao();
		}
		return is;
	}

}
