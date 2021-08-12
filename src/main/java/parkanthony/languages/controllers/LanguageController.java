package parkanthony.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import parkanthony.languages.models.LanguageModel;
import parkanthony.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
    
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    @RequestMapping("/")
    public String homeDirect() {
    	return "redirect:/languages";
    }
    @RequestMapping("/languages")
    public String index(Model model,@ModelAttribute("language") LanguageModel language) {
    	List<LanguageModel> languages = languageService.allLanguages();
    	model.addAttribute("languages", languages);
    	return "/languages/index.jsp";
    }
    @RequestMapping("/languages/new")
    public String newLanguage(@ModelAttribute("language") LanguageModel language) {
    	return "/languages/new.jsp";
    }
    @RequestMapping(value="/languages",method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") LanguageModel language, BindingResult result) {
    	if(result.hasErrors()) {
    		return "/languages/new.jsp";
    	} else {
    		languageService.createLanguage(language);
    		return "redirect:/languages";
    	}
    }
    @RequestMapping("/languages/{id}")
    public String show(Model model,@PathVariable("id") Long id) {
    	System.out.println("showing???");
    	LanguageModel language = languageService.findLanguage(id);
    	model.addAttribute("language", language);
    	return "/languages/show.jsp";
    }
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	LanguageModel language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/edit.jsp";
    }
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") LanguageModel language, BindingResult result) {
        System.out.println("updating why");
    	if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
        	languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	System.out.println("WTFFFFFFFF");
    	languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}