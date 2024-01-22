package controller;

public class THUE_BAO {
		int id;
		String ten;
		String sdt;
		String loaiTB;
		String tinhtrangTB;
	public THUE_BAO() {
		
	}
	public THUE_BAO(int id, String ten, String sdt, String loaiTB, String tinhtrangTB) {
			//super();
			this.ten = ten;
			this.sdt = sdt;
			this.loaiTB = loaiTB;
			this.tinhtrangTB = tinhtrangTB;
			this.id=id;
		}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getTinhtrangTB() {
		return tinhtrangTB;
	}
	public void setTinhtrangTB(String tinhtrangTB) {
		this.tinhtrangTB = tinhtrangTB;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	public String getLoaiTB() {
		return loaiTB;
	}
	public void setLoaiTB(String loaiTB) {
		this.loaiTB = loaiTB;
	}
	@Override
	public String toString() {
		return "THUE_BAO [ten=" + ten + ", sdt=" + sdt + "]";
	}

}
