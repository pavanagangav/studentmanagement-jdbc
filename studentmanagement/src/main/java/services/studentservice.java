package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.student;

public class studentservice {
private Connection conn;

	public studentservice(Connection conn) {
	super();
	this.conn = conn;
}


	public boolean addstudent(student st) {
		boolean f=false;
		try {
			String sql="insert into student (pinnumber,name,email,branch) values(?,?,?,?)";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, st.getPinnumber());
			pmst.setString(2, st.getName());
			pmst.setString(3, st.getEmail());
			pmst.setString(4, st.getBranch());
			int i=pmst.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<student> fetchall(){
		List<student> std=new ArrayList<student>();
		student s=null;
		try {
			
			String sql="select * from student";
			PreparedStatement pmst =conn.prepareStatement(sql);
			ResultSet rs=pmst.executeQuery();
			while(rs.next()) {
				s=new student();
				s.setPinnumber(rs.getString(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setBranch(rs.getString(4));
				std.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return std;
	}
public boolean deletestu(String pinnumber) {
	boolean f =false;
	try {
		String sql="delete from student where pinnumber = ?";
		PreparedStatement pmst =conn.prepareStatement(sql);
		pmst.setString(1, pinnumber);
		int i=pmst.executeUpdate();
		if(i==1) {
			f=true;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
	
}
public boolean updatestu(student sm) {
	boolean f=false;
	try {
		String sql="update student set name = ?,email = ?,branch = ? where pinnumber=?";
		PreparedStatement pmst =conn.prepareStatement(sql);
		pmst.setString(1, sm.getName());
		pmst.setString(2, sm.getEmail());
		pmst.setString(3, sm.getBranch());
		pmst.setString(4, sm.getPinnumber());
		int i =pmst.executeUpdate();
		if(i==1)
		{
			f=true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
	
}
public student getbystu(String pinnumber) {
	student s=null ;
	try {
		String sql="select *  from student where pinnumber =?";
		PreparedStatement pmst =conn.prepareStatement(sql);
		pmst.setString(1, pinnumber);
		ResultSet rs =pmst.executeQuery();
		while(rs.next()) {
			s=new student();
			s.setPinnumber(rs.getString(1));
			s.setName(rs.getString(2));
			s.setEmail(rs.getString(3));
			s.setBranch(rs.getString(4));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return s;
}
	

}
 