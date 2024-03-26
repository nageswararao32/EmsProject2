package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
