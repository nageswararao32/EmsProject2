package com.example.demo.Services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entities.Image;
import com.example.demo.Repos.ImageRepository;

@Service
public class ImageServiceImpl  implements ImageService {
	
	@Autowired
	
	ImageRepository repo;

	@Override
	public void saveImage(byte[] imageData, String imageName) {
		
		Image image = new Image();
        image.setImageName(imageName);
        image.setImageData(imageData);
        repo.save(image);
		
	}

	@Override
	public List<Image> getAllImages() {
		
		return repo.findAll();
	}


}
