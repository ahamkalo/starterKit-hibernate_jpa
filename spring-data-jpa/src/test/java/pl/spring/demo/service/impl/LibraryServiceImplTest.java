package pl.spring.demo.service.impl;

import org.junit.Before;
import org.mockito.*;

import pl.spring.demo.repository.LibraryRepository;

import org.junit.Test;

public class LibraryServiceImplTest {

	@InjectMocks
	private LibraryServiceImpl libraryService;
	
	@Mock
	private LibraryRepository libraryRepository;
	
	@Before
	public void setUpt() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShouldRemoveBooksWhenLibraryIsRemoved() {
		libraryService.deleteLibrary(1L);
		Mockito.verify(libraryRepository).delete(Mockito.anyLong());
	}

}
