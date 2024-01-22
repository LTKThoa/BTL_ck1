package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//public class connJDBC_tc {
//	
//    static String url="jdbc:mysql://localhost:3306/thuebaomn";
//    static String user="root";
//    static String pw="";
//	public static Connection getConnection() {
//		Connection connection = null;
//		try {
//			connection = DriverManager.getConnection(url, user, pw);
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		return connection;
//}
//	public List<THU_CUOC> getList() {
//	    Connection connection = getConnection();
//	    String sql = "SELECT sum(SoSachDaMuon) as\" SỐ Sách Đã Mượn\" , sum(SoSachDaTra) as\" SỐ Sách Đã Trả\" from qlthemuon";
//	    List<THU_CUOC> list = new ArrayList<>();
//
//	    try (PreparedStatement ps = connection.prepareStatement(sql);
//	         ResultSet rs = ps.executeQuery()) {
//
//	        while (rs.next()) {
//	            THU_CUOC tc = new THU_CUOC();
//	            tc.setSosachdamuon(rs.getInt("SỐ Sách Đã Mượn"));
//	            tc.setSosachdatra(rs.getInt("SỐ Sách Đã Trả"));
//	            list.add(tc);
//	        }
//
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	        System.out.println(e.toString());
//	    } 

//	    return list;
//	}
//	public static double tongttmb() {
//		 Connection connection = getConnection();
//		 String sql = "SELECT SUM(tongttoan) FROM mobile3";
//		 double x=0;
//		 try { Statement statement = connection.createStatement();
//			    ResultSet resultSet = statement.executeQuery(sql);
//		        double total = resultSet.getInt(1);
//		        x=total;
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		 return x;
		
//	}
//	public static double tongttvt() {
//		 Connection connection = getConnection();
//		 String sql = "SELECT SUM(tongttoan) FROM viettel3";
//		 double x=0;
//		 try { Statement statement = connection.createStatement();
//			    ResultSet resultSet = statement.executeQuery(sql);
//		        double total = resultSet.getInt(1);
//		        x=total;
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		 return x;
//		
//	}
//	public static double tongttvn() {
//		 Connection connection = getConnection();
//		 String sql = "SELECT SUM(tongttoan) FROM vinaphone3";
//		 double x=0;
//		 try { Statement statement = connection.createStatement();
//			    ResultSet resultSet = statement.executeQuery(sql);
//		        double total = resultSet.getInt(1);
//		        x=total;
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		 return x;
//		
//	}
//	
//}


    


