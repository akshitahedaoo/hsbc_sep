package com.dem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dem.entity.demuser;

@Repository
public class demdao implements demdaointerface{

	@Override
	public List<demuser> viewprofiledao() {
		List<demuser> l=new ArrayList<demuser>();
		Connection con=null;
		try {	
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","aki","aki");
		PreparedStatement ps;
		ps=con.prepareStatement("select * from INSTAGRAM");
		
		ResultSet res=ps.executeQuery();		
		while(res.next()) {
			demuser uu1=new demuser();
			uu1.setId(res.getInt(1));
			uu1.setName(res.getString(2));
			uu1.setPassword(res.getString(4));
			uu1.setEmail(res.getString(3));
			uu1.setAddress(res.getString(5));
			l.add(uu1);
		}
		}
		catch(ClassNotFoundException|SQLException e1){
			e1.printStackTrace();
		}
			
		return l;
		
	}

	@Override
	public List<demuser> createprofiledao(demuser uu1) throws Exception {
		int i=0;
		List<demuser> l=new ArrayList<demuser>();
		Connection con=null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","aki","aki");
			PreparedStatement ps=con.prepareStatement("insert into INSTAGRAM(name,email,password, VALUES(?,?,?,?)");
		ps.setString(1, uu1.getName());
		ps.setString(2, uu1.getEmail());
		ps.setString(3, uu1.getPassword());
		ps.setString(4, uu1.getAddress());
		
		i=ps.executeUpdate();
		System.out.println("hello1");
		l.add(uu1);
		}
		catch(SQLException ee) {
			ee.printStackTrace();
		}

		return l;
		
	}

	@Override
	public void deleteprofileservice(int id)  {
		Connection con=null;
		int i=0;
		try{
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","aki","aki");
		PreparedStatement ps=con.prepareStatement("delete from INSTAGRAM where id=?");
		ps.setInt(1,id);
		i=ps.executeUpdate();
		}catch (SQLException |ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}

	@Override
	public void editprofileservice(demuser user,int id) throws Exception {
		int i=0;
		Connection con=null;
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","aki","aki");
		PreparedStatement ps=con.prepareStatement("update INSTAGRAM set name=?,email=?, password=? where id=?");
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		ps.setInt(4, id);
		//System.out.println("hello");
		i= ps.executeUpdate();
		//System.out.println("how r u");

		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
	
	}

	}

