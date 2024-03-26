package com.example.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
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
	
	@Column(name = "userName")
	
	private String userName;
	
	
	public User() {
		
		super();
	}


	public User(long id, String name, String artist, String genre, String link, String userName) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.link = link;
		this.userName = userName;
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


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", link=" + link
				+ ", userName=" + userName + "]";
	}
	
	

}
