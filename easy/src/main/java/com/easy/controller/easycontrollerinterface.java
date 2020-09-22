package com.easy.controller;

import java.io.IOException;

import com.easy.utility.easyException;

public interface easycontrollerinterface {

	void createprofile() throws IOException ;

	void editprofile() throws Exception, Exception;

	void deleteprofile()  ;

	void searchprofile() throws easyException ;

	void viewprofile() ;

	void viewallprofile() ;

	void userdetailwithhistory();

}
