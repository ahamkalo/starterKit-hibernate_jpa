package pl.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.spring.demo.entity.LibraryEntity;

public interface LibraryRepository extends JpaRepository<LibraryEntity, Long>{
	
	@Query("select library from LibraryEntity library where upper(library.libraryName) like concat(upper(:libraryName), '%')")
    public List<LibraryEntity> findLibraryByName(@Param("libraryName") String libraryName);
}
