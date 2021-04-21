package fi.hh.swd20.pelikauppa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.hh.swd20.pelikauppa.webcontrol.GameController;
import fi.hh.swd20.pelikauppa.webcontrol.GenreController;
import fi.hh.swd20.pelikauppa.webcontrol.UserDetailServiceImpl;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class PelikauppaApplicationTests {
	
	@Autowired
	private GameController gameController;

	@Test
	void contextLoads() throws Exception {
		 assertThat(gameController).isNotNull(); 
	}
	@Autowired
	private GenreController genreController;

	@Test
	void context2Loads() throws Exception {
		 assertThat(genreController).isNotNull(); 
	}
	@Autowired
	private UserDetailServiceImpl userController;

	@Test
	void context3Loads() throws Exception {
		 assertThat(userController).isNotNull(); 
	}
	
	
	
	
	
	
}
