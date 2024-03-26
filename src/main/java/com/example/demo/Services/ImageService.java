package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entities.Image;

public interface ImageService {

	public void saveImage(byte[] imageData, String imageName);

	public List<Image> getAllImages();

	

	

}
