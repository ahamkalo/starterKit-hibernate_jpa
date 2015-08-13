package pl.spring.demo.dao;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.LibraryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class LibraryDaoImplTest {

	@Autowired
	private LibraryDao libraryDao;
	
	@Autowired
	private BookDao bookDao;
	
    @Test
    public void testShouldFindLibraryById() {
        // given
        final long bookId = 1;
        // when
        LibraryEntity libraryEntity = libraryDao.findOne(bookId);
        // then
        assertNotNull(libraryEntity);
        assertEquals("Pierwsza biblioteka", libraryEntity.getName());
    }

	@Test
	public void testShouldFindByName() {
		// given
		final String name = "pierw";
		// when
		List<LibraryEntity> libraries = libraryDao.findLibraryByName(name);
		// then
		assertNotNull(libraries);
		assertFalse(libraries.isEmpty());
		assertEquals("Pierwsza biblioteka", libraries.get(0).getName());
	}
	
    @Test
	public void testShouldRemoveLibraryWithId2WithAllBooks() {
		// given when
    	libraryDao.delete(2L);
		// then
		assertNull(libraryDao.findOne(2L));
		assertNotNull(libraryDao.findOne(1L));
		assertNull(bookDao.findOne(2L));
		assertNull(bookDao.findOne(5L));
		assertNotNull(bookDao.findOne(1L));
	}
}
