package com.example.demo.Entities;

import java.util.Arrays;

public class ImageDTO {
	
	private String imageName;
    private byte[] imageData;
    
    public ImageDTO() {
    	
    	super();
    }

    public ImageDTO(String imageName, byte[] imageData) {
        this.imageName = imageName;
        this.imageData = imageData;
    }

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	@Override
	public String toString() {
		return "ImageDTO [imageName=" + imageName + ", imageData=" + Arrays.toString(imageData) + "]";
	}
}
