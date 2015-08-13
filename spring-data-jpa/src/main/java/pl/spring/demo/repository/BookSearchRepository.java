package pl.spring.demo.repository;

import java.util.List;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.searchservice.BookSearchCriteria;

public interface BookSearchRepository {
	List<BookEntity> findBookByCriteria(BookSearchCriteria book);

}
