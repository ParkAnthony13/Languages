package parkanthony.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import parkanthony.languages.models.LanguageModel;
import parkanthony.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the books
    public List<LanguageModel> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a book
    public LanguageModel createLanguage(LanguageModel b) {
        return languageRepository.save(b);
    }
    // retrieves a book
    public LanguageModel findLanguage(Long id) {
        Optional<LanguageModel> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    public LanguageModel updateLanguage(LanguageModel b) {
    	return languageRepository.save(b);
    }
    public void deleteLanguage(Long id) {
    	Optional<LanguageModel> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
        	languageRepository.deleteById(id);
        }
    }
}
