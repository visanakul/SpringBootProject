package com.vishal.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vishal.web.model.Book;

@Component
public class BookDAO {
	private List<Book> bookList=new ArrayList<>();

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	} 
}
