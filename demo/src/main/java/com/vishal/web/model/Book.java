package com.vishal.web.model;

import lombok.Data;

@Data
public class Book {
	private static Integer count;
	private Integer bookId;
	private String name;
	private Double price;
	private String author;

	static {
		count=0;
	}
	public  void nextBookId() {
		bookId=++count;
	}

}
