package pl.spring.demo.to;

public class BookTo {
    private Long id;
    private String title;
    private String authors;
    private Long libraryId;
    private String libraryName;
   
    public BookTo() {
    }

    public Long getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Long libraryId) {
		this.libraryId = libraryId;
	}

	public BookTo(Long id, String title, String authors, Long libraryId) {
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.libraryId = libraryId;
	}

	public BookTo(Long id, String title, String authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
    }
    
    public BookTo(Long id, String title, String authors, Long libraryId, String libraryName) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.libraryId = libraryId;
        this.libraryName = libraryName;
    }

    public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
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

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
}
