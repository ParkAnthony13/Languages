package parkanthony.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import parkanthony.languages.models.LanguageModel;

@Repository
public interface LanguageRepository extends CrudRepository<LanguageModel, Long>{ // the table name and the key type Long
	// this method retrieves all the books from the database
	List<LanguageModel> findAll();
	// this method finds books with descriptions containing the search string
	List<LanguageModel> findByCreatorContaining(String search);
	// this method counts how many title contain a certain string
	Long countByNameContaining(String search);
	// this method deletes a book that starts with a specific title
	Long deleteByNameStartingWith(String search);
}


