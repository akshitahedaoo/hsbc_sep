package com.easy.dao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import org.apache.derby.iapi.sql.ResultSet;


import com.easy.entity.easyuser;
import com.easy.utility.easyException;

public class easydao implements easydaointerface {
	
	
	public int createprofiledao(easyuser iu) throws IOException {
		// TODO Auto-generated method stub
//		File f=new File("c:/hsbc_file/db.txt");
//		if(f.createNewFile()) {
//			System.out.println("file created");
//		}
//		else {
//			System.out.println("could not create file");
//		}
//		iu.getName();
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		FileOutputStream out=new FileOutputStream(f);
//		System.out.println("enter your name");
//		String st=br.readLine();
//		for(int i=0;i<st.length();i++) {
//			out.write(st.charAt(i));
//		}
//		
//		out.close();
//		
//		Connection con=null;
		int i=5;
//		try {
//		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//		con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","aki","aki");
//		PreparedStatement ps=con.prepareStatement("insert into INSTAGRAM VALUES(?,?,?,?)");
//		ps.setString(1, iu.getName());
//		ps.setString(2, iu.getPassword());
//		ps.setString(3, iu.getEmail());
//		ps.setString(4, iu.getAddress());
//		PreparedStatement ps=con.prepareStatement("insert into instagramuser values(?,?,?,?)");
		
//		System.out.println("in dao"+iu.getName());
//		
//		if(iu.getName().equals("aki")) {
//			i=1;
//		}
//		i=ps.executeUpdate();
//		}
//		catch(ClassNotFoundException|SQLException e1) {
//			e1.printStackTrace();
//		}
		File f=new File("c:/hsbc_file/db.txt");
		FileOutputStream out=new FileOutputStream(f,true);
		
		String name=iu.getName();
		String password=iu.getPassword();
		String email=iu.getEmail();
		
		for(int j=0;j<name.length();j++)
			out.write(name.charAt(j));
		
		for(int j=0;j<password.length();j++)
			out.write(password.charAt(j));
		
		for(int j=0;j<email.length();j++)
			out.write(email.charAt(j));
		
		return i;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	public void editprofiledao() {
		// TODO Auto-generated method stub
		
	}



	public void deleteprofiledao() {
		// TODO Auto-generated method stub

		
	}
	

	public easyuser viewprofiledao(easyuser iu) {
		// TODO Auto-generated method stub
		Connection con=null;
		easyuser uu=null;
		uu=new easyuser();
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","aki","aki");
		PreparedStatement ps=con.prepareStatement("select * from INSTAGRAM where name=?");
		ps.setString(1, iu.getName());
		
		ResultSet res=ps.executeQuery();
		//how to verify resultset is having result or not
		//via next() method, if next() method will return true then resultset have some result otherwise no result
		
//		easyuser uu=null;
		
		if(res.next()) {
			
			uu.setName(res.getString(1));
			uu.setPassword(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setAddress(res.getString(4));
		}
		}
		catch(ClassNotFoundException|SQLException e1){
			e1.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return uu;
		
	}



	public ArrayList<easyuser> searchprofiledao(easyuser iu) throws easyException  {
		// TODO Auto-generated method stub
		ArrayList<easyuser> ll=new ArrayList<easyuser>();
		Connection con=null;
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","aki","aki");
		PreparedStatement ps=con.prepareStatement("select * from INSTAGRAM where name=?");
				
		ps.setString(1, iu.getName());
		
		ResultSet res=ps.executeQuery();
		
		
		while(res.next()) {
			easyuser uu=new easyuser();
			uu.setName(res.getString(1));
			uu.setPassword(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setAddress(res.getString(4));
			
			ll.add(uu);
			
		}
		if(ll.size()==0) {
			throw new easyException("");
		}
		}
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ll;
	}



	public ArrayList<easyuser> viewallprofiledao() {
		// TODO Auto-generated method stub
		ArrayList<easyuser> ll=new ArrayList<easyuser>();
		Connection con=null;
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","aki","aki");
		PreparedStatement ps=con.prepareStatement("select * from INSTAGRAM ");
		ResultSet res=ps.executeQuery();
		
		while(res.next()) {
			easyuser uu=new easyuser();
			uu.setName(res.getString(1));
			uu.setPassword(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setAddress(res.getString(4));
			
			ll.add(uu);
		}
		}
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ll;
	}



	public void viewprofiledao() {
		// TODO Auto-generated method stub
		
	}



	public easyuser viewallprofiledao(easyuser iu) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean editprofilebypassworddao(easyuser iu)  {
//		
		int i=0;
		Connection con=null;
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","aki","aki");
		PreparedStatement ps=con.prepareStatement("update INSTAGRAM set password=? where name=?");
		ps.setString(2, iu.getPassword());
		ps.setString(1, iu.getName());
		i= ps.executeUpdate();
		}
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i>0;
	}


	public int deleteprofiledao(easyuser iu) {
		// TODO Auto-generated method stub
		Connection con=null;
		int i=0;
		try{
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","aki","aki");
		PreparedStatement ps=con.prepareStatement("delete from INSTAGRAM where name=?");
		ps.setString(1,iu.getName());
	 i=ps.executeUpdate();
		}
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}


	@Override
	public Map<String, ArrayList<easyuser>> userdetailwithhistorydao() {
		// TODO Auto-generated method stub
		Map<String, ArrayList<easyuser>> m=new HashMap<String, ArrayList<easyuser>>();
		
		ArrayList<easyuser> l1=viewallprofiledao();
		ArrayList<easyuser> l2=viewallprofiledao();
		
		m.put("studentlist", l1);
		m.put("proflist", l2);
		
		return m;
			
	}
	
	

}
