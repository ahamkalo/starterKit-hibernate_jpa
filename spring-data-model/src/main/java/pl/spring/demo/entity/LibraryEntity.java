package pl.spring.demo.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY")
public class LibraryEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, length = 50)
    private String libraryName;
    
    @OneToMany(mappedBy="libraryEntity", cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
    private Set<BookEntity> libraryBooks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return libraryName;
	}

	public void setName(String name) {
		this.libraryName = name;
	}

	public Set<BookEntity> getBooks() {
		return libraryBooks;
	}
    
    
}