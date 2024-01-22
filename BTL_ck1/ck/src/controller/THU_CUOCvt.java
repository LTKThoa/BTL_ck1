package controller;

import java.sql.Date;
import java.sql.Time;

public class THU_CUOCvt extends THUE_BAO {
	int idvt;
	double sogiaygoi;
	double tongtt;
	Date ngayttoan;
	Time thoigianttoan;
	public THU_CUOCvt() {
	
	}
	public THU_CUOCvt(int id,int idvt, String ten,String sdt,String  loaiTB, String tinhtrangTB, double sogiaygoi, Time thoigianttoan, Date ngayttoan,double tongtt) {
		super(id,ten,sdt,loaiTB,tinhtrangTB);
		this.idvt = idvt;
		this.sogiaygoi = sogiaygoi;
		this.tongtt = tongtt;
		this.ngayttoan = ngayttoan;
		this.thoigianttoan = thoigianttoan;
	}
	public int getIdvt() {
		return idvt;
	}
	public void setIdvt(int idvt) {
		this.idvt = idvt;
	}
	public double getSogiaygoi() {
		return sogiaygoi;
	}
	public void setSogiaygoi(double sogiaygoi) {
		this.sogiaygoi = sogiaygoi;
	}
	public double getTongtt() {
		return tongtt;
	}
	public void setTongtt(double tongtt) {
		this.tongtt = tongtt;
	}
	public Date getNgayttoan() {
		return ngayttoan;
	}
	public void setNgayttoan(Date ngayttoan) {
		this.ngayttoan = ngayttoan;
	}
	public Time getThoigianttoan() {
		return thoigianttoan;
	}
	public void setThoigianttoan(Time thoigianttoan) {
		this.thoigianttoan = thoigianttoan;
	}
	


}
