package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.THUE_BAO;
import controller.connJDBC;

public class conn {

		static String url="jdbc:mysql://localhost:3306/thuebaomn";
	    static String user="root";
	    static String pw="";
		public static Connection getConnection() {
			Connection connection = null;
			try {
				connection = DriverManager.getConnection(url, user, pw);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			return connection;
	}
		public static TK login (String user, String mk){
			Connection connection = getConnection();
			 String sql = "SELECT * FROM login WHERE user LIKE ? AND mk LIKE ?";
		        TK taikhoan = new TK();
		        try {
		            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		            ps.setString(1, user);
		            ps.setString(2, mk);
		            ResultSet rs = ps.executeQuery();
		            if (rs.next()) {
		                taikhoan = new TK();		                
		                taikhoan.setUser(rs.getString("user"));
		                taikhoan.setMk(rs.getString("mk"));             
		            }
		            ps.close();
		            connection.close();
		            return taikhoan;
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			return null;
		}
	public static String x(String x) {
		return x;
	}
	
	}




