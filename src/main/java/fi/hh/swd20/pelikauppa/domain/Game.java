package fi.hh.swd20.pelikauppa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;


@Entity
public class Game {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id = null;
	private String title;
	private String platform;
	private String publisher;
	private String developer;
	private boolean availability;
	private Long year;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "genreid")
	private Genre genre;
	
	public Game() {}
	
	
	public Game(String title, String platform, String publisher, String developer,
			boolean availability, Long year, Double price, Genre genre) {
		super();
		this.title = title;
		this.platform = platform;
		this.publisher = publisher;
		this.developer = developer;
		this.availability = availability;
		this.year = year;
		this.price = price;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getPlatform() {
		return platform;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getDeveloper() {
		return developer;
	}
	public boolean isAvailability() {
		return availability;
	}
	public Long getYear() {
		return year;
	}
	public Double getPrice() {
		return price;
	}
	public Genre getGenre() {
		return genre;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", platform=" + platform + ", publisher=" + publisher
				+ ", developer=" + developer + ", availability=" + availability + ", year=" + year + ", price=" + price
				+ ", genre=" + genre + "]";
	}
	
	
	
	
	
	
	
}
