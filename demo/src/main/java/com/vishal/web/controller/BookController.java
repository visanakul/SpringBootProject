package com.vishal.web.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vishal.web.configure.AppProperties;
import com.vishal.web.dao.BookDAO;
import com.vishal.web.model.Book;

/**
 * @author VISHAL
 *
 */
/**
 * @author VISHAL
 *
 */
@Controller
public class BookController {

	@Autowired
	private BookDAO bookDao;

	@Autowired
	private AppProperties properties;

	
	/**
	 * @param msg Redirect attribute
	 * @param model to store and pass blank book object,global books list and operation status msg to the view
	 * @return view books.jsp
	 */
	@GetMapping("/show")
	public String showBookForm(@ModelAttribute("msg") String msg, Model model) {

		//Create blank book object
		Book book = new Book();

		//Store blank book object
		model.addAttribute("book", book);
		
		//Store global list of books in model
		model.addAttribute("bookList", bookDao.getBookList());
		
		//Check if redirect attribute available or not
		if (msg.length() > 0) {
			System.out.println("Redirected attribute : " + msg);
			model.addAttribute("msg", msg);
		}

		//return view books.jsp
		return "books";
	}
	
	/**
	 * @param book from view
	 * @param bindingResult validation status from view
	 * @param ra to store msg and redirect it to books.jsp view
	 * @param model to store and redirect(Double posting problem) blank book object,global books list and operation status msg to the show url 
	 * @return redirect url to books.jsp
	 */
	@PostMapping("/save")
	public String storeBookData(@Valid @ModelAttribute Book book, BindingResult bindingResult, RedirectAttributes ra,
			Model model) {
		//Server side validation if client side JavaScript is disabled...
		if (bindingResult.hasErrors()) {
			//System.out.println("Form error");
			model.addAttribute("bookList", bookDao.getBookList());
			return "show";
		}
		//Check for new Object save
		if (book.getBookId() == null) {
			//System.out.println("New Book : " + book);
			//Add new book record in book list
			bookDao.getBookList().add(book);
			//Generate Unique id for book
			book.nextBookId();
			//Add redirect msg
			ra.addFlashAttribute("msg", properties.getProperties().get("bookSuccess"));
		} 
		//Check for existing object for update
		else {
			//Searching book object as per bookId received from view
			Book oldBook = bookDao.getBookList().stream().filter((b) -> {
				return b.getBookId() == book.getBookId();
			}).findFirst().get();
			//Update old Book data with new Book data
			oldBook.setName(book.getName());
			oldBook.setPrice(book.getPrice());
			oldBook.setAuthor(book.getAuthor());
			//System.out.println("Update Book : " + oldBook);
			//Add redirect msg
			ra.addFlashAttribute("msg", properties.getProperties().get("bookUpdate"));
		}

		return "redirect:/show";
	}

	/**
	 * @param bookId from request query string
	 * @param ra to redirect msg to books.jsp
	 * @return redirect url to books.jsp
	 */
	@GetMapping("/delete")
	public String deleteBook(@RequestParam("bookId") Integer bookId, RedirectAttributes ra) {
		//Search book object as per bookId from query string
		Book book = bookDao.getBookList().stream().filter((b) -> {
			return b.getBookId() == bookId;
		}).findFirst().get();
		//Remove book object from book list
		bookDao.getBookList().remove(book);
		//Add redirect msg
		ra.addFlashAttribute("msg", properties.getProperties().get("bookDelete"));
		return "redirect:/show";
	}

	/**
	 * @param bookId from query string 
	 * @param model to store and pass blank book object and global books list to the view
	 * @return
	 */
	@GetMapping("/update")
	public String updateBook(@RequestParam("bookId") Integer bookId, Model model) {
		//Search book object as per bookId from query string
		Book book = bookDao.getBookList().stream().filter((b) -> {
			return b.getBookId() == bookId;
		}).findFirst().get();
		
		//Store selected book object
		model.addAttribute("book", book);
		//Store book list object
		model.addAttribute("bookList", bookDao.getBookList());
		return "books";
	}

}
