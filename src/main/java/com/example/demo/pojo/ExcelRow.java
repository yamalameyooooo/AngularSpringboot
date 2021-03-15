package com.example.demo.pojo;

public class ExcelRow {
	
	private String col0;
	private String col1;
	private String col2;
	private String col3;
	private String col4;
	public String getCol0() {
		return col0;
	}
	public void setCol0(String col0) {
		this.col0 = col0;
	}
	public String getCol1() {
		return col1;
	}
	public void setCol1(String col1) {
		this.col1 = col1;
	}
	public String getCol2() {
		return col2;
	}
	public void setCol2(String col2) {
		this.col2 = col2;
	}
	public String getCol3() {
		return col3;
	}
	public void setCol3(String col3) {
		this.col3 = col3;
	}
	public String getCol4() {
		return col4;
	}
	public void setCol4(String col4) {
		this.col4 = col4;
	}
	public ExcelRow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExcelRow(String col0, String col1, String col2, String col3, String col4) {
		super();
		this.col0 = col0;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.col4 = col4;
	}
	@Override
	public String toString() {
		return "ExcelRow [col0=" + col0 + ", col1=" + col1 + ", col2=" + col2 + ", col3=" + col3 + ", col4=" + col4
				+ "]";
	}
	
	

}
