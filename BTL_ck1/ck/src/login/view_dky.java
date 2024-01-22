package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class view_dky extends javax.swing.JFrame{
	

	public view_dky() {
		// TODO Auto-generated constructor stub
		this.setTitle("Manage_Singup");
		new conn();
		this.setSize(335,390);
		Border vtren = BorderFactory.createLineBorder(Color.white,2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font arial = new Font("Arial",Font.CENTER_BASELINE,25);
		Font arial11 = new Font("Arial",Font.ROMAN_BASELINE, 11);
		JPanel panel = new JPanel(new FlowLayout());
		JPanel dki1 = new JPanel(new BorderLayout());
		dki1.setBackground(Color.pink);
		//dki1.setBorder(vtren);
		dki1.setPreferredSize(new Dimension(335,90));
		JLabel dkilb = new JLabel("ĐĂNG KÍ", JLabel.CENTER);
		dkilb.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("cute_64.png"))));
		dkilb.setFont(arial);
		dki1.add(dkilb, BorderLayout.CENTER);
		panel.add(dki1);
		JPanel br1 = new JPanel();
		JPanel br = new JPanel(new GridLayout(7,1));
		br.setBackground(new Color(255,228,225));
		
		br.setPreferredSize(new Dimension(300,180));
		JLabel user = new JLabel("Nhập tên đăng nhập");
		user.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(view.main.class.getResource("chan_16.png"))));
		user.setFont(arial11);
		br.add(user);
		JTextField usertf = new JTextField();
		br.add(usertf);
		JLabel mk = new JLabel("Nhập mật khẩu");
		mk.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(view_login.class.getResource("mk.png"))));
		mk.setFont(arial11);
		br.add(mk);
		 JPasswordField mktf =new JPasswordField();
		br.add(mktf);
		JLabel mk2 = new JLabel("Nhập lại mật khẩu");
		mk2.setFont(arial11);
		br.add(mk2);
		 JPasswordField mktf2 =new JPasswordField();
		br.add(mktf2);
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255,228,225));
		JButton dkibt = new JButton("Đăng kí");
		panel2.add(dkibt);
		br.add(panel2);
		panel.add(br1);
		br1.setBackground(new Color(255,228,225));		
		br1.setPreferredSize(new Dimension(335,250));
		br1.add(br);
		br.setBackground(new Color(255,228,225));		
		br.setPreferredSize(new Dimension(270,230));
		panel.setBackground(Color.white);
		dkibt.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(view_login.class.getResource("dki.png"))));
		dkibt.addMouseListener(new MouseAdapter() {
    		 @Override
    		public void mouseClicked(MouseEvent e) {
    			if (usertf.getText().length()==0||mktf.getText().length()==0||mktf2.getText().length()==0) {
    				   JOptionPane.showMessageDialog(null, "Không được để thông tin trống ");
   	                return;
    			}else 
    				if (mktf.getText().length()<4) 
    					   JOptionPane.showMessageDialog(null, "Mật Khẩu Nhiều Hơn 3 Kí Tự");
    				
    			
    			else {
    				if (!mktf.getText().equals(mktf2.getText())) {
    					 JOptionPane.showMessageDialog(null, "Mật khẩu và Nhập lại mật khẩu không khớp!");
    			            return;
    				}
    				Connection connection = conn.getConnection();
    					String sql = "INSERT INTO login ( `user`, `mk`) VALUES (?,?);";
    				
    					try {
    						 PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
    						 ps.setString(1,usertf.getText() );
    				         ps.setString(2, mktf.getText());
    				         int n = ps.executeUpdate();
    							
    					     if (n != 0) {
    		                        JOptionPane.showMessageDialog(null, "Đăng ký thành công ");
    		                        setVisible(false);
    		                        new view_login();
    		                    } else {
    		                        JOptionPane.showMessageDialog(null, "Đăng ký thất bại! ");
    		                    }
    		                } catch (SQLException ex) {
    		                ex.printStackTrace();
    		                System.out.println(ex.toString());
    		                JOptionPane.showMessageDialog(null, " Tài khoảng đã tồn tại! ");
    		            }
    				
    		}
    			}
    		 
    		
		});
    	usertf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mktf.requestFocus();
			}
		});
    	mktf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mktf2.requestFocus();
			}
		});
		mktf2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
    			 if (usertf.getText().length()==0||mktf.getText().length()==0||mktf2.getText().length()==0) {
  				   JOptionPane.showMessageDialog(null, "Không được để thông tin trống ");
 	                return;
  			}else 
  				if (mktf.getText().length()<4) 
  					   JOptionPane.showMessageDialog(null, "Mật Khẩu Nhiều Hơn 3 Kí Tự");
  				
  			
  			else {
  				if (!mktf.getText().equals(mktf2.getText())) {
  					 JOptionPane.showMessageDialog(null, "Mật khẩu và Nhập lại mật khẩu không khớp!");
  			            return;
  				}
  				Connection connection = conn.getConnection();
  					String sql = "INSERT INTO login ( `user`, `mk`) VALUES (?,?);";
  				
  					try {
  						 PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
  						 ps.setString(1,usertf.getText() );
  				         ps.setString(2, mktf.getText());
  				         int n = ps.executeUpdate();
  							
  					     if (n != 0) {
  		                        JOptionPane.showMessageDialog(null, "Đăng ký thành công ");
  		                        setVisible(false);
  		                        new view_login();
  		                    } else {
  		                        JOptionPane.showMessageDialog(null, "Đăng ký thất bại! ");
  		                    }
  		                } catch (SQLException ex) {
  		                ex.printStackTrace();
  		                System.out.println(ex.toString());
  		                JOptionPane.showMessageDialog(null, " Tài khoảng đã tồn tại! ");
  		            }
  				
  		}
  			}
  		 
  		
		});
		
		add(panel);
		setLocationRelativeTo(null);
	    setVisible(true);
	    setResizable(false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new view_dky();
	}

}
