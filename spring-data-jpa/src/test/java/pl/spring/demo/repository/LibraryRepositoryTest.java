package pl.spring.demo.repository;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.LibraryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class LibraryRepositoryTest {

	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private BookRepository bookRepository;

    @Test
	public void testShouldRemoveLibraryWithId2WithAllBooks() {
		// given when
		libraryRepository.delete(2L);
		// then
		assertNull(libraryRepository.findOne(2L));
		assertNotNull(libraryRepository.findOne(1L));
		assertNull(bookRepository.findOne(2L));
		assertNull(bookRepository.findOne(5L));
		assertNotNull(bookRepository.findOne(1L));
	}


    @Test
    public void testShouldFindByName() {
        // given
        final String name = "pierw";
        // when
        List<LibraryEntity> libraries = libraryRepository.findLibraryByName(name);
        // then
        assertNotNull(libraries);
        assertFalse(libraries.isEmpty());
        assertEquals("Pierwsza biblioteka", libraries.get(0).getName());
    }
    

}
