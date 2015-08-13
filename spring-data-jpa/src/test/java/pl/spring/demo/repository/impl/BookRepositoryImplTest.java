package pl.spring.demo.repository.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.searchservice.BookSearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../CommonRepositoryTest-context.xml")
public class BookRepositoryImplTest {

	@Autowired
	private BookRepositoryImpl bookRepositoryImpl;
	BookSearchCriteria bookSearchCriteria;

	@Before
	public void setUpt() {
		bookSearchCriteria = new BookSearchCriteria();
	}

	@Test
	public void shouldFind2BooksForTitlePrefix_P() {
		// given
		bookSearchCriteria.setTitle("P");
		// when
		List<BookEntity> bookEntities = bookRepositoryImpl.findBookByCriteria(bookSearchCriteria);
		// then
		assertNotNull(bookEntities);
		assertEquals(2, bookEntities.size());
	}
	
	@Test
	public void shouldFind4BooksForAuthorPrefix_Z() {
		// given
		bookSearchCriteria.setAuthor("Z");
		// when
		List<BookEntity> bookEntities = bookRepositoryImpl.findBookByCriteria(bookSearchCriteria);
		// then
		assertNotNull(bookEntities);
		assertEquals(4, bookEntities.size());
	}
	
	@Test
	public void shouldFind2BooksForLibraryNamePrefix_D() {
		// given
		bookSearchCriteria.setLibraryName("D");
		// when
		List<BookEntity> bookEntities = bookRepositoryImpl.findBookByCriteria(bookSearchCriteria);
		// then
		assertNotNull(bookEntities);
		assertEquals(2, bookEntities.size());
	}
	
	@Test
	public void shouldFind1BookForAllCriteria() {
		// given
		bookSearchCriteria.setTitle("P");
		bookSearchCriteria.setAuthor("Z");
		bookSearchCriteria.setLibraryName("D");
		// when
		List<BookEntity> bookEntities = bookRepositoryImpl.findBookByCriteria(bookSearchCriteria);
		// then
		assertNotNull(bookEntities);
		assertEquals(1, bookEntities.size());
	}
	
	@Test
	public void shouldReturnAllBooksForNoCriteria() {
		// given when
		List<BookEntity> bookEntities = bookRepositoryImpl.findBookByCriteria(bookSearchCriteria);
		// then
		assertNotNull(bookEntities);
		assertEquals(5, bookEntities.size());
	}

}
