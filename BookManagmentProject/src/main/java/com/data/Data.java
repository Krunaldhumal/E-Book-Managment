package com.data;

public class Data {

	private Integer id;
	private String bookname;
	private String bookauthor;

	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Data(Integer id, String bookname, String bookauthor) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.bookauthor = bookauthor;
	}
	
	
	public Data(String bookname, String bookauthor) {
		super();
		this.bookname = bookname;
		this.bookauthor = bookauthor;
	}

	public Integer getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

}
