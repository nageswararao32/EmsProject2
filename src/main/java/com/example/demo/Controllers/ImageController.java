package com.example.demo.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entities.Image;
import com.example.demo.Entities.ImageDTO;
import com.example.demo.Services.ImageService;

@RestController
@CrossOrigin("*")
public class ImageController {
	
	@Autowired
	
	ImageService imageService;
    
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("imageData") MultipartFile file, @RequestParam("imageName") String imageName) throws IOException {
        byte[] imageData = file.getBytes();
        imageService.saveImage(imageData, imageName);
        System.out.println("Image Name is:  "+imageName);
        return ResponseEntity.ok("Image uploaded successfully!");
    }
    
    @GetMapping("/images")
    public ResponseEntity<List<ImageDTO>> getAllImages() {
        List<Image> imagesList = imageService.getAllImages();
        List<ImageDTO> images = imagesList.stream()
                .map(image -> new ImageDTO(image.getImageName(), image.getImageData()))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(images);
    }


    


}
