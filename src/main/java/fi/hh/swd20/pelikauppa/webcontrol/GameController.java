package fi.hh.swd20.pelikauppa.webcontrol;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.swd20.pelikauppa.domain.Game;
import fi.hh.swd20.pelikauppa.domain.GameRepository;
import fi.hh.swd20.pelikauppa.domain.GenreRepository;



@Controller
public class GameController {
	
	
	@Autowired
	private GameRepository gamerepository;
	@Autowired
	private GenreRepository genrerepository;
	
	
	
	@RequestMapping(value= {"/login"})
	public String gameLogin(Model model) {
				return "login";
	}
	
	@RequestMapping(value= {"/logout"})
	public String gameLogout(Model model) {
				return "login";
	}
	
	@RequestMapping(value= {"/", "/games"})
	public String games(Model model) {
				model.addAttribute("games", gamerepository.findAll());
				return "games";
	}
	
	@RequestMapping(value= "/gamelist", method = RequestMethod.GET)
	public @ResponseBody List<Game> gameListRest(){
				return (List<Game>) gamerepository.findAll();
	}
	
	@RequestMapping(value= "/gamelist/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Game> findGameRest(@PathVariable("id") Long id){
		return gamerepository.findById(id);
				
	}
	
	
	@RequestMapping(value= "/add")
	public String addGame(Model model) {
		model.addAttribute("game", new Game());
		model.addAttribute("genres", genrerepository.findAll());
		return "addgame";
		
	}
	@PostMapping("/save")
	public String save(Game game) {
		gamerepository.save(game);
		return "redirect:games";
		
	}
	@RequestMapping(value="/buy/{id}")
	public String buyGame(@PathVariable("id") Long id, Model model) {
		model.addAttribute("game", gamerepository.findById(id));
		return "shoppingcart";
		
	}
	@RequestMapping(value="/checkout")
	public String gameCheckout(Model model) {
		return "checkout";
		
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/edit/{id}")
	public String editGame(@PathVariable("id") Long id, Model model) {
		model.addAttribute("game", gamerepository.findById(id));
		model.addAttribute("genres", genrerepository.findAll());
		return "editgame";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		gamerepository.deleteById(id);
		return "redirect:../games";
		}
		
}
