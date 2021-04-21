package fi.hh.swd20.pelikauppa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.swd20.pelikauppa.domain.Game;
import fi.hh.swd20.pelikauppa.domain.GameRepository;
import fi.hh.swd20.pelikauppa.domain.Genre;
import fi.hh.swd20.pelikauppa.domain.GenreRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PelikauppaRepositoryTest {

		@Autowired
		private GameRepository gamerepository;
		
		@Test
		public void findByTitleShouldReturnGame( ) {
			List<Game> games = gamerepository.findByTitle("RuneScape");
			assertThat(games).hasSize(1);
			assertThat(games.get(0).getDeveloper()).isEqualTo("Jagex");
		}
		@Test
		public void createNewGame() {
			Game game = new Game("The Last Of Us", "PlayStation", "Sony", "Naughty Dog", true, (long) 2013, 30.0, new Genre("Action-Adventure"));
			gamerepository.save(game);
			assertThat(game.getId()).isNotNull();
		}
		
		@Autowired
		private GenreRepository genrerepository;
		
		@Test
		public void findByNameShouldReturnGenre( ) {
			List<Genre> genres = genrerepository.findByName("FPS");
			assertThat(genres).hasSize(1);
			assertThat(genres.get(0).getName()).isEqualTo("FPS");
		}
		@Test
		public void createNewCategory() {
			Genre genre = new Genre("Puzzle");
			genrerepository.save(genre);
			assertThat(genre.getGenreid()).isNotNull();
		}
		
	}