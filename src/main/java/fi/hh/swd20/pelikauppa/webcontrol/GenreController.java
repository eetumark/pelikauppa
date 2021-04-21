package fi.hh.swd20.pelikauppa.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.hh.swd20.pelikauppa.domain.Genre;
import fi.hh.swd20.pelikauppa.domain.GenreRepository;

@Controller
public class GenreController {

	@Autowired
	private GenreRepository genrerepository;
	
	@RequestMapping(value= "/genre")
	public String GenreList(Model model) {
		model.addAttribute("genres", genrerepository.findAll());
		return "genres";
	}
	
	@RequestMapping(value= "/addgenre")
	public String addGenre(Model model) {
		model.addAttribute("genre", new Genre());
		return "addgenre";
		
	}
	@PostMapping("/savegenre")
	public String saveGenre(Genre category) {
		genrerepository.save(category);
		return "redirect:genres";
		
	}
	@RequestMapping(value="/editgenre/{genreid}")
	public String addGenre(@PathVariable("genreid") Long id, Model model) {
		model.addAttribute("genre", genrerepository.findById(id));
		return "editgenre";
	}
	
	@GetMapping("/deletegenre/{genreid}")
	public String deleteGenre(@PathVariable("genreid") Long id, Model model) {
		genrerepository.deleteById(id);
		return "redirect:../genres";
		}
		
}
