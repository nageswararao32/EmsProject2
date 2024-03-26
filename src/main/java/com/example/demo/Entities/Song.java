package com.example.demo.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Song")
public class Song {


	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "songId")
	
	private long id;
	
	@Column(name = "songName")
	
	private String name;
	
	@Column(name = "songArtist")
	
	private String artist;
	
	@Column(name = "songGenre")
	
	private String genre;
	
	@Column(name = "songLink")
	
	private String link;
		
	@ManyToMany
	
	private List<PlayList>playlist;
	
	@ManyToMany
	
	private List<UserPlayList>uplists;
	
	public Song() {
		
		super();
		
	}

	public Song(long id, String name, String artist, String genre, String link, List<PlayList> playlist,
			List<UserPlayList> uplists) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.link = link;
		this.playlist = playlist;
		this.uplists = uplists;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<PlayList> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<PlayList> playlist) {
		this.playlist = playlist;
	}

	public List<UserPlayList> getUplists() {
		return uplists;
	}

	public void setUplists(List<UserPlayList> uplists) {
		this.uplists = uplists;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", link=" + link
				+ ", playlist=" + playlist + ", uplists=" + uplists + "]";
	}

	

}
