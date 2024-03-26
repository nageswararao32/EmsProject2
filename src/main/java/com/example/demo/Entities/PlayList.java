package com.example.demo.Entities;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "Playlist")
public class PlayList {

	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "playlistId")
	
	private long id;
	
	@Column(name = "playlistName")
	
	private String name;
		
	@ManyToMany
	
	/*@JoinTable(
	        name = "playlist_song", 
	        joinColumns = { @JoinColumn(name = "playlistId") }, 
	        inverseJoinColumns = { @JoinColumn(name = "songId") }
	    )*/
	
	@Column(name = "songs")

	private List<Song> songs;
	
	public PlayList() {
		
		super();
	}

	public PlayList(long id, String name, List<Song> songs) {
		super();
		this.id = id;
		this.name = name;
		this.songs = songs;
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

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "PlayList [id=" + id + ", name=" + name + ", songs=" + songs + "]";
	}

	
}
