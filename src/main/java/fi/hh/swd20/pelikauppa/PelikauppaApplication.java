package fi.hh.swd20.pelikauppa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.hh.swd20.pelikauppa.domain.Game;
import fi.hh.swd20.pelikauppa.domain.Genre;
import fi.hh.swd20.pelikauppa.domain.User;
import fi.hh.swd20.pelikauppa.domain.GameRepository;
import fi.hh.swd20.pelikauppa.domain.GenreRepository;
import fi.hh.swd20.pelikauppa.domain.UserRepository;

@SpringBootApplication
public class PelikauppaApplication {
	private static final Logger log = LoggerFactory.getLogger(PelikauppaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PelikauppaApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(GameRepository gamerepository, GenreRepository genrerepository, UserRepository userrepository) {
		log.info("save couple of games");
		return (args) -> {
			
			
			
			Genre g1 = new Genre("FPS");
			genrerepository.save(g1);
			Genre g2 = new Genre("RTS");
			genrerepository.save(g2);
			Genre g3 = new Genre("MMORPG");
			genrerepository.save(g3);
			
			gamerepository.save(new Game("Counter-Strike: Global Offensive", "PC", "Valve", "Valve", true, 2012L, 13.5, genrerepository.findByName("FPS").get(0)));
			gamerepository.save(new Game("RuneScape", "PC", "Jagex", "Jagex", true, 2001L, 0.0, genrerepository.findByName("MMORPG").get(0)));
			
			
			User user1 = new User("user", "$2a$10$pq1oNFflQddMo54ODDMLnesMKQESHWd3o35nEFoqhBuiD689J/lFu", "USER");
			User user2 = new User("admin", "$2a$10$vBIadx7vz21SQNSEaGFuPOHofecOIAuWOLofFFTac044TdxRVpdLm", "ADMIN");
			userrepository.save(user1);
			userrepository.save(user2);
			
			
		
			
		log.info("fetch all games");
		for (Game game : gamerepository.findAll()) {
			log.info(game.toString());
		}
		
		};
		
	}

}

