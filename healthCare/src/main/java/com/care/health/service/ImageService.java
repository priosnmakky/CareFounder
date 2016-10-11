package com.care.health.service;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.care.health.model.Image;



public interface ImageService {
	public Image createImage(String part, Image image) throws IOException;
	public void removeImage(Image image);
	public Image getImagefile(Image image) throws IOException;
//	public Image createImage(String part, Image image) throws IOException ;
//    public Image updateImage(String part,List<Image> Images);
//    public Image removeImage(String part,Image image);
//    public List<Image> getAllImage();
}
