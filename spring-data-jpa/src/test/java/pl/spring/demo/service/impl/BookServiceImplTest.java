package pl.spring.demo.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.repository.BookRepository;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../CommonServiceTest-context.xml")
public class BookServiceImplTest {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookService bookService;

	@Test
	public void shouldSaveBookAndProperlySetLibrary() {
		BookTo bookTo = new BookTo(null, "Szósta książka", "Henryk Sienkiewicz", 3L);
		
		bookService.saveBook(bookTo);
		
		assertEquals(6, bookRepository.findAll().size());
		assertEquals(6L, bookRepository.findAll().get(5).getId().longValue());
		assertEquals("Trzecia biblioteka", bookRepository.findAll().get(5).getLibrary().getName());
	}

}
