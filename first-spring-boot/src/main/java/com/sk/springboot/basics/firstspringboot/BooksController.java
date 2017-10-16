/**
 * 
 */
package com.sk.springboot.basics.firstspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author S.Kulkarni
 *
 */
@RestController
public class BooksController {
	@GetMapping("/books")
	public List<Book> getAllBooks() {

		return Arrays.asList(new Book(1L, "Java 8", "Sam"), new Book(2L,
				"Japanese", "Poo"));
	}
}
