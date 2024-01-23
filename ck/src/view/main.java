package view;

import java.awt.BorderLayout;
import java.net.URL;
import java.awt.CardLayout;

import javax.swing.border.Border;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.EventHandler;
import java.lang.System.Logger;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;


import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.CellEditorListener;
import javax.swing.plaf.basic.BasicIconFactory;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.Value;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.toedter.calendar.JDateChooser;

import controller.THUE_BAO;
import controller.THU_CUOC;
import controller.THU_CUOCvn;
import controller.THU_CUOCvt;
import controller.connJDBC;
import login.view_login;


public class main extends javax.swing.JFrame{
	private static JTable tbtb = new JTable();
	private static JTable tbtb1 = new JTable();
	private static JTable tbtbvt = new JTable();
	private static JTable tbtbvn = new JTable();
	private static JTextField tttf1 = new JTextField(25);
	private static JTextField tentf1 = new JTextField(25);
	private static JTextField sdttf1 = new JTextField(25);
	private static JTextField loaitf1 = new JTextField(25);
	private static JRadioButton radioButton1ed = new JRadioButton("Hoạt động");
	private static JRadioButton radioButton2ed = new JRadioButton("Ngưng hoạt động");
	private static JTextField sgoitfsua = new JTextField(5);
	private static JTextField tgtttfsua = new JTextField(10);	
	private static JDateChooser jDateChooser1 = new JDateChooser();
	private static JTextField sgoitfsuavt = new JTextField(5);
	private static JTextField tgtttfsuavt = new JTextField(10);	
	private static JDateChooser jDateChooser1vt = new JDateChooser();
	private static JTextField sgoitfsuavn = new JTextField(5);
	private static JTextField tgtttfsuavn = new JTextField(10);	
	private static JDateChooser jDateChooser1vn = new JDateChooser();
	private static String a;

	
public main() {
		// TODO Auto-generated constructor stub
		
		this.setTitle("Quản lý thuê bao & thu cước điện thoại");
		this.setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    URL urlIconmanagea =main.class.getResource("logo_3.png");
        Image img =Toolkit.getDefaultToolkit().createImage(urlIconmanagea);
 	    setIconImage(img);
		Border vden = BorderFactory.createLineBorder(Color.black,2);		
	    Font arial = new Font("Arial",Font.CENTER_BASELINE,20);
	    Font arial15 = new Font("Arial",Font.CENTER_BASELINE, 15);
	    Font arial11 = new Font("Arial",Font.ROMAN_BASELINE, 11);
	    Font arial11id = new Font("Arial",Font.CENTER_BASELINE, 11);
				
		JPanel br = new JPanel(new BorderLayout());
	
  //thue beo
	    JPanel tbpn = new JPanel(new BorderLayout());
	    br.add(tbpn,BorderLayout.CENTER);
	    tbpn.setBackground(Color.white);
	    tbpn.setPreferredSize( new Dimension(700, 700));  
	    
	    //chuc nang
	    JPanel cn = new JPanel(new BorderLayout());    
	    JPanel cnpn = new JPanel(new FlowLayout());
	    JLabel chucnang = new JLabel("Chức năng:");
	    chucnang.setFont(arial15);
	    JButton them = new JButton("Thêm TB");
			JPanel thcnth = new JPanel(new FlowLayout());
			thcnth.setPreferredSize(new Dimension(500,100));
			thcnth.setBorder(vden);
			JLabel tenlb = new JLabel("   Họ và Tên:");
			JTextField tentf = new JTextField(25);
			thcnth.add(tenlb);
			thcnth.add(tentf);     
			JLabel sdtlb = new JLabel("               SDT: ");
			JTextField sdttf = new JTextField(25);
			thcnth.add(sdtlb);
			thcnth.add(sdttf);
			JLabel loailb = new JLabel("           Loại TB: ");
			JTextField loaitf = new JTextField(24);
			thcnth.add( loailb);
			thcnth.add(loaitf);
			JLabel ttlb = new JLabel("          Tình trạng TB:  ");			
	        JTextField tttf = new JTextField(25);	        
			thcnth.add(ttlb);
			 // Tạo đối tượng JRadioButton
	        JRadioButton radioButton1 = new JRadioButton("Hoạt động");
	        JRadioButton radioButton2 = new JRadioButton("Ngưng hoạt động");
	        // Thêm nút chọn vào nhóm
	        ButtonGroup buttonGroup = new ButtonGroup();
	        buttonGroup.add(radioButton1);
	        buttonGroup.add(radioButton2);
	        thcnth.add(radioButton1);
	        thcnth.add(radioButton2);
	        radioButton1.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseReleased(MouseEvent e) {
	               tttf.setText("Hoạt động");
	            }
	        });
	        radioButton2.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseReleased(MouseEvent e) {
	               tttf.setText("Ngưng hoạt động");
	            }
	        });		
			JButton lmbt = new JButton("Làm mới");
			JButton thembt = new JButton("Thêm->");
			thcnth.add(lmbt);
			thcnth.add(thembt);
			thcnth.setVisible(false);
			
		
	    JButton xoa = new JButton("Xóa TB");
			JPanel xoapn = new JPanel(new FlowLayout());
			xoapn.setPreferredSize(new Dimension(500,50));
			xoapn.setBorder(vden);
			JLabel xoalb = new JLabel("Nhập sdt cần xóa: ");
			xoapn.add(xoalb);
			JTextField xoatf = new JTextField(25);
			xoapn.add(xoatf);
			JButton xoabt = new JButton("Xoá");
			xoapn.add(xoabt);
			xoapn.setVisible(false);
			
	    JButton sua = new JButton("Sửa TB"); 
	    	JPanel suapn1 = new JPanel();
	    	suapn1.setPreferredSize(new Dimension(500,100));
	    	suapn1.setBorder(vden);
	    	JLabel sualb = new JLabel("Nhập id cần sửa: ");
			suapn1.add(sualb);
			JTextField suatf = new JTextField(25);
			suapn1.add(suatf);
			JButton ok = new JButton("OK");
			suapn1.add(ok);
			suapn1.setVisible(false);
	    	JPanel suapn = new JPanel(new FlowLayout());
	    	suapn.setPreferredSize(new Dimension(500,100));
	    	suapn.setBorder(vden);
			JLabel tenlb1 = new JLabel(" Họ và Tên:");			
			suapn.add(tenlb1);
			suapn.add(tentf1);
			JLabel sdtlb1 = new JLabel("               SDT: ");		
			suapn.add(sdtlb1);
			suapn.add(sdttf1); 
			JLabel loailb1 = new JLabel("            Loại TB:");			
			suapn.add( loailb1);
			suapn.add(loaitf1);
			JLabel ttlb1 = new JLabel("         Tình trạng TB:   ");
			JPanel x = new JPanel();
			suapn.add(x);
			suapn.add(ttlb1);
	        ButtonGroup buttonGrouped = new ButtonGroup();
	        buttonGrouped.add(radioButton1ed);
	        buttonGrouped.add(radioButton2ed);
	        suapn.add(radioButton1ed);
	        suapn.add(radioButton2ed);
	        radioButton1ed.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseReleased(MouseEvent e) {
	               tttf1.setText("Hoạt động");
	            }
	        });
	        radioButton2ed.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseReleased(MouseEvent e) {
	               tttf1.setText("Ngưng hoạt động");
	            }
	        });
	    	JButton suabt = new JButton("Sửa");
	    	suapn.add(suabt);
	    	JButton ql1 = new JButton("<");
	    	suapn.add(ql1);
	    	suapn.setVisible(false);
	    	
	    JTextField tktf1 = new JTextField(20);
	    tktf1.setText("Nhập sdt cần tìm");
	    tktf1.setFont(arial11);
	    JButton cntk = new JButton("Tìm kiếm");
	    cntk.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("tiemkiem.png"))));
	    cntk.setBackground(new Color(255,228,225));
	    JButton ql = new JButton("<");
	    cnpn.add(chucnang);
	    cnpn.add(them);
	    cnpn.add(xoa);
	    cnpn.add(sua);
	    cnpn.add(tktf1);
	    cnpn.add(cntk);
	    cnpn.add(ql);
		ql.setVisible(false);
	    cn.add(cnpn,BorderLayout.NORTH);
	    tbpn.add(cn,BorderLayout.NORTH);
	    xoa.setBackground(new Color(255,228,225));
	    sua.setBackground(new Color(255,228,225));
	    them.setBackground(new Color(255,228,225));
	    xoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("xoa.png"))));    
	    sua.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("sua.png"))));
	    them.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("save.png"))));
	    cnpn.setBackground(Color.pink);
	    cnpn.setBorder(vden);
	    //bangtb
	    JPanel tablepn = new JPanel(new BorderLayout());
	    
	    JLabel tentb = new JLabel("Danh sách thuê bao", JLabel.CENTER);
	    tentb.setFont(arial);
	    tentb.setBackground(Color.pink);
	    tentb.setOpaque(true);
	    tablepn.add(tentb,BorderLayout.NORTH);
	    DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("ID");
	    model.addColumn("Họ và Tên");
	    model.addColumn("SDT");
	    model.addColumn("Loại TB");
	    model.addColumn("Tình trạng TB");
	    tbtb = new JTable(model);
	    JScrollPane sc = new JScrollPane();
	    sc.setViewportView(tbtb);
	    tablepn.add(sc,BorderLayout.CENTER);
	    
	    showdata(connJDBC.findAll());
	    
	    tbpn.add(tablepn,BorderLayout.CENTER);
	   
	    tablepn.setBackground(Color.pink);
	    tablepn.setBorder(vden);
	    tbtb.setBackground(new Color(255,228,225));
	    TableColumn idColumn1 = tbtb.getColumnModel().getColumn(model.findColumn("ID"));
	    idColumn1.setPreferredWidth(20);
	    
	    tbpn.setVisible(false);
 //thu cuoc
	    JPanel tcpn = new JPanel(new BorderLayout());
	    br.add(tcpn,BorderLayout.CENTER);
	    tcpn.setBackground(Color.pink);
	    tcpn.setPreferredSize( new Dimension(600, 700));  

      // tab
	    JTabbedPane tab = new JTabbedPane();
	    JPanel mobile = new JPanel(new BorderLayout());
        mobile.setPreferredSize( new Dimension(1000, 600));
	    JPanel viettel = new JPanel(new BorderLayout());
	    viettel.setPreferredSize( new Dimension(1000, 600));
	    JPanel vinaphone = new JPanel(new BorderLayout());
	    vinaphone.setPreferredSize( new Dimension(1000, 600));
	    tab.addTab("Mobile",mobile);
	    tab.addTab("Viettel",viettel);
	    tab.addTab("Vinaphone", vinaphone);
	    tab.setIconAt(0, new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("mobiphone.jpg"))));
	    tab.setIconAt(2, new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("vina.png"))));
	    tab.setIconAt(1, new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("viettel.png"))));
	    tcpn.add(tab, BorderLayout.NORTH);	    
        tcpn.setVisible(false);
   //MOBILE
      //chuc nang
	    JPanel cnmb = new JPanel(new BorderLayout());    
	    JPanel cnpnmb = new JPanel(new FlowLayout());
	   
	    JLabel chucnangmb = new JLabel("Chức năng:");
	    chucnangmb.setFont(arial15);
	    
	    
	    JButton themmb = new JButton("Thêm");
	    JPanel thempnmb = new JPanel(new FlowLayout());
	    thempnmb.setPreferredSize(new Dimension(750,70));
	    thempnmb.setBorder(vden);
	    JLabel idth = new JLabel("ID:");
	    JTextField idtfth = new JTextField(5);
	    thempnmb.add(idth);
	    thempnmb.add(idtfth);
	    JLabel sgoith = new JLabel("       Số giây gọi:");
	    JTextField sgoitfth = new JTextField(5);
	    thempnmb.add(sgoith);
	    thempnmb.add(sgoitfth);
	    JLabel tgttth = new JLabel("Thời gian thanh toán:");
	    JTextField tgtttfth = new JTextField(10);
	    thempnmb.add(tgttth);
	    thempnmb.add(tgtttfth);
       JLabel dayth = new JLabel("    Ngày thanh toán:");
	    //JTextField daytfth = new JTextField(25);
	    thempnmb.add(dayth);
	  //  thempnmb.add(daytfth);
	    JDateChooser jDateChooser = new JDateChooser();
	    thempnmb.add(jDateChooser);
	    jDateChooser.setDateFormatString("dd-MM-yyyy");
	    jDateChooser.setPreferredSize(new Dimension(130,20));
	    JButton lmbtmb = new JButton("Làm mới");
	    thempnmb.add(lmbtmb);
	    JButton thembtmb = new JButton("Thêm");
	    thempnmb.add(thembtmb);
	    thempnmb.setVisible(false);
	       
	    
	    JButton xoamb = new JButton("Xóa");
	    JPanel xoapnmb = new JPanel(new FlowLayout());
	    xoapnmb.setPreferredSize(new Dimension(750,70));
	    xoapnmb.setBorder(vden);
	    JTextField xoatfmb = new JTextField(20);
	    xoatfmb.setText("Nhập IDmb cần xóa");
	    xoapnmb.add(xoatfmb);
	    JButton xoabtmb = new JButton("xóa");
	    xoapnmb.add(xoabtmb);
	    xoapnmb.setVisible(false);
	   // cnmb.add(xoapnmb,BorderLayout.CENTER);
	    
	    JButton suamb = new JButton("Sửa"); 
	    JPanel suapnmb = new JPanel(new FlowLayout());
	    suapnmb.setPreferredSize(new Dimension(750,70));
	    suapnmb.setBorder(vden);
	    JTextField suatfmb = new JTextField(20);
	    suatfmb.setText("Nhập IDmb cần sửa");
	    suapnmb.add(suatfmb);
	    JButton suabtmb = new JButton("OK");
	    suapnmb.add(suabtmb);
	    //cnmb.add(suapnmb,BorderLayout.CENTER);
	    JPanel suapnmb1 = new JPanel(new FlowLayout());
	    suapnmb1.setPreferredSize(new Dimension(750,70));
	    suapnmb1.setBorder(vden);
	    JLabel sgoisua = new JLabel("       Số giây gọi:");
	    suapnmb1.add(sgoisua);
	    suapnmb1.add(sgoitfsua);
		JLabel tgttsua = new JLabel("Thời gian thanh toán:");
	    tgtttfsua.setText("##:##:##");
	    suapnmb1.add(tgttsua);	   
	    suapnmb1.add(tgtttfsua);
	    JButton suamb2 = new JButton("Sửa");
        JLabel daysua = new JLabel("Ngày thanh toán:");
        suapnmb1.add(daysua);
	    suapnmb1.add(jDateChooser1);
	    jDateChooser1.setPreferredSize(new Dimension(115,20));
 	    jDateChooser1.setDateFormatString("dd-MM-yyyy");
	    suapnmb1.add(suamb2);
	    JButton qlmbsua = new JButton("<");
	    suapnmb1.add(qlmbsua);
	    suapnmb1.setVisible(false);
	    suapnmb.setVisible(false);
 
	    JTextField tktf1mb = new JTextField(20);
	    tktf1mb.setText("Nhập id cần tìm");
	    tktf1mb.setFont(arial11);
	    JButton cntkmb = new JButton("tim kiem"); 
	    JButton qlmb = new JButton("<");
	    cntkmb.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("tiemkiem.png"))));
	    cntkmb.setBackground(new Color(255,228,225));
	    cnpnmb.add(chucnangmb);
	    cnpnmb.add(themmb);
	    cnpnmb.add(xoamb);
	    cnpnmb.add(suamb);
	    cnpnmb.add(tktf1mb);
	    cnpnmb.add(cntkmb);
	    cnpnmb.add(qlmb);
	    cnpnmb.setBackground(Color.pink);
	    cnpnmb.setBorder(vden);
		qlmb.setVisible(false);
	    cnmb.add(cnpnmb,BorderLayout.NORTH);
	    mobile.add(cnmb,BorderLayout.NORTH);

	    xoamb.setBackground(new Color(255,228,225));
	    suamb.setBackground(new Color(255,228,225));
	    themmb.setBackground(new Color(255,228,225));
	    xoamb.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("xoa.png"))));    
	    suamb.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("sua.png"))));
	    themmb.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("save.png"))));
      //tbmb
	    JPanel tablepnmb = new JPanel(new BorderLayout());
	    tablepnmb.setPreferredSize(new Dimension(760,300));
	    
	    JLabel tentbmb = new JLabel("Danh sách thuê bao mobile", JLabel.CENTER);
	    tentbmb.setFont(arial);
	    tentbmb.setBackground(Color.pink);
	    tentbmb.setOpaque(true);
	    tablepnmb.add(tentbmb,BorderLayout.NORTH);
	    DefaultTableModel modelmb = new DefaultTableModel();
	    modelmb.addColumn("ID");
	    modelmb.addColumn("IDmb");
	    modelmb.addColumn("Họ và Tên");
	    modelmb.addColumn("SDT");
	    modelmb.addColumn("Loại TB");
	    modelmb.addColumn("Tình trạng TB");
	    modelmb.addColumn("Số giây gọi");
	    modelmb.addColumn("Thời gian tt");
	    modelmb.addColumn("Ngày thanh toán");
	    modelmb.addColumn("Tổng thanh toán(VND)");
	  
	    tbtb1 = new JTable(modelmb);    
	    JScrollPane scmb = new JScrollPane();
	    
	  
	    //scmb.setPreferredSize(new Dimension(500,200));
	    //tbtb1.setMinimumSize(new Dimension(500,300));
	   // tbtb1.setAutoscrolls(true);
	    scmb.setViewportView(tbtb1);
	    

	    tablepnmb.add(scmb,BorderLayout.CENTER);
	    showdatatc(connJDBC.findAlltc());
	    mobile.add(tablepnmb,BorderLayout.CENTER);
	    tablepnmb.setBackground(Color.pink);
	    tablepnmb.setBorder(vden);
	    tbtb1.setBackground(new Color(255,228,225));
	    TableColumn idColumn = tbtb1.getColumnModel().getColumn(modelmb.findColumn("ID"));
	    idColumn.setPreferredWidth(10);

	    TableColumn idmbColumn = tbtb1.getColumnModel().getColumn(modelmb.findColumn("IDmb"));
	    idmbColumn.setPreferredWidth(30);
	//VIETTEL
	  //chuc nang
	    JPanel cnvt = new JPanel(new BorderLayout());    
	    JPanel cnpnvt = new JPanel(new FlowLayout());
	    JLabel chucnangvt = new JLabel("Chức năng:");
	    chucnangvt.setFont(arial15);
	    
	    JButton themvt = new JButton("Thêm");
	    JPanel thempnvt = new JPanel(new FlowLayout());
	    thempnvt.setPreferredSize(new Dimension(750,70));
	    thempnvt.setBorder(vden);
	    JLabel idthvt = new JLabel("ID:");
	    JTextField idtfthvt = new JTextField(5);
	    thempnvt.add(idthvt);
	    thempnvt.add(idtfthvt);
	    JLabel sgoithvt = new JLabel("       Số giây gọi:");
	    JTextField sgoitfthvt = new JTextField(5);
	    thempnvt.add(sgoithvt);
	    thempnvt.add(sgoitfthvt);
	    JLabel tgttthvt = new JLabel("Thời gian thanh toán:");
	    JTextField tgtttfthvt = new JTextField(10);
	    thempnvt.add(tgttthvt);
	    thempnvt.add(tgtttfthvt);
       JLabel daythvt = new JLabel("    Ngày thanh toán:");
	    //JTextField daytfthvt = new JTextField(25);
	    thempnvt.add(daythvt);
	  //  thempnmb.add(daytfthvt);
	    JDateChooser jDateChooservt = new JDateChooser();
	    thempnvt.add(jDateChooservt);
	    jDateChooservt.setDateFormatString("dd-MM-yyyy");
	    jDateChooservt.setPreferredSize(new Dimension(130,20));
	    JButton lmbtvt = new JButton("Làm mới");
	    thempnvt.add(lmbtvt);
	    JButton thembtvt = new JButton("Thêm");
	    thempnvt.add(thembtvt);
	    thempnvt.setVisible(false);
	    
	    JButton xoavt = new JButton("Xóa");
	    JPanel xoapnvt = new JPanel(new FlowLayout());
	    xoapnvt.setPreferredSize(new Dimension(750,70));
	    xoapnvt.setBorder(vden);
	    JTextField xoatfvt = new JTextField(20);
	    xoatfvt.setText("Nhập IDmb cần xóa");
	    xoapnvt.add(xoatfvt);
	    JButton xoabtvt = new JButton("xóa");
	    xoapnvt.add(xoabtvt);
	    xoapnvt.setVisible(false);
	   // cnvt.add(xoapnvt,BorderLayout.CENTER);
	    
	    JButton suavt = new JButton("Sửa"); 
	    JPanel suapnvt = new JPanel(new FlowLayout());
	    suapnvt.setPreferredSize(new Dimension(750,70));
	    suapnvt.setBorder(vden);
	    JTextField suatfvt = new JTextField(20);
	    suatfvt.setText("Nhập IDmb cần sửa");
	    suapnvt.add(suatfvt);
	    JButton suabtvt = new JButton("OK");
	    suapnvt.add(suabtvt);
	    //cnvt.add(suapnvt,BorderLayout.CENTER);
	    JPanel suapnvt1 = new JPanel(new FlowLayout());
	    suapnvt1.setPreferredSize(new Dimension(750,70));
	    suapnvt1.setBorder(vden);
	    JLabel sgoisuavt = new JLabel("       Số giây gọi:");
	    suapnvt1.add(sgoisuavt);
	    suapnvt1.add(sgoitfsuavt);
		JLabel tgttsuavt = new JLabel("Thời gian thanh toán:");
	    tgtttfsuavt.setText("##:##:##");
	    suapnvt1.add(tgttsuavt);	   
	    suapnvt1.add(tgtttfsuavt);
	    JButton suavt2 = new JButton("Sửa");
        JLabel daysuavt = new JLabel("Ngày thanh toán:");
        suapnvt1.add(daysuavt);
	    suapnvt1.add(jDateChooser1vt);
	    jDateChooser1vt.setPreferredSize(new Dimension(115,20));
 	    jDateChooser1vt.setDateFormatString("dd-MM-yyyy");
	    suapnvt1.add(suavt2);
	    JButton qlvtsua = new JButton("<");
	    suapnvt1.add(qlvtsua);
	    suapnvt1.setVisible(false);
	    suapnvt.setVisible(false);
 
	    JTextField tktf1vt = new JTextField(20);
	    tktf1vt.setText("Nhập id cần tìm");
	    tktf1vt.setFont(arial11);
	    JButton cntkvt = new JButton("tim kiem"); 
	    JButton qlvt = new JButton("<");
	    cntkvt.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("tiemkiem.png"))));
	    cntkvt.setBackground(new Color(255,228,225));
	    cnpnvt.add(chucnangvt);
	    cnpnvt.add(themvt);
	    cnpnvt.add(xoavt);
	    cnpnvt.add(suavt);
	    cnpnvt.add(tktf1vt);
	    cnpnvt.add(cntkvt);
	    cnpnvt.add(qlvt);
		qlvt.setVisible(false);
	    cnvt.add(cnpnvt,BorderLayout.NORTH);
	    viettel.add(cnvt,BorderLayout.NORTH);
	 
	    xoavt.setBackground(new Color(255,228,225));
	    suavt.setBackground(new Color(255,228,225));
	    themvt.setBackground(new Color(255,228,225));
	    xoavt.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("xoa.png"))));    
	    suavt.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("sua.png"))));
	    themvt.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("save.png"))));
	  //tbvt
	    JPanel tablepnvt = new JPanel(new BorderLayout());
	    tablepnvt.setPreferredSize(new Dimension(760,300));
	    JLabel tentbvt = new JLabel("Danh sách thuê bao Viettel", JLabel.CENTER);
	    tentbvt.setFont(arial);
	    tentbvt.setBackground(Color.pink);
	    tentbvt.setOpaque(true);
	    tablepnvt.add(tentbvt,BorderLayout.NORTH);
	    DefaultTableModel modelvt = new DefaultTableModel();
	    modelvt.addColumn("ID");
	    modelvt.addColumn("IDvt");
	    modelvt.addColumn("Họ và Tên");
	    modelvt.addColumn("SDT");
	    modelvt.addColumn("Loại TB");
	    modelvt.addColumn("Tình trạng TB");
	    modelvt.addColumn("Số giây gọi");
	    modelvt.addColumn("Thời gian tt");
	    modelvt.addColumn("Ngày thanh toán");
	    modelvt.addColumn("Tổng thanh toán(VND)");
	    tbtbvt = new JTable(modelvt);    
	    JScrollPane scvt = new JScrollPane();
	    scvt.setPreferredSize(new Dimension(500,200));
	    tbtbvt.setMinimumSize(new Dimension(500,300));
	    tbtbvt.setAutoscrolls(true);
	    scvt.setViewportView(tbtbvt);
	    tablepnvt.add(scvt,BorderLayout.CENTER);
	    showdatavt(connJDBC.findAllvt());
	    viettel.add(tablepnvt,BorderLayout.CENTER);
	    tablepnvt.setBackground(Color.pink);
	    cnpnvt.setBackground(Color.pink);
	    cnpnvt.setBorder(vden);
	    tablepnvt.setBorder(vden);
	    tbtbvt.setBackground(new Color(255,228,225));
	    TableColumn idColumnvt = tbtbvt.getColumnModel().getColumn(modelvt.findColumn("ID"));
	    idColumnvt.setPreferredWidth(10);
	    TableColumn idmbColumnvt = tbtbvt.getColumnModel().getColumn(modelvt.findColumn("IDvt"));
	    idColumnvt.setPreferredWidth(30);
	  //VINAPHONE
		  //chuc nang
		    JPanel cnvn = new JPanel(new BorderLayout());    
		    JPanel cnpnvn = new JPanel(new FlowLayout());
		    JLabel chucnangvn = new JLabel("Chức năng:");
		    chucnangvn.setFont(arial15);
		    
		    JButton themvn = new JButton("Thêm");
		    JPanel thempnvn = new JPanel(new FlowLayout());
		    thempnvn.setPreferredSize(new Dimension(750,70));
		    thempnvn.setBorder(vden);
		    JLabel idthvn = new JLabel("ID:");
		    JTextField idtfthvn = new JTextField(5);
		    thempnvn.add(idthvn);
		    thempnvn.add(idtfthvn);
		    JLabel sgoithvn = new JLabel("       Số giây gọi:");
		    JTextField sgoitfthvn = new JTextField(5);
		    thempnvn.add(sgoithvn);
		    thempnvn.add(sgoitfthvn);
		    JLabel tgttthvn = new JLabel("Thời gian thanh toán:");
		    JTextField tgtttfthvn = new JTextField(10);
		    thempnvn.add(tgttthvn);
		    thempnvn.add(tgtttfthvn);
	       JLabel daythvn = new JLabel("    Ngày thanh toán:");
		    //JTextField daytfthvn = new JTextField(25);
		    thempnvn.add(daythvn);
		  //  thempnmb.add(daytfthvt);
		    JDateChooser jDateChooservn = new JDateChooser();
		    thempnvn.add(jDateChooservn);
		    jDateChooservn.setDateFormatString("dd-MM-yyyy");
		    jDateChooservn.setPreferredSize(new Dimension(130,20));
		    JButton lmbtvn = new JButton("Làm mới");
		    thempnvn.add(lmbtvn);
		    JButton thembtvn = new JButton("Thêm");
		    thempnvn.add(thembtvn);
		    thempnvn.setVisible(false);
		    
		    JButton xoavn = new JButton("Xóa");
		    JPanel xoapnvn = new JPanel(new FlowLayout());
		    xoapnvn.setPreferredSize(new Dimension(750,70));
		    xoapnvn.setBorder(vden);
		    JTextField xoatfvn = new JTextField(20);
		    xoatfvn.setText("Nhập IDvn cần xóa");
		    xoapnvn.add(xoatfvn);
		    JButton xoabtvn = new JButton("xóa");
		    xoapnvn.add(xoabtvn);
		    xoapnvn.setVisible(false);
		   // cnvn.add(xoapnvn,BorderLayout.CENTER);
		    
		    JButton suavn = new JButton("Sửa"); 
		    JPanel suapnvn = new JPanel(new FlowLayout());
		    suapnvn.setPreferredSize(new Dimension(750,70));
		    suapnvn.setBorder(vden);
		    JTextField suatfvn = new JTextField(20);
		    suatfvn.setText("Nhập IDvn cần sửa");
		    suapnvn.add(suatfvn);
		    JButton suabtvn = new JButton("OK");
		    suapnvn.add(suabtvn);
		    //cnvn.add(suapnvn,BorderLayout.CENTER);
		    JPanel suapnvn1 = new JPanel(new FlowLayout());
		    suapnvn1.setPreferredSize(new Dimension(750,70));
		    suapnvn1.setBorder(vden);
		    JLabel sgoisuavn = new JLabel("       Số giây gọi:");
		    suapnvn1.add(sgoisuavn);
		    suapnvn1.add(sgoitfsuavn);
			JLabel tgttsuavn = new JLabel("Thời gian thanh toán:");
		    tgtttfsuavn.setText("##:##:##");
		    suapnvn1.add(tgttsuavn);	   
		    suapnvn1.add(tgtttfsuavn);
		    JButton suavn2 = new JButton("Sửa");
	        JLabel daysuavn = new JLabel("Ngày thanh toán:");
	        suapnvn1.add(daysuavn);
		    suapnvn1.add(jDateChooser1vn);
		    jDateChooser1vn.setPreferredSize(new Dimension(115,20));
	 	    jDateChooser1vn.setDateFormatString("dd-MM-yyyy");
		    suapnvn1.add(suavn2);
		    JButton qlvnsua = new JButton("<");
		    suapnvn1.add(qlvnsua);
		    suapnvn1.setVisible(false);
		    suapnvn.setVisible(false);
	 
		    JTextField tktf1vn = new JTextField(20);
		    tktf1vn.setText("Nhập id cần tìm");
		    tktf1vn.setFont(arial11);
		    JButton cntkvn = new JButton("tim kiem"); 
		    cntkvn.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("tiemkiem.png"))));
		    cntkvn.setBackground(new Color(255,228,225));
		    JButton qlvn = new JButton("<");
		    cnpnvn.add(chucnangvn);
		    cnpnvn.add(themvn);
		    cnpnvn.add(xoavn);
		    cnpnvn.add(suavn);
		    cnpnvn.add(tktf1vn);
		    cnpnvn.add(cntkvn);
		    cnpnvn.add(qlvn);
			qlvn.setVisible(false);
		    cnvn.add(cnpnvn,BorderLayout.NORTH);
		    vinaphone.add(cnvn,BorderLayout.NORTH);
		   
		    xoavn.setBackground(new Color(255,228,225));
		    suavn.setBackground(new Color(255,228,225));
		    themvn.setBackground(new Color(255,228,225));
		    xoavn.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("xoa.png"))));    
		    suavn.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("sua.png"))));
		    themvn.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("save.png"))));
		  //tbvn
		    JPanel tablepnvn = new JPanel(new BorderLayout());
		    tablepnvn.setPreferredSize(new Dimension(760,300));
		    JLabel tentbvn = new JLabel("Danh sách thuê bao Viettel", JLabel.CENTER);
		    tentbvn.setFont(arial);
		    tentbvn.setBackground(Color.pink);
		    tentbvn.setOpaque(true);
		    tablepnvn.add(tentbvn,BorderLayout.NORTH);
		    DefaultTableModel modelvn = new DefaultTableModel();
		    modelvn.addColumn("ID");
		    modelvn.addColumn("IDvn");
		    modelvn.addColumn("Họ và Tên");
		    modelvn.addColumn("SDT");
		    modelvn.addColumn("Loại TB");
		    modelvn.addColumn("Tình trạng TB");
		    modelvn.addColumn("Số giây gọi");
		    modelvn.addColumn("Thời gian tt");
		    modelvn.addColumn("Ngày thanh toán");
		    modelvn.addColumn("Tổng thanh toán(VND)");
		    tbtbvn = new JTable(modelvn);    
		    JScrollPane scvn = new JScrollPane();
		    scvn.setPreferredSize(new Dimension(500,200));
		    tbtbvn.setMinimumSize(new Dimension(500,300));
		    tbtbvn.setAutoscrolls(true);
		    scvn.setViewportView(tbtbvn);
		    tablepnvn.add(scvn,BorderLayout.CENTER);
		    showdatavn(connJDBC.findAllvn());
		    vinaphone.add(tablepnvn,BorderLayout.CENTER);
		    viettel.add(tablepnvt,BorderLayout.CENTER);
		    tablepnvn.setBackground(Color.pink);
		    tablepnvn.setBorder(vden);
		    tbtbvn.setBackground(new Color(255,228,225));
		    TableColumn idColumnvn = tbtbvn.getColumnModel().getColumn(modelvn.findColumn("ID"));
		    idColumnvn.setPreferredWidth(10);
		    TableColumn idmbColumnvn = tbtbvn.getColumnModel().getColumn(modelvn.findColumn("IDvn"));
		    idColumnvn.setPreferredWidth(20);
		    cnpnvn.setBackground(Color.pink);
		    cnpnvn.setBorder(vden);
  //thongke
		    JPanel thongkepn = new JPanel(new BorderLayout());
		    br.add(thongkepn, BorderLayout.CENTER);
		    thongkepn.setPreferredSize( new Dimension(700, 700));
		    thongkepn.setVisible(false);
		    JPanel cocau = new JPanel();
		    cocau.setPreferredSize(new Dimension(400,400));
		    JFreeChart pieChart = createChart(createDataset());
	        ChartPanel chartPanel = new ChartPanel(pieChart);
	        chartPanel.setPreferredSize(new Dimension(600,600));
	        chartPanel.setBorder(vden);
	        cocau.add(chartPanel);
	        thongkepn.add(cocau);
	        cocau.setBackground(Color.pink);
	        cocau.setPreferredSize(new Dimension(620,620));
	        cocau.setBorder(vden);
	      
		    
		    
  //home
  		JPanel home = new JPanel(new BorderLayout());
  		 br.add(home, BorderLayout.CENTER);
  		 home.setBackground(Color.WHITE);
         home.setPreferredSize( new Dimension(700, 700));
  		JPanel tk = new JPanel(new FlowLayout());
  	    home.add(tk,BorderLayout.NORTH);
  		 tk.setBackground(Color.white);
  		 tk.setPreferredSize(new Dimension(1000,70));
  		JLabel r = new JLabel("QUẢN LÝ THUÊ BAO",JLabel.CENTER);	
  		tk.setBackground(Color.pink);
  		 r.setFont(arial);
  		 r.setPreferredSize(new Dimension(300,50));
  	     tk.add(r);
  	     JPanel jPanel = new JPanel(new GridLayout(1,2));
  	   home.add(jPanel,BorderLayout.CENTER);
  	     jPanel.setPreferredSize(new Dimension(800,800));
  	     jPanel.setBorder(vden);
  	     
  	    JPanel chupn = new JPanel(new FlowLayout());
	     jPanel.add(chupn);
	     chupn.setBackground(Color.white);
  	     JPanel anhpn = new JPanel(new FlowLayout());
  	     jPanel.add(anhpn);
 
   	    
  	     JLabel thuebao = new JLabel();
  	    JLabel sim = new JLabel();
  	     
  	    anhpn.add(thuebao);
  	    thuebao.setPreferredSize(new Dimension(300,200));

  	    thuebao.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("thuebao.jpg"))));
  	    sim.setPreferredSize(new Dimension(300,250));
  
  	    sim.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("sim.jpg"))));
  	    anhpn.add(sim);
  	  
  	  JLabel cuocmobi = new JLabel("- Giá cước mobile 1.580VND/phút");
  	  cuocmobi.setFont(arial15);
      JLabel cuocvt = new JLabel("- Giá cước viettel 2000VND/phút");
      cuocvt.setFont(arial15);
      JLabel cuocvn = new JLabel("- Giá cước vinaphone 1.380VND/phút");
      cuocvn.setFont(arial15);
      cuocmobi.setPreferredSize(new Dimension(350,20));
      cuocvt.setPreferredSize(new Dimension(350,20));
      cuocvn.setPreferredSize(new Dimension(350,20));
      JLabel tmobi = new JLabel("- Tổng TT của Mobile tới bây giờ là:"+ connJDBC.tongttmb()+"VND");
  	  tmobi.setFont(arial15);
      JLabel tvt = new JLabel("- Tổng TT của Viettel tới bây giờ là: "+ connJDBC.tongttvt()+"VND");
      tvt.setFont(arial15);
      JLabel tvn = new JLabel("- Tổng TT của VinaP tới bây giờ là:"+ connJDBC.tongttvn()+"VND");
      tvn.setFont(arial15);
      tmobi.setPreferredSize(new Dimension(350,20));
      tvt.setPreferredSize(new Dimension(350,20));
      tvn.setPreferredSize(new Dimension(350,20));
      chupn.add(cuocmobi);
      chupn.add(cuocvt);
      chupn.add(cuocvn);
      chupn.add(tmobi);
      chupn.add(tvt);
      chupn.add(tvn);
  	    anhpn.setBackground(Color.white);
  	    home.setBackground(Color.pink);
  	    home.setVisible(true);
 	    
 // thanh nouth   
	    JPanel thmn1 = new JPanel(new BorderLayout());
	    br.add(thmn1, BorderLayout.NORTH);
	    thmn1.setBackground(Color.pink);
	    thmn1.setPreferredSize(new Dimension(1000,30));
	    thmn1.setBorder(vden);
	    Border v = thmn1.getBorder();
	    thmn1.setBorder(v);
	   
	    JLabel hello = new JLabel(view_login.x(a));
	    hello.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("chan_16.png"))));
	    hello.setFont(arial11id);
	    thmn1.add(hello, BorderLayout.WEST);
	    
  //menu
	    JPanel menu = new JPanel(new FlowLayout());
	    br.add(menu, BorderLayout.WEST);
	    menu.setPreferredSize(new Dimension(220,700));
	    menu.setBackground(Color.pink);
	    menu.setBorder(vden);
	   
	    JLabel logomn = new JLabel();
	    logomn.setPreferredSize(new Dimension(210,190));

	    logomn.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("logo1.png"))));
	    menu.add(logomn);	    
	    JLabel tc = new JLabel("Trang chủ", JLabel.CENTER);
	    tc.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("trangchu.png"))));
	    tc.setFont(arial15);
	    tc.setBackground(Color.white);
		tc.setOpaque(true);
	    tc.setBorder(v);
	    tc.setBorder(vden);
	    menu.add(tc);
	    tc.setPreferredSize(new Dimension(220,45));
	    JLabel rong1 = new JLabel();
	    rong1.setPreferredSize(new Dimension(220,30));
	    menu.add(rong1);
	    JLabel tb = new JLabel("Thuê bao",JLabel.CENTER);
	    tb.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("thuebaocat.png"))));
	    tb.setFont(arial15);
	    menu.add(tb);
	    tb.setPreferredSize(new Dimension(220,45));
	    tb.setBorder(v);
	    tb.setBorder(vden);
	    JLabel rong2 = new JLabel();
	    rong2.setPreferredSize(new Dimension(220,30));
	    menu.add(rong2);
	    JLabel tcuoc = new JLabel("Thu cước TB",JLabel.CENTER);
	    tcuoc.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("tc.png"))));
	    tcuoc.setFont(arial15);
	    menu.add(tcuoc);
	    tcuoc.setPreferredSize(new Dimension(220,45));
	    tcuoc.setBorder(v);
	    tcuoc.setBorder(vden);
	    JLabel rong3 = new JLabel();
	    rong3.setPreferredSize(new Dimension(220,30));
	    menu.add(rong3);
	    JLabel thongke = new JLabel("Thống kê",JLabel.CENTER);
	    thongke.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(main.class.getResource("thongke.png"))));
	    thongke.setFont(arial15);
	    menu.add(thongke);
	    thongke.setPreferredSize(new Dimension(220,45));
	    thongke.setBorder(v);
	    thongke.setBorder(vden);
// event tro chuot tf
	    tentf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sdttf.requestFocus();
			}
		});
	    sdttf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loaitf.requestFocus();
			}
		});
        xoatf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xoabt.doClick();
			}
		});
        tktf1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cntk.doClick();
			}
		});
        suatf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ok.doClick();
			}
		});
        xoatfmb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xoabtmb.doClick();
			}
		});
        tktf1mb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cntkmb.doClick();
			}
		});
        suatfmb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				suabtmb.doClick();
			}
		});
        xoatfvt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xoabtvt.doClick();
			}
		});
        tktf1vt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cntkvt.doClick();
			}
		});
        suatfvt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				suabtvt.doClick();
			}
		});
        xoatfvn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xoabtvn.doClick();
			}
		});
        tktf1vn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cntkvn.doClick();
			}
		});
        suatfvn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				suabtvn.doClick();
			}
		});
  //hien pa neo
	    tb.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		br.remove(tcpn);
	    		br.remove(home);
	    		home.setVisible(false);
	    		tcpn.setVisible(false);	    		
	    		br.add(tbpn,BorderLayout.CENTER);
	    		tbpn.setVisible(true);
	    		
	    		tb.setBackground(Color.white);
	    		tb.setOpaque(true);
	    		
	    		tc.setBackground(null);
	    		tc.setOpaque(true);
	    		tcuoc.setBackground(null);
	    		tcuoc.setOpaque(true);
	        sdttf.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String sdt = sdttf.getText();
					if (sdt.startsWith("070") || sdt.startsWith("079") || sdt.startsWith("077") || sdt.startsWith("076") || sdt.startsWith("078")|| sdt.startsWith("059")) {
                        // Nếu là mobile
                        loaitf.setText("mobile");
                    } else if (sdt.startsWith("096") || sdt.startsWith("097") || sdt.startsWith("098")|| sdt.startsWith("086")|| sdt.startsWith("039")|| sdt.startsWith("038")|| sdt.startsWith("037")|| sdt.startsWith("036")|| sdt.startsWith("035")) {
                        // Nếu là viettel
                        loaitf.setText("viettel");
                    } else {
                        // Nếu là vinaphone
                        loaitf.setText("vinaphone");
                    }
					}
			});
	    	}
		});
   //hien home
	    tc.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		br.remove(tcpn);
	            br.remove(tbpn);
	            br.remove(thongkepn);
	            thongkepn.setVisible(false);
	            tbpn.setVisible(false);
	            tcpn.setVisible(false);
	            
	            br.add(home, BorderLayout.CENTER);
	    		home.setVisible(true);
	    		
	    		tc.setBackground(Color.white);
	    		tc.setOpaque(true);
	    		
	    		thongke.setBackground(null);
	    		thongke.setOpaque(true);
	    		tb.setBackground(null);
	            tb.setOpaque(true);
	            tcuoc.setBackground(null);
	    		tcuoc.setOpaque(true);
	    	}
		});
  //hien thu cuoc
	    tcuoc.addMouseListener(new MouseAdapter() {
	    	@Override 
	    	public void mouseClicked(MouseEvent e) {
	    		
	    		thongkepn.setVisible(false);
	    		home.setVisible(false);
	    		tbpn.setVisible(false);
	    		br.remove(home);
	    		br.remove(tbpn);  
	    		br.remove(thongkepn);
	    		
	    		br.add(tcpn,BorderLayout.CENTER);
	    		tcpn.setVisible(true);
	    		
	    		tcuoc.setBackground(Color.white);
	    		tcuoc.setOpaque(true);
	    		
	    		thongke.setBackground(null);
	    		thongke.setOpaque(true);
	    		tb.setBackground(null);
	            tb.setOpaque(true);	
	            tc.setBackground(null);
	    		tc.setOpaque(true);
	    	}
		});
	//hien thong ke
	    thongke.addMouseListener(new MouseAdapter() {
	    	@Override 
	    	public void mouseClicked(MouseEvent e) {
	    		  		
	    		home.setVisible(false);
	    		tbpn.setVisible(false);
	    		tcpn.setVisible(false);
	    		br.remove(tcpn);
	    		br.remove(home);
	    		br.remove(tbpn);  
	    		
	    		br.add(thongkepn,BorderLayout.CENTER);
	    		thongkepn.setVisible(true);
	    		thongke.setBackground(Color.white);
	    		thongke.setOpaque(true);
	    		
	    		tcuoc.setBackground(null);
	    		tcuoc.setOpaque(true);	    		
	    		tb.setBackground(null);
	            tb.setOpaque(true);	
	            tc.setBackground(null);
	    		tc.setOpaque(true);
	    	}
		});
	    
	
   //nut them
	    them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!thcnth.isVisible()) {
				xoapn.setVisible(false);
				cn.remove(xoapn);
				suapn.setVisible(false);
				cn.remove(suapn);
				suapn1.setVisible(false);
				cn.remove(suapn1);
				cn.add(thcnth,BorderLayout.CENTER);
				
		
				thembt.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						THUE_BAO tb = new THUE_BAO();
						tb.setTen(tentf.getText());
						tb.setSdt(sdttf.getText());
						tb.setLoaiTB(loaitf.getText());
						tb.setTinhtrangTB(tttf.getText());
						connJDBC.insert(tb);
						JOptionPane.showMessageDialog(null,"Thêm thành công!");
						showdata(connJDBC.findAll());
						
					}
				});
				lmbt.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						tentf.setText("");
						sdttf.setText("");
						loaitf.setText("");
						tttf.setText("");
						buttonGroup.clearSelection();
						
						
					}
				});
				
				thcnth.setVisible(true);
				} else {
					thcnth.setVisible(false);
					cn.remove(thcnth);
				}
			}
		});
		   
   //nutxoa
	    xoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!xoapn.isVisible()) {
				thcnth.setVisible(false);
				cn.remove(thcnth);
				suapn.setVisible(false);
				cn.remove(suapn);
				suapn1.setVisible(false);
				cn.remove(suapn1);
				cn.add(xoapn,BorderLayout.CENTER);
				xoapn.setVisible(true);
				
				xoabt.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						THUE_BAO tb = new THUE_BAO();
						tb.setSdt(xoatf.getText());
						connJDBC.delete(tb);
						showdata(connJDBC.findAll());
					}
				});
				}
				else {
					xoapn.setVisible(false);
					cn.remove(xoapn);
					
				}
				
			}
		} );
  //nut sua
	    sua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!suapn1.isVisible()) {
					thcnth.setVisible(false);
					cn.remove(thcnth);
					xoapn.setVisible(false);
					cn.remove(xoapn);
					suapn.setVisible(false);
					cn.remove(suapn);
					cn.add(suapn1,BorderLayout.CENTER);
					suapn1.setVisible(true);
					suabt.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							THUE_BAO tb = new THUE_BAO();
							tb.setId(Integer.parseInt(suatf.getText()));
							tb.setTen(tentf1.getText());
							tb.setSdt(sdttf1.getText());
							tb.setLoaiTB(loaitf1.getText());
							radioButton1ed.addItemListener(new ItemListener() {
					            @Override
					            public void itemStateChanged(ItemEvent e) {
					                // Xử lý sự kiện
					                if (radioButton1.isSelected()) {
					                    tttf1.setText("Hoạt động");
					                } else {
					                	tttf1.setText("Ngưng hoạt động");
					                }
					            }
					        });
							tb.setTinhtrangTB(tttf1.getText());
							connJDBC.Update(tb);
							JOptionPane.showMessageDialog(null,"Sửa thành công!");
							showdata(connJDBC.findAll());
						}
					});
					} else {
						suapn1.setVisible(false);
						cn.remove(suapn1);
						
					}
			}
		});
	    ok.addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				suapn1.setVisible(false);
				suapn.setVisible(true);
				cn.remove(suapn1);
				cn.add(suapn,BorderLayout.CENTER);
				THUE_BAO tb = new THUE_BAO();
				tb.setId(Integer.parseInt(suatf.getText()));
				ltt(connJDBC.lttsql(tb));				
			}
		});
	    ql1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub						
				suapn.setVisible(false);
				cn.remove(suapn);
				cn.add(suapn1,BorderLayout.CENTER);
				suapn1.setVisible(true);
			    buttonGrouped.clearSelection();
				
			}
		});
  //nut timkiem
	    cntk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				THUE_BAO tb = new THUE_BAO();
				tb.setSdt(tktf1.getText());
				showdata(connJDBC.findByName(tb));
				ql.setVisible(true);
				ql.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						tktf1.setText("Nhập sdt cần tìm");
						ql.setVisible(false);
						showdata(connJDBC.findAll());
					}
				});
			}
		});
	  //them mobile
	    themmb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!thempnmb.isVisible()) {
				xoapnmb.setVisible(false);
				cnmb.remove(thempnmb);
				suapnmb.setVisible(false);
				cnmb.remove(suapnmb);
				cnmb.add(thempnmb,BorderLayout.CENTER);
				thempnmb.setVisible(true);
				thembtmb.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							THU_CUOC tc = new THU_CUOC();
							tc.setId(Integer.parseInt(idtfth.getText()));
							
							THUE_BAO tb1 = new THUE_BAO();
							tb1.setId(Integer.parseInt(idtfth.getText()));
							
							THUE_BAO tb = new THUE_BAO();
							tb=connJDBC.findByID(tb1);				
							tc.setTen(tb.getTen());
							tc.setSdt(tb.getSdt());
							tc.setLoaiTB(tb.getLoaiTB());
							tc.setTinhtrangTB(tb.getTinhtrangTB());
							tc.setSogiaygoi(Double.parseDouble(sgoitfth.getText()));
							tc.setThoigianttoan(Time.valueOf(tgtttfth.getText()));
							tc.setNgayttoan(new java.sql.Date(jDateChooser.getDate().getTime()));
							connJDBC.inserttc(tc);
							showdatatc(connJDBC.findAlltc());
						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null,"Vui lòng nhập đúng kiểu dữ liệu!");
						}
						

					}
				});
				}
				else {
					thempnmb.setVisible(false);
					cnmb.remove(thempnmb);
					
				}
			}
		});
	    lmbtmb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				idtfth.setText("");
				sgoitfth.setText("");
				tgtttfth.setText("");
				jDateChooser.setDate(null);
			}
		});
	    
	  //xoa mobile
	    xoamb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!xoapnmb.isVisible()) {
				thempnmb.setVisible(false);
				cnmb.remove(thempnmb);
				suapnmb.setVisible(false);
				cnmb.remove(suapnmb);
				cnmb.add(xoapnmb,BorderLayout.CENTER);
				xoapnmb.setVisible(true);
				xoabtmb.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						THU_CUOC tc = new THU_CUOC();
						tc.setIdmb(Integer.parseInt(xoatfmb.getText()));
						connJDBC.deletetc(tc);
						showdatatc(connJDBC.findAlltc());
					}
				});
				
				
				}
				else {
					xoapnmb.setVisible(false);
					cnmb.remove(xoapnmb);
					xoatfmb.setText("Nhập IDmb cần sửa");
					
				}
			}
		});
	  //sua mobile
	    suamb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!suapnmb.isVisible()) {
				thempnmb.setVisible(false);
				cnmb.remove(thempnmb);
				xoapnmb.setVisible(false);
				cnmb.remove(xoapnmb);
				cnmb.add(suapnmb,BorderLayout.CENTER);
				suapnmb.setVisible(true);
				suabtmb.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						suapnmb.setVisible(false);
						cnmb.remove(suapnmb);
						cnmb.add(suapnmb1,BorderLayout.CENTER);
						suapnmb1.setVisible(true);
						THU_CUOC tc = new THU_CUOC();
						tc.setIdmb(Integer.parseInt(suatfmb.getText()));
						ltttc(connJDBC.lttsqltc(tc));
						suamb2.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								try {
									THU_CUOC tc = new THU_CUOC();
									tc.setIdmb(Integer.parseInt(suatfmb.getText()));
									tc.setSogiaygoi(Double.parseDouble(sgoitfsua.getText()));
									tc.setThoigianttoan(Time.valueOf(tgtttfsua.getText()));
								    tc.setNgayttoan(new java.sql.Date(jDateChooser1.getDate().getTime()));
									connJDBC.Updatetc(tc);
									showdatatc(connJDBC.findAlltc());
								} catch (Exception e2) {
									// TODO: handle exception
									JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng kiểu dữ liệu!");
								}
								
							}
						} );
						
					}
				});
				}
				else {
					suapnmb.setVisible(false);
					cnmb.remove(suapnmb);
			
					
				}
			}
		});
	    qlmbsua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				suapnmb1.setVisible(false);
				cnmb.remove(suapnmb1);
				
				cnmb.add(suapnmb);
				suapnmb.setVisible(true);
				suatfmb.setText("Nhập IDmb cần sửa");
			}
		});

	  //nut timkiem mb
	    cntkmb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				THU_CUOC tc = new THU_CUOC();
				tc.setId(Integer.parseInt(tktf1mb.getText()));
				showdatatc(connJDBC.findByNametc(tc));
				
				qlmb.setVisible(true);
				qlmb.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						tktf1mb.setText("Nhập id cần tìm");
						qlmb.setVisible(false);
						showdatatc(connJDBC.findAlltc());
					}
				});
			}
		});
	    //them viettel
	    themvt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!thempnvt.isVisible()) {
				xoapnvt.setVisible(false);
				cnvt.remove(thempnvt);
				suapnvt.setVisible(false);
				cnvt.remove(suapnvt);
				cnvt.add(thempnvt,BorderLayout.CENTER);
				thempnvt.setVisible(true);
				thembtvt.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							THU_CUOCvt tc = new THU_CUOCvt();
						tc.setId(Integer.parseInt(idtfthvt.getText()));
						
						THUE_BAO tb1 = new THUE_BAO();
						tb1.setId(Integer.parseInt(idtfthvt.getText()));
						
						THUE_BAO tb = new THUE_BAO();
						tb=connJDBC.findByID(tb1);				
						tc.setTen(tb.getTen());
						tc.setSdt(tb.getSdt());
						tc.setLoaiTB(tb.getLoaiTB());
						tc.setTinhtrangTB(tb.getTinhtrangTB());
						tc.setSogiaygoi(Double.parseDouble(sgoitfthvt.getText()));
						tc.setThoigianttoan(Time.valueOf(tgtttfthvt.getText()));
						tc.setNgayttoan(new java.sql.Date(jDateChooservt.getDate().getTime()));
						connJDBC.insertvt(tc);
						showdatavt(connJDBC.findAllvt());
						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng kiểu dữ liệu!");
						}
						

					}
				});
				}
				else {
					thempnvt.setVisible(false);
					cnvt.remove(thempnvt);
					
				}
			}
		});
	  //xoa viettel
	    xoavt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!xoapnvt.isVisible()) {
				thempnvt.setVisible(false);
				cnvt.remove(thempnvt);
				suapnvt.setVisible(false);
				cnvt.remove(suapnvt);
				cnvt.add(xoapnvt,BorderLayout.CENTER);
				xoapnvt.setVisible(true);
				xoabtvt.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						THU_CUOCvt tc = new THU_CUOCvt();
						tc.setIdvt(Integer.parseInt(xoatfvt.getText()));
						connJDBC.deletevt(tc);
						showdatavt(connJDBC.findAllvt());
					}
				});
				
				
				}
				else {
					xoapnvt.setVisible(false);
					cnvt.remove(xoapnvt);
					xoatfvt.setText("Nhập IDvt cần sửa");
				}
			}
		});
	  //sua viettel
	    suavt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!suapnvt.isVisible()) {
				thempnvt.setVisible(false);
				cnvt.remove(thempnvt);
				xoapnvt.setVisible(false);
				cnvt.remove(xoapnvt);
				cnvt.add(suapnvt,BorderLayout.CENTER);
				suapnvt.setVisible(true);
				suabtvt.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						suapnvt.setVisible(false);
						cnvt.remove(suapnvt);
						cnvt.add(suapnvt1,BorderLayout.CENTER);
						suapnvt1.setVisible(true);
						THU_CUOCvt tc = new THU_CUOCvt();
						tc.setIdvt(Integer.parseInt(suatfvt.getText()));
						lttvt(connJDBC.lttsqlvt(tc));
						suavt2.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								try {
									THU_CUOCvt tc = new THU_CUOCvt();
								tc.setIdvt(Integer.parseInt(suatfvt.getText()));
								tc.setSogiaygoi(Double.parseDouble(sgoitfsuavt.getText()));
								tc.setThoigianttoan(Time.valueOf(tgtttfsuavt.getText()));
							    tc.setNgayttoan(new java.sql.Date(jDateChooser1vt.getDate().getTime()));
								connJDBC.Updatevt(tc);
								showdatavt(connJDBC.findAllvt());
								} catch (Exception e2) {
									// TODO: handle exception
									JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng kiểu dữ liệu!");
								}
								
							}
						} );
						qlvtsua.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								suapnvt1.setVisible(false);
								cnvt.remove(suapnvt1);
								suapnvt.setVisible(true);
								cnvt.add(suapnvt);
								suatfvt.setText("Nhập IDvt cần sửa");
							}
						});
					}
				});
				}
				else {
					suapnvt.setVisible(false);
					cnvt.remove(suapnvt);
					
				}
			}
		});

	  //nut timkiem vt
	    cntkvt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				THU_CUOCvt tc = new THU_CUOCvt();
				tc.setId(Integer.parseInt(tktf1vt.getText()));
				showdatavt(connJDBC.findByNamevt(tc));
				
				qlvt.setVisible(true);
				qlvt.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						tktf1vt.setText("Nhập id cần tìm");
						qlvt.setVisible(false);
						showdatavt(connJDBC.findAllvt());
					}
				});
			}
		});
     lmbtvt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				idtfthvt.setText("");
				sgoitfthvt.setText("");
				tgtttfthvt.setText("");
				jDateChooservt.setDate(null);
			}
		});
	    //them vina
	    themvn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!thempnvn.isVisible()) {
				xoapnvn.setVisible(false);
				cnvn.remove(thempnvn);
				suapnvn.setVisible(false);
				cnvn.remove(suapnvn);
				cnvn.add(thempnvn,BorderLayout.CENTER);
				thempnvn.setVisible(true);
				thembtvn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							THU_CUOCvn tc = new THU_CUOCvn();
						tc.setId(Integer.parseInt(idtfthvn.getText()));
						
						THUE_BAO tb1 = new THUE_BAO();
						tb1.setId(Integer.parseInt(idtfthvn.getText()));
						
						THUE_BAO tb = new THUE_BAO();
						tb=connJDBC.findByID(tb1);				
						tc.setTen(tb.getTen());
						tc.setSdt(tb.getSdt());
						tc.setLoaiTB(tb.getLoaiTB());
						tc.setTinhtrangTB(tb.getTinhtrangTB());
						tc.setSogiaygoi(Double.parseDouble(sgoitfthvn.getText()));
						tc.setThoigianttoan(Time.valueOf(tgtttfthvn.getText()));
						tc.setNgayttoan(new java.sql.Date(jDateChooservn.getDate().getTime()));
						connJDBC.insertvn(tc);
						showdatavn(connJDBC.findAllvn());
						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng kiểu dữ liệu!");
						}
						

					}
				});
				}
				else {
					thempnvn.setVisible(false);
					cnvn.remove(thempnvn);
					
				}
			}
		});
	  //xoa vina
	    xoavn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!xoapnvn.isVisible()) {
				thempnvn.setVisible(false);
				cnvn.remove(thempnvn);
				suapnvn.setVisible(false);
				cnvn.remove(suapnvn);
				cnvn.add(xoapnvn,BorderLayout.CENTER);
				xoapnvn.setVisible(true);
				xoabtvn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						THU_CUOCvn tc = new THU_CUOCvn();
						tc.setIdvn(Integer.parseInt(xoatfvn.getText()));
						connJDBC.deletevn(tc);
						showdatavn(connJDBC.findAllvn());
					}
				});
				
				
				}
				else {
					xoapnvn.setVisible(false);
					cnvn.remove(xoapnvn);
					xoatfvn.setText("Nhập IDvn cần sửa");
				}
			}
		});
	  //sua vinaphone
	    suavn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!suapnvn.isVisible()) {
				thempnvn.setVisible(false);
				cnvn.remove(thempnvn);
				xoapnvn.setVisible(false);
				cnvn.remove(xoapnvn);
				cnvn.add(suapnvn,BorderLayout.CENTER);
				suapnvn.setVisible(true);
				suabtvn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						suapnvn.setVisible(false);
						cnvn.remove(suapnvn);
						cnvn.add(suapnvn1,BorderLayout.CENTER);
						suapnvn1.setVisible(true);
						THU_CUOCvn tc = new THU_CUOCvn();
						tc.setIdvn(Integer.parseInt(suatfvn.getText()));
						lttvn(connJDBC.lttsqlvn(tc));
						suavn2.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								try {
									THU_CUOCvn tc = new THU_CUOCvn();
								tc.setIdvn(Integer.parseInt(suatfvn.getText()));
								tc.setSogiaygoi(Double.parseDouble(sgoitfsuavn.getText()));
								tc.setThoigianttoan(Time.valueOf(tgtttfsuavn.getText()));
							    tc.setNgayttoan(new java.sql.Date(jDateChooser1vn.getDate().getTime()));
								connJDBC.Updatevn(tc);
								showdatavn(connJDBC.findAllvn());
								} catch (Exception e2) {
									// TODO: handle exception
									JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng kiểu dữ liệu!");
								}
								
							}
						} );
						qlvnsua.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								suapnvn1.setVisible(false);
								cnvn.remove(suapnvn1);
								suapnvn.setVisible(true);
								cnvn.add(suapnvn);
								suatfvn.setText("Nhập IDvn cần sửa");
							}
						});
					}
				});
				}
				else {
					suapnvn.setVisible(false);
					cnvn.remove(suapnvn);
					
				}
			}
		});

	  //nut timkiem vn
	    cntkvn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				THU_CUOCvn tc = new THU_CUOCvn();
				tc.setId(Integer.parseInt(tktf1vn.getText()));
				showdatavn(connJDBC.findByNamevn(tc));
				
				qlvn.setVisible(true);
				qlvn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						tktf1vn.setText("Nhập id cần tìm");
						qlvn.setVisible(false);
						showdatavn(connJDBC.findAllvn());
					}
				});
			}
		});
	    lmbtvn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				idtfthvn.setText("");
				sgoitfthvn.setText("");
				tgtttfthvn.setText("");
				jDateChooservn.setDate(null);
			}
		});
	    
	    add(br);
	    setLocationRelativeTo(null);
	    setVisible(true);
	}
  
    public void showdata(List<THUE_BAO>THUE_BAO1) {
    	List<THUE_BAO>Ltb = new ArrayList<>();
    	Ltb=THUE_BAO1;
    	DefaultTableModel tbmodel;
    	tbtb.getModel();
    	tbmodel = (DefaultTableModel)tbtb.getModel();
    	tbmodel.setRowCount(0);
    	Ltb.forEach((thue_bao) -> {
    		tbmodel.addRow( new Object [] {
    				thue_bao.getId(), thue_bao.getTen(), thue_bao.getSdt(), thue_bao.getLoaiTB(), thue_bao.getTinhtrangTB()
    		});
    	});
    	} 
    public void showdatatc(List<THU_CUOC>THU_CUOC1) {
    	List<THU_CUOC>Ltc = new ArrayList<>();
    	Ltc=THU_CUOC1;
    	DefaultTableModel tbmodel1;
    	tbtb1.getModel();
    	tbmodel1 = (DefaultTableModel)tbtb1.getModel();
    	tbmodel1.setRowCount(0);
    	Ltc.forEach((tc) -> {
    		tbmodel1.addRow( new Object [] {
    				tc.getId(), tc.getIdmb(), tc.getTen(), tc.getSdt(), tc.getLoaiTB(), tc.getTinhtrangTB(), tc.getSogiaygoi(), tc.getThoigianttoan(), tc.getNgayttoan(), tc.getTongtt()
    				
    		});
    		
    	});
    	} 
    public void showdatavt(List<THU_CUOCvt>THU_CUOC1) {
    	List<THU_CUOCvt>Ltc = new ArrayList<>();
    	Ltc=THU_CUOC1;
    	DefaultTableModel tbmodel1;
    	tbtbvt.getModel();
    	tbmodel1 = (DefaultTableModel)tbtbvt.getModel();
    	tbmodel1.setRowCount(0);
    	Ltc.forEach((tc) -> {
    		tbmodel1.addRow( new Object [] {
    				tc.getId(), tc.getIdvt(), tc.getTen(), tc.getSdt(), tc.getLoaiTB(), tc.getTinhtrangTB(), tc.getSogiaygoi(), tc.getThoigianttoan(), tc.getNgayttoan(), tc.getTongtt()
    				
    		});
    		
    	});
    	} 
    public void showdatavn(List<THU_CUOCvn>THU_CUOC1) {
    	List<THU_CUOCvn>Ltc = new ArrayList<>();
    	Ltc=THU_CUOC1;
    	DefaultTableModel tbmodel1;
    	tbtbvn.getModel();
    	tbmodel1 = (DefaultTableModel)tbtbvn.getModel();
    	tbmodel1.setRowCount(0);
    	Ltc.forEach((tc) -> {
    		tbmodel1.addRow( new Object [] {
    				tc.getId(), tc.getIdvn(), tc.getTen(), tc.getSdt(), tc.getLoaiTB(), tc.getTinhtrangTB(), tc.getSogiaygoi(), tc.getThoigianttoan(), tc.getNgayttoan(), tc.getTongtt()
    				
    		});
    		
    	});
    	} 
   public void ltt(THUE_BAO tb) {
	  THUE_BAO tb1 = new THUE_BAO();
	   tb1=tb;
	   tentf1.setText(tb1.getTen());
	   sdttf1.setText(tb1.getSdt());
	   loaitf1.setText(tb1.getLoaiTB());
	   tttf1.setText(tb1.getTinhtrangTB());
	   if (tttf1.getText().equals("Hoạt động")) {
		   radioButton1ed.setSelected(true);
	   } else {
		   radioButton2ed.setSelected(true);
	   }
   }
   public void ltttc(THU_CUOC tc) {
		  THU_CUOC tc1 = new THU_CUOC();
		   tc1=tc;
		   sgoitfsua.setText(String.valueOf(tc1.getSogiaygoi()));
		   tgtttfsua.setText(String.valueOf(tc1.getThoigianttoan()));	
		   jDateChooser1.setDate(tc1.getNgayttoan());
	   }
   public void lttvt(THU_CUOCvt tc) {
		  THU_CUOCvt tc1 = new THU_CUOCvt();
		   tc1=tc;
		   sgoitfsuavt.setText(String.valueOf(tc1.getSogiaygoi()));
		   tgtttfsuavt.setText(String.valueOf(tc1.getThoigianttoan()));	
		   jDateChooser1vt.setDate(tc1.getNgayttoan());

	   }
   public void lttvn(THU_CUOCvn tc) {
		  THU_CUOCvn tc1 = new THU_CUOCvn();
		   tc1=tc;
		   sgoitfsuavn.setText(String.valueOf(tc1.getSogiaygoi()));
		   tgtttfsuavn.setText(String.valueOf(tc1.getThoigianttoan()));	
		   jDateChooser1vn.setDate(tc1.getNgayttoan());

	   }
	    private static JFreeChart createChart(PieDataset dataset) {
	        JFreeChart chart = ChartFactory.createPieChart(
	                "CƠ CẤU TỔNG THANH TOÁN THEO LOẠI THUÊ BAO ", dataset,true,true,true);
	        return chart;
	    }
   private static PieDataset createDataset() {
	    double x,y,z;
	    x= connJDBC.tongttmb();
	    y=connJDBC.tongttvt();
	    z=connJDBC.tongttvn();
	    DefaultPieDataset dataset = new DefaultPieDataset();
	      dataset.setValue("MOBIPHONE",new Double(x));
	      dataset.setValue("VIETTEL", new Double(y));
	      dataset.setValue("VINAPHONE", new Double(z));
//	      dataset.setSeriesColor(Color.RED);
//	      dataset.setSeriesOutlineColor(Color.BLACK);
//	      dataset.setSeriesOutlineStroke(1.0f);
	      return dataset;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new main();
	} 
	}