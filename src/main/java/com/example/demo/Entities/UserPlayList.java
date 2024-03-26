package com.example.demo.Entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class UserPlayList {
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "playlistId")
	
	private long id;
	
	@Column(name = "playlistName")
	
	private String name;
	
	@Column(name = "playlistUserName")
	
	private String plUsername;
		
	@ManyToMany
	
	@Column(name = "usongs")

	private List<Song> usongs;
	
	public UserPlayList() {
		
		super();
	}

	public UserPlayList(long id, String name, String plUsername, List<Song> usongs) {
		super();
		this.id = id;
		this.name = name;
		this.plUsername = plUsername;
		this.usongs = usongs;
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

	public String getPlUsername() {
		return plUsername;
	}

	public void setPlUsername(String plUsername) {
		this.plUsername = plUsername;
	}

	public List<Song> getUsongs() {
		return usongs;
	}

	public void setUsongs(List<Song> usongs) {
		this.usongs = usongs;
	}

	@Override
	public String toString() {
		return "UserPlayList [id=" + id + ", name=" + name + ", plUsername=" + plUsername + ", usongs=" + usongs + "]";
	}

}
