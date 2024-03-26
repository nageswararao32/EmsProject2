package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Song;

public interface SongRepository extends JpaRepository<Song, Long> {

	public Song findByName(String name);

}
