package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.StudentBean;

public class RegisterDao {
	static Connection con;
	PreparedStatement ps;
	
	public RegisterDao() {
		con=MySqlConnection.getInstance();
	}

	public static int InsertData(StudentBean ss) {
		int result=0;
		String query="Insert into student_info VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, ss.getName());
			ps.setString(2, ss.getMobile_no());
			ps.setString(3, ss.getCollege());
			ps.setString(4, ss.getGmail());
			ps.setString(5, ss.getPassword());
			ps.setString(6, ss.getTech());
			ps.setString(7, ss.getAddress());
			result= ps.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}
	public static int DeleteData(StudentBean ss) {
		int result=0;
		String Query1="Delete from student_info where Name=?";
		try {
			PreparedStatement ps = con.prepareStatement(Query1);
			ps.setString(1, ss.getName());
			result= ps.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
