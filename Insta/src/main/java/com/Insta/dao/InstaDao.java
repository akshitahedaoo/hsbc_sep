package com.Insta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Insta.entity.InstaUser;


public class InstaDao implements InstaDaoInterface{
	
	private Connection con;
	public InstaDao(){
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","aki","aki");
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int createprofiledao(InstaUser iu) {
		// TODO Auto-generated method stub
		int i=0;
		try {
		PreparedStatement ps=con.prepareStatement("insert into INSTAGRAM VALUES(?,?,?,?)");
		ps.setString(1, iu.getName());
		ps.setString(2, iu.getEmail());
		ps.setString(3, iu.getPassword());
		ps.setString(4, iu.getAddress());
		
		
		i=ps.executeUpdate();
		}
		catch(SQLException ee) {
			ee.printStackTrace();
		}

		return i;
	}

	@Override
	public boolean loginProfile(InstaUser iu) {
		boolean i=false;
		try {
			PreparedStatement ps=con.prepareStatement("select * from INSTAGRAM where name=? and password=?");
			ps.setString(1, iu.getName());
			ps.setString(2, iu.getPassword());
			
			
			//step 4 executeQuery
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				i=true;
			}
							
			
		}
		catch(SQLException ee) {
			ee.printStackTrace();
		}
		return i;
	}

	@Override
	public List<InstaUser> friendlistdao(InstaUser iu) {
		List<InstaUser> ll=new ArrayList<InstaUser>();
		InstaUser f1=new InstaUser();
		f1.setName("sakshi");
		f1.setEmail("sak@gmail.com");
		
		InstaUser f2=new InstaUser();
		f2.setName("laxmi");
		f2.setEmail("laxmi@yahoo.com");
		
		ll.add(f1);
		ll.add(f2);
		return ll;
	}

}
