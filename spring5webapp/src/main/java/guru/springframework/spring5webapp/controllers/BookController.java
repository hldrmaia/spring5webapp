package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {

	/*
	 * Using the method getBooks to access data and return the model to view
	 * 
	 * 1- Create the package controllers 2- Create the class BookController 3- Add
	 * the Stereotype @Controller to the class 4- Create the method getBooks, which
	 * receive the model to access the repository, calling the method findAll and
	 * return it to the view 5- Add the Stereotype @RequestMapping, which maps /book
	 * to the URL
	 * 
	 */

	private final BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {

		model.addAttribute("books", bookRepository.findAll());

		return "books/list";
	}

}
