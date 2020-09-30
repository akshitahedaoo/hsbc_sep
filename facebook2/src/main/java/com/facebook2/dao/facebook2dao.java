package com.facebook2.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.facebook2.entity.facebook2user;




public class facebook2dao implements facebook2daointerface{
	private Connection con;
	public facebook2dao(){
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","aki","aki");
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public int createprofiledao(facebook2user iu) {
		// TODO Auto-generated method stub
		
		int i=0;
		try {
		PreparedStatement ps=con.prepareStatement("insert into INSTAGRAM VALUES(?,?,?,?)");
		ps.setString(1, iu.getName());
		ps.setString(2, iu.getPassword());
		ps.setString(3, iu.getEmail());
		ps.setString(4, iu.getAddress());
		
		i=ps.executeUpdate();
		
		}
		catch(SQLException ee) {
			ee.printStackTrace();
		}

		return i;
		
	}

	@Override
	public boolean loginProfile(facebook2user f) {
		boolean i=false;
		try {
			PreparedStatement ps=con.prepareStatement("select * from INSTAGRAM where name=? and password=?");
			ps.setString(1, f.getName());
			ps.setString(2, f.getPassword());
			
			
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
	public List<facebook2user> friendlistdao(facebook2user f) {
		List<facebook2user> ll=new ArrayList<facebook2user>();
		facebook2user f1=new facebook2user();
		f1.setName("mohan");
		f1.setAddress("Chennai");
		
		facebook2user f2=new facebook2user();
		f2.setName("Chunnilal");
		f2.setAddress("Mumbai");
		
		ll.add(f1);
		ll.add(f2);
		return ll;

	}


	public int checkemaildao(facebook2user iu) {
		// TODO Auto-generated method stub
		int i=0;
		try {
		PreparedStatement ps=con.prepareStatement("select * from INSTAGRAM where email=?");
		ps.setString(1, iu.getEmail());
		ResultSet res=ps.executeQuery();
		if(res.next()) {
			i=1;
		}
		
		}
		catch(SQLException ee) {
			ee.printStackTrace();
		}

		return i;
	}


	@Override
	public List<facebook2user> countrydao() {
		// TODO Auto-generated method stub
		List<facebook2user> ll=new ArrayList<facebook2user>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from country");
		
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				facebook2user iu=new facebook2user();
				iu.setCountryname(res.getString(1));
				ll.add(iu);
			}
			
			}
			catch(SQLException ee) {
				ee.printStackTrace();
			}

		
		return ll;
	}


	@Override
	public List<facebook2user> statedao(facebook2user f) {
		// TODO Auto-generated method stub
		List<facebook2user> ll=new ArrayList<facebook2user>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from state where countryname=?");
			ps.setString(1,f.getCountryname());
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				facebook2user iu=new facebook2user();
				iu.setStatename(res.getString(1));
				ll.add(iu);
			}
			
			}
			catch(SQLException ee) {
				ee.printStackTrace();
			}

		
		return ll;
		
	}


	@Override
	public List<facebook2user> citydao(facebook2user f) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				List<facebook2user> ll=new ArrayList<facebook2user>();
				try {
					PreparedStatement ps=con.prepareStatement("select * from city where statename=?");
					ps.setString(1,f.getStatename());
					ResultSet res=ps.executeQuery();
					while(res.next()) {
						facebook2user iu=new facebook2user();
						iu.setCityname(res.getString(1));
						ll.add(iu);
					}
					
					}
					catch(SQLException ee) {
						ee.printStackTrace();
					}

				
				return ll;
				
	}


		
	
}
