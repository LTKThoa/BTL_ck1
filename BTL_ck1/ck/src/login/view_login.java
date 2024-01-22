package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class view_login extends javax.swing.JFrame{
	private static JPasswordField mktf =new JPasswordField();
	private static JTextField usertf = new JTextField();
	private static JButton dkibt = new JButton("Đăng kí");
	private static JButton dnhapbt = new JButton("Đăng nhập");
 
	public view_login() {
		this.setTitle("Manage_Login");
		this.setSize(670, 335);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Border vden = BorderFactory.createLineBorder(Color.black,2);
		Border vtren = BorderFactory.createLineBorder(Color.white,2);
		Font arial11 = new Font("Arial",Font.ROMAN_BASELINE, 11);
		Font arial11id = new Font("Arial",Font.CENTER_BASELINE, 11);
		Font arial = new Font("Arial",Font.CENTER_BASELINE,20);
		JPanel panel = new JPanel(new GridLayout(1,2));
		panel.setBackground(Color.black);
		JPanel lgpn = new JPanel();
		JLabel logolb = new JLabel();
		logolb.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(view_login.class.getResource("logo2.png"))));
		lgpn.add(logolb);
		lgpn.setBackground(Color.pink);
		lgpn.setBorder(vtren);
		panel.add(lgpn);
		JPanel br = new JPanel(new FlowLayout());
		br.setBackground(Color.pink);
		panel.add(br);
		JPanel singuppn = new JPanel(new BorderLayout());
		singuppn.setBackground(Color.pink);
		JLabel singup = new JLabel("Đăng nhập",JLabel.CENTER);
		singup.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(view_login.class.getResource("cute_24.png"))));
		singup.setFont(arial);
		singuppn.add(singup, BorderLayout.CENTER);
		singuppn.setPreferredSize(new Dimension(350,50));
		//singuppn.setBorder(vden);
		br.add(singuppn);
		JPanel dnhappn1 = new JPanel();
		dnhappn1.setBackground(new Color(255,228,225));
		JPanel dnhappn = new JPanel(new GridLayout(6,1));
		dnhappn.setBackground(new Color(255,228,225));
		br.add(dnhappn1);
		dnhappn1.setPreferredSize(new Dimension(400,200));
		dnhappn1.add(dnhappn);
		dnhappn1.setBorder(vtren);
		dnhappn.setPreferredSize(new Dimension(280,190));
		JLabel user = new JLabel("Tên đăng nhập");
		user.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(view.main.class.getResource("chan_16.png"))));
		user.setFont(arial11);
		dnhappn.add(user);
		
		dnhappn.add(usertf);
		JLabel mk = new JLabel("Mật khẩu");
		mk.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(view_login.class.getResource("mk.png"))));
		mk.setFont(arial11);
		dnhappn.add(mk);
		
		dnhappn.add(mktf);
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255,228,225));
		JCheckBox showPasswordCheckBox = new JCheckBox("Hiển thị mật khẩu");
		showPasswordCheckBox.setBackground(new Color(255,228,225));
		dnhappn.add(showPasswordCheckBox);
		panel2.add(dnhapbt);
		dnhappn.add(panel2);
		dnhapbt.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(view_login.class.getResource("login_16.png"))));
		
		JPanel dkipn = new JPanel();
		dkipn.setBackground(Color.pink);
		br.add(dkipn);
		dkipn.setPreferredSize(new Dimension(330,90));
		JLabel dkilb = new  JLabel("Đăng kí nêú bạn chưa có tài khoản");
		dkilb.setFont(arial11id);
		dkipn.add(dkilb);
		dkipn.add(dkibt);
		dkibt.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(view_login.class.getResource("dki.png"))));
	
		showPasswordCheckBox.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
               
                 if (showPasswordCheckBox.isSelected()) {
               	  mktf.setEchoChar((char) 0); 
                 } else {
               	  mktf.setEchoChar('\u2022'); 
                 }
             }
         });
		mktf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	try {
	                    if (usertf.getText().length() == 0
	                            || mktf.getText().length() == 0) {
	                    	JOptionPane.showMessageDialog(null,"Vui lòng nhập dữ liệu bắt buộc!");
	                    } else {
	                        TK taiKhoan = conn.login(usertf.getText(), mktf.getText());
	                        if (taiKhoan == null) {
	                        	JOptionPane.showMessageDialog(null,"Tên đăng nhập và mật khẩu không đúng!");
	                        	
                            } else {
                            	setVisible(false);;
                            	view.main frame = new view.main();
                                frame.setVisible(true);
 
	                        }
	                    }
	                } catch (Exception ex) {
	                System.out.println(ex);
	                }
                }
            }
        });
		dnhapbt.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 try {
	                    if (usertf.getText().length() == 0
	                            || mktf.getText().length() == 0) {
	                    	JOptionPane.showMessageDialog(null,"Vui lòng nhập dữ liệu bắt buộc!");
	                    } else {
	                        TK taiKhoan = conn.login(usertf.getText(), mktf.getText());
	                        if (taiKhoan == null) {
	                        	JOptionPane.showMessageDialog(null,"Tên đăng nhập hoặc mật khẩu không đúng!");
	                        } else {
	                        	setVisible(false);
                            	view.main frame = new view.main();
//                            	a=usertf.getText();
                                frame.setVisible(true); 
                                
	                        }
	                    }
	                } catch (Exception ex) {
	                System.out.println(ex);
	                }
				
			}
	});
		dkibt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				view_dky frame= new view_dky();
				frame.setVisible(true);
//				frame.setResizable(false);
//				frame.setTitle("Đăng Ký Tài Khoản");
				super.mouseClicked(e);
			}
			
		});	
		add(panel);
		setLocationRelativeTo(null);
	    setVisible(true);
	    setResizable(false);
	}
	public static String x(String x) {
		return usertf.getText();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	new view_login();
	}

}
