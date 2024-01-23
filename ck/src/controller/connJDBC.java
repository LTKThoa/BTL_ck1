package controller;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import view.main;

public class connJDBC {
	
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
	public static List<THUE_BAO>findAll(){
		List<THUE_BAO>THUE_BAOlist = new ArrayList<>();
		String query = "select*from thuebao";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				THUE_BAO tb = new THUE_BAO(rs.getInt("id"), rs.getString("ten"), rs.getString("sdt"), rs.getString("loaiTB"), rs.getString("tinhtrangTB"));
				THUE_BAOlist.add(tb);
			}
		}catch (Exception e) {
			
		}
		return THUE_BAOlist;
	}
	public static void insert(THUE_BAO tb) {
		String query="insert into thuebao(ten,sdt,loaiTB,tinhtrangTB) values(?,?,?,?)";
		
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, tb.getTen());
			pstmt.setString(2, tb.getSdt());
			pstmt.setString(3, tb.getLoaiTB());
			pstmt.setString(4, tb.getTinhtrangTB());
			pstmt.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
    public static void delete(THUE_BAO tb) {
    	String query = "delete from thuebao where sdt='" + tb.getSdt() + "'";
    	try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
			} catch (Exception e) {
			// TODO: handle exception
		}
    }
    public static void Update(THUE_BAO tb) {
    	String query = "Update thuebao set ten=?,sdt=?,loaiTB=?,tinhtrangTB=? where id='" + tb.getId() + "'";
    	try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
	    	pstmt.setString(1,tb.getTen());
			pstmt.setString(2,tb.getSdt());
			pstmt.setString(3,tb.getLoaiTB());
			pstmt.setString(4,tb.getTinhtrangTB());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    public static List<THUE_BAO>findByName(THUE_BAO t) {
    	List<THUE_BAO>THUE_BAO1= new ArrayList<>();
		String query = "select*from thuebao where sdt='" + t.getSdt() + "'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				THUE_BAO tb = new THUE_BAO(rs.getInt("id"), rs.getString("ten"), rs.getString("sdt"), rs.getString("loaiTB"), rs.getString("tinhtrangTB"));
				THUE_BAO1.add(tb);
			}
		}catch (Exception e) {
			
		}
		return THUE_BAO1;
    }
    public static THUE_BAO lttsql(THUE_BAO t) {
    	THUE_BAO tb = new THUE_BAO();
		String query = "select*from thuebao where id='" + t.getId() + "'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if (rs.next()) {
				 tb = new THUE_BAO(rs.getInt("id"), rs.getString("ten"), rs.getString("sdt"), rs.getString("loaiTB"), rs.getString("tinhtrangTB"));
			}
		}catch (Exception e) {
			
		}
		return tb;
    }
    public static List<THU_CUOC>findAlltc(){
		List<THU_CUOC>THU_CUOClist = new ArrayList<>();
		String query = "select*from mobile3";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				THU_CUOC tc = new THU_CUOC(rs.getInt("id"), rs.getInt("idmb"), rs.getString("ten"), rs.getString("sdt"), rs.getString("loaiTB"),rs.getString("tinhtrangTB"),rs.getDouble("sogiaygoi"), rs.getTime("thoigianttoan"), rs.getDate("ngayttoan"), rs.getDouble("tongttoan"));
				THU_CUOClist.add(tc);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return THU_CUOClist;
	}
    public static List<THU_CUOC>findByNametc(THU_CUOC t) {
    	List<THU_CUOC>THU_CUOC1= new ArrayList<>();
		String query = "select*from mobile3 where id='" + t.getId() + "'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				THU_CUOC tc = new THU_CUOC(rs.getInt("id"), rs.getInt("idmb"), rs.getString("ten"), rs.getString("sdt"), rs.getString("loaiTB"),rs.getString("tinhtrangTB"),rs.getDouble("sogiaygoi"), rs.getTime("thoigianttoan"), rs.getDate("ngayttoan"), rs.getDouble("tongttoan"));
				THU_CUOC1.add(tc);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		return THU_CUOC1;
    }
    public static void deletetc(THU_CUOC tc) {
    	String query = "delete from mobile3 where idmb='" + tc.getIdmb() + "'";
    	try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
			} catch (Exception e) {
			// TODO: handle exception
		}
    }
    public static THUE_BAO findByID(THUE_BAO t) {
    	THUE_BAO tb = new THUE_BAO();
		String query = "select*from thuebao where id='" + t.getId() + "'and tinhtrangTB='Hoạt động";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if (rs.next()) {
				 tb = new THUE_BAO(rs.getInt("id"), rs.getString("ten"), rs.getString("sdt"), rs.getString("loaiTB"), rs.getString("tinhtrangTB"));
			}
			
			
		}catch (Exception e) {
	
		}
		
		return tb;
    }
    public static void inserttc(THU_CUOC tc) {
		String query="insert into mobile3(id,ten,sdt,loaiTB,tinhtrangTB,sogiaygoi,thoigianttoan,ngayttoan) values(?,?,?,?,?,?,?,?)";
		
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, tc.getId());
			pstmt.setString(2, tc.getTen());
			pstmt.setString(3, tc.getSdt());
			pstmt.setString(4, tc.getLoaiTB());
			pstmt.setString(5, tc.getTinhtrangTB());
			pstmt.setDouble(6, tc.getSogiaygoi());
			pstmt.setTime(7, tc.getThoigianttoan());
			pstmt.setDate(8, tc.getNgayttoan());
			pstmt.execute();
			if (tc.getTen()==null) {
				JOptionPane.showMessageDialog(null, "Thuê bao này không có hoặc sdt đã ngưng hoạt động!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showConfirmDialog(null, "Vui lòng nhập đúng kiểu dữ liệu!");
		}
	}
    public static THU_CUOC lttsqltc(THU_CUOC t) {
    	THU_CUOC tc = new THU_CUOC();
		String query = "select*from mobile3 where idmb='" + t.getIdmb() + "'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if (rs.next()) {
				 tc = new THU_CUOC(rs.getInt("id"), rs.getInt("idmb"), rs.getString("ten"), rs.getString("sdt"), rs.getString("loaiTB"),rs.getString("tinhtrangTB"),rs.getDouble("sogiaygoi"), rs.getTime("thoigianttoan"), rs.getDate("ngayttoan"), rs.getDouble("tongttoan"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		return tc;
    }
    public static void Updatetc(THU_CUOC tb) {
    	String query = "Update mobile3 set sogiaygoi=?,thoigianttoan=?,ngayttoan=? where idmb='" + tb.getIdmb() + "'";
    	try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
	    	pstmt.setDouble(1,tb.getSogiaygoi());
			pstmt.setTime(2,tb.getThoigianttoan());
			pstmt.setDate(3, tb.getNgayttoan());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.toString());
		}
    }
    //VIETTEL
    public static List<THU_CUOCvt>findAllvt(){
		List<THU_CUOCvt>THU_CUOClist = new ArrayList<>();
		String query = "select*from viettel3";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				THU_CUOCvt tc = new THU_CUOCvt(rs.getInt("id"), rs.getInt("idvt"), rs.getString("ten"), rs.getString("sdt"), rs.getString("loaiTB"),rs.getString("tinhtrangTB"),rs.getDouble("sogiaygoi"), rs.getTime("thoigianttoan"), rs.getDate("ngayttoan"), rs.getDouble("tongtt"));
				THU_CUOClist.add(tc);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return THU_CUOClist;
	}
    public static void insertvt(THU_CUOCvt tc) {
		String query="insert into viettel3(id,ten,sdt,loaiTB,tinhtrangTB,sogiaygoi,thoigianttoan,ngayttoan) values(?,?,?,?,?,?,?,?)";
		
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, tc.getId());
			pstmt.setString(2, tc.getTen());
			pstmt.setString(3, tc.getSdt());
			pstmt.setString(4, tc.getLoaiTB());
			pstmt.setString(5, tc.getTinhtrangTB());
			pstmt.setDouble(6, tc.getSogiaygoi());
			pstmt.setTime(7, tc.getThoigianttoan());
			pstmt.setDate(8, tc.getNgayttoan());
			pstmt.execute();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}
    public static void deletevt(THU_CUOCvt tc) {
    	String query = "delete from viettel3 where idvt='" + tc.getIdvt() + "'";
    	try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
			} catch (Exception e) {
			// TODO: handle exception
		}
    }
    public static THU_CUOCvt lttsqlvt(THU_CUOCvt t) {
    	THU_CUOCvt tc = new THU_CUOCvt();
		String query = "select*from viettel3 where idvt='" + t.getIdvt() + "'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if (rs.next()) {
				 tc = new THU_CUOCvt(rs.getInt("id"), rs.getInt("idvt"), rs.getString("ten"), rs.getString("sdt"), rs.getString("loaiTB"),rs.getString("tinhtrangTB"),rs.getDouble("sogiaygoi"), rs.getTime("thoigianttoan"), rs.getDate("ngayttoan"), rs.getDouble("tongtt"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		return tc;
    }
    public static void Updatevt(THU_CUOCvt tb) {
    	String query = "Update viettel3 set sogiaygoi=?,thoigianttoan=?,ngayttoan=? where idvt='" + tb.getIdvt() + "'";
    	try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
	    	pstmt.setDouble(1,tb.getSogiaygoi());
			pstmt.setTime(2,tb.getThoigianttoan());
			pstmt.setDate(3, tb.getNgayttoan());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.toString());
		}
    }
    public static List<THU_CUOCvt>findByNamevt(THU_CUOCvt t) {
    	List<THU_CUOCvt>THU_CUOC1= new ArrayList<>();
		String query = "select*from viettel3 where id='" + t.getId() + "'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				THU_CUOCvt tc = new THU_CUOCvt(rs.getInt("id"), rs.getInt("idvt"), rs.getString("ten"), rs.getString("sdt"), rs.getString("loaiTB"),rs.getString("tinhtrangTB"),rs.getDouble("sogiaygoi"), rs.getTime("thoigianttoan"), rs.getDate("ngayttoan"), rs.getDouble("tongtt"));
				THU_CUOC1.add(tc);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		return THU_CUOC1;
    }
  //VINAPHONE
    public static List<THU_CUOCvn>findAllvn(){
		List<THU_CUOCvn>THU_CUOClist = new ArrayList<>();
		String query = "select*from vinaphone3";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				THU_CUOCvn tc = new THU_CUOCvn(rs.getInt("id"), rs.getInt("idvn"), rs.getString("ten"), rs.getString("sdt"), rs.getString("loaiTB"),rs.getString("tinhtrangTB"),rs.getDouble("sogiaygoi"), rs.getTime("thoigianttoan"), rs.getDate("ngayttoan"), rs.getDouble("tongtt"));
				THU_CUOClist.add(tc);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return THU_CUOClist;
	}
    public static void insertvn(THU_CUOCvn tc) {
		String query="insert into vinaphone3(id,ten,sdt,loaiTB,tinhtrangTB,sogiaygoi,thoigianttoan,ngayttoan) values(?,?,?,?,?,?,?,?)";
		
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, tc.getId());
			pstmt.setString(2, tc.getTen());
			pstmt.setString(3, tc.getSdt());
			pstmt.setString(4, tc.getLoaiTB());
			pstmt.setString(5, tc.getTinhtrangTB());
			pstmt.setDouble(6, tc.getSogiaygoi());
			pstmt.setTime(7, tc.getThoigianttoan());
			pstmt.setDate(8, tc.getNgayttoan());
			pstmt.execute();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}
    public static void deletevn(THU_CUOCvn tc) {
    	String query = "delete from vinaphone3 where idvn='" + tc.getIdvn() + "'";
    	try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
			} catch (Exception e) {
			// TODO: handle exception
		}
    }
    public static THU_CUOCvn lttsqlvn(THU_CUOCvn t) {
    	THU_CUOCvn tc = new THU_CUOCvn();
		String query = "select*from vinaphone3 where idvn='" + t.getIdvn() + "'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if (rs.next()) {
				 tc = new THU_CUOCvn(rs.getInt("id"), rs.getInt("idvn"), rs.getString("ten"), rs.getString("sdt"), rs.getString("loaiTB"),rs.getString("tinhtrangTB"),rs.getDouble("sogiaygoi"), rs.getTime("thoigianttoan"), rs.getDate("ngayttoan"), rs.getDouble("tongtt"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		return tc;
    }
    public static void Updatevn(THU_CUOCvn tb) {
    	String query = "Update vinaphone3 set sogiaygoi=?,thoigianttoan=?,ngayttoan=? where idvn='" + tb.getIdvn() + "'";
    	try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
	    	pstmt.setDouble(1,tb.getSogiaygoi());
			pstmt.setTime(2,tb.getThoigianttoan());
			pstmt.setDate(3, tb.getNgayttoan());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.toString());
		}
    }
    public static List<THU_CUOCvn>findByNamevn(THU_CUOCvn t) {
    	List<THU_CUOCvn>THU_CUOC1= new ArrayList<>();
		String query = "select*from vinaphone3 where id='" + t.getId() + "'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				THU_CUOCvn tc = new THU_CUOCvn(rs.getInt("id"), rs.getInt("idvn"), rs.getString("ten"), rs.getString("sdt"), rs.getString("loaiTB"),rs.getString("tinhtrangTB"),rs.getDouble("sogiaygoi"), rs.getTime("thoigianttoan"), rs.getDate("ngayttoan"), rs.getDouble("tongtt"));
				THU_CUOC1.add(tc);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		return THU_CUOC1;
    }
    public static double tongttmb() {
		 Connection connection = getConnection();
		 String sql = "SELECT SUM(tongttoan) FROM mobile3";
		 double x=0;
		 try { Statement statement = connection.createStatement();
			    ResultSet resultSet = statement.executeQuery(sql);
			    if (resultSet.next()) {
			        x = resultSet.getDouble(1);
			    } else {
			        System.out.println("Không có kết quả nào được trả về");
			    }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		 return x;
		
	}
	public static double tongttvt() {
		 Connection connection = getConnection();
		 String sql = "SELECT SUM(tongtt) FROM viettel3";
		 double x=0;
		 try { Statement statement = connection.createStatement();
			    ResultSet resultSet = statement.executeQuery(sql);
			    if (resultSet.next()) {
			        x = resultSet.getDouble(1);
			    } else {
			        System.out.println("Không có kết quả nào được trả về");
			    }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		 return x;		
	}
	public static double tongttvn() {
		 Connection connection = getConnection();
		 String sql = "SELECT SUM(tongtt) FROM vinaphone3";
		 double x=0;
		 try {
			   Statement statement = connection.createStatement();
			    ResultSet resultSet = statement.executeQuery(sql);
			    if (resultSet.next()) {
			        x = resultSet.getDouble(1);
			    } else {
			        System.out.println("Không có kết quả nào được trả về");
			    }
		    
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}       
		 return x;
		
	}
}
