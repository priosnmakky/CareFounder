package com.care.health.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.care.health.model.Image;

import java.io.File;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.DatatypeConverter;
@Service
public class ImageServiceImpl implements ImageService {

	public Image createImage(String part, Image image) throws IOException {
		// TODO Auto-generated method stub
		

		// if the directory does not exist, create it
			 craeteFolder(part);
			 File outputFile = new File(part+image.getId()+"."+image.getType());
			 FileOutputStream  outputStream = new FileOutputStream(outputFile);
		     byte[] base64Decoded = DatatypeConverter.parseBase64Binary(image.getByteOrpart());					    				
		     outputStream.write(base64Decoded);
		     image.setByteOrpart(part+image.getId()+"."+image.getType());
		    	
		return image;
	}

	
	public Image createImages(String part, Image image) throws IOException {
		// TODO Auto-generated method stub
		
			 File outputFile = new File(part+image.getId()+"."+image.getType());
			 FileOutputStream  outputStream = new FileOutputStream(outputFile);
		     byte[] base64Decoded = DatatypeConverter.parseBase64Binary("");					    				
		     outputStream.write(base64Decoded);
		     image.setByteOrpart(part+image.getId()+"."+image.getType());
		    	
		return image;
	}
	public Image getImagefile(Image image) throws IOException{
		Path path = Paths.get(image.getByteOrpart());
		System.out.println(path.toString());
		byte[] data =null;
		data = Files.readAllBytes(path);
		String base64Encoded = DatatypeConverter.printBase64Binary(data);
		image.setByteOrpart(base64Encoded);
		return image;
	
	}
	public void removeImage(Image image) {
		// TODO Auto-generated method stub
		File file = new File(image.getByteOrpart());

	if(file.delete()){
			System.out.println(file.getName() + " is deleted!");
	}else{
			System.out.println("Delete operation is failed.");
		}
		
	}

	public List<Image> getAllImage() {
		// TODO Auto-generated method stub
		return null;
	}
public void craeteFolder(String part){
	File theDir = new File(part);
	if (!theDir.exists()) {
	    System.out.println("creating directory: " );
	    theDir.mkdir();
	   }
}
}
