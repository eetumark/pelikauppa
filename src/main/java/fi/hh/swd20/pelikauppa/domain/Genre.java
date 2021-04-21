package fi.hh.swd20.pelikauppa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Genre {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long genreid = null;
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	private List<Game> games;
	
	
	public Genre() {}

	public Genre(String name) {
		super();
		this.name = name;
	}


	public Long getGenreid() {
		return genreid;
	}

	public String getName() {
		return name;
	}

	public void setGenreid(Long genreid) {
		this.genreid = genreid;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Genre [genreid=" + genreid + ", name=" + name + "]";
	}
	
	
	
}
