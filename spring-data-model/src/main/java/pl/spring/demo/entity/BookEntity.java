package pl.spring.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BOOK")
public class BookEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String title;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "BOOK_AUTHOR", joinColumns = {
			@JoinColumn(name = "BOOK_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "AUTHOR_ID", nullable = false, updatable = false) })
	private Set<AuthorEntity> authors = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private LibraryEntity libraryEntity;


	// for hibernate
	protected BookEntity() {
	}
	
	public BookEntity(Long bookId, String title) {
		this.id = bookId;
		this.title = title;
	}

	public LibraryEntity getLibrary() {
		return libraryEntity;
	}

	public void setLibrary(LibraryEntity libraryEntity) {
		this.libraryEntity = libraryEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<AuthorEntity> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<AuthorEntity> authors) {
		this.authors = authors;
	}
}