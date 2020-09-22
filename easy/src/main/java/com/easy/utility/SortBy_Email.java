package com.easy.utility;

import java.util.Comparator;

import com.easy.entity.easyuser;

public class SortBy_Email implements Comparator<easyuser> {

	@Override
	public int compare(easyuser o1, easyuser o2) {
		// TODO Auto-generated method stub
		return o1.getEmail().compareTo(o2.getEmail());
	}

}
