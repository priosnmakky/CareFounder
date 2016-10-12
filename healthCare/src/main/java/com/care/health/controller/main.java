package com.care.health.controller;

import java.io.File;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;

import com.care.health.model.HospitalDetail;
import com.care.health.model.Image;


public class main {
	
	public static void main(String[] args) {
		
		/// Authentication authentication = SecurityContextHolder.getContext()
//				    .getAuthentication();
		
		
//		int size = 20;
//		String  abc[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
//
//        ArrayList<Integer> list = new ArrayList<Integer>(size);
//        for(int i = 1; i <= abc.length; i++) {
//            list.add(i);
//        }
//
//        Random rand = new Random();
//        while(list.size() > 0) {
//            int index = rand.nextInt(list.size());
//            
//            System.out.println("Selected: "+list.remove(index));
//        }
		
//		Blog blog = new Blog();
//		blog.setId("1");
//		System.out.println(blog.hashCode());
//		Blog blog1 = new Blog();
//		blog1.setId("1");
//		System.out.println(blog1.hashCode());
		// TODO Auto-generated method stub
		
//	
		
//new File("C:\\Directory1").mkdir();
Path path = Paths.get("src//main//java//com//care//hralth//resource//image//test1.jpg");
	byte[] data =null;
		try {
		data = Files.readAllBytes(path);
//
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	
//
//////
	String base64Encoded = DatatypeConverter.printBase64Binary(data);
	System.out.print(base64Encoded);
	
//	try{
//		File file = new File("C://Users//narongrit//workspace//.metadata//.plugins//org.eclipse.wst.server.core//tmp2//wtpwebapps//healthCare//WEB-INF//resource//image//Employee//57fcb9bd14197d9daa5ee291.mp4");
//
//	if(file.delete()){
//		System.out.println(file.getName() + " is deleted!");
//	}else{
//		System.out.println("Delete operation is failed.");
//	}
//
//	}catch(Exception e){
//
//	e.printStackTrace();
//
//}
	
		
	//	File theDir = new File("src//main//java//com//care//hralth//resource//image//makky");
//
//		// if the directory does not exist, create it
//		if (!theDir.exists()) {
//		    System.out.println("creating directory: " );
//		    boolean result = false;
//
//		    try{
//		        theDir.mkdir();
//		        result = true;
//		    } 
//		    catch(SecurityException se){
//		        //handle it
//		    }        
//		    if(result) {    
//		        System.out.println("DIR created");  
//		    }
//		}else{
//			System.out.println("sdfsdfsf");
//		}
//		
		
	////	TimeZone timeZone = TimeZone.getTimeZone("UTC");
	///	Calendar calendar = Calendar.getInstance(timeZone);
		///SimpleDateFormat simpleDateFormat =new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy");
		//calendar.getTime();
	///	System.out.println(calendar.getTime());
//		String [] b = "dsdas.jpg".split("\\.");
//		System.out.println(b[1]);
//		String base64Encoded ="/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5OjcBCgoKDQwNGg8PGjclHyU3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3N//AABEIAFoAhwMBIgACEQEDEQH/xAAbAAACAgMBAAAAAAAAAAAAAAADBAIFAAEGB//EADcQAAIBAwIDBgQFBAEFAAAAAAECAwAEERIhBTFBEyJRYXGBBhQykSNSscHRYqHh8EIHFTM0Q//EABoBAAMBAQEBAAAAAAAAAAAAAAECAwQABQb/xAArEQACAgEDAwIFBQEAAAAAAAABAgARAxIhMQQiQRORMlFSYXGBobHB4QX/2gAMAwEAAhEDEQA/AL2a0sYlV7bs448YRUbSB5kjekJP+32Fypju42Vjhl7UA48yzb1y1rfcXhlUuS1tGSqx9nnn+vtUeINazKzXMdpAeaJDKxYkdT4CvjE6Ng1M1j7TE2LaxO+iurTQ00U8QXADEHIPocAUD5m3dn7R4dQGwD4JrziPil8t0RatDcwMm0CRhCo88dfep3XE5EeBplaPScqGzgiuP/LIbmZ2RgZ3Ll1uC6gGM9c528KvbP4kt7KHsVgikR10NnkB4H7151Dx6RMrIr6SMBgOVEfiktpG7ypFNbgA6gMtRx4M2JrU0ZEF1O06+4jjuoOGpwd4rdLKRW7ILs4HP3roJb2SCxlLyBTpY7L7ivOuFcU7c9paQyImMjn3q3fcV4lLHMJUjjiAwFlP1Hx26VF8XUNlstuPeOmRvMoo/wDqBxe5uYLK9WCaNp1j1acEAtjpz516H8UWMnGfheaxRQX7ImB1Xqu4G3XavLo+HW72lpciK37ZLiPU4LjUS49q9TNxlkNnOur8ofODWjr/AE8bo+EUQTf5FTRkdRWmVXwp8R6/hCKARv8AMLiCQFcYcHGD5VSf9Vrp734asprntEnWTSIxumOpzQrhJeC3F1DCSsc8na6emr3rmviLiV1xK1htZZCVRto+YFaemwg9QMqfDd+/iKjHWK4nOoPx4lzzBJPhW0XDksxNFKu1wCqchpAxmpXSJGrHDaiftXult5oL3CIIpyoBCEc8LUZUjikCli4J5AYpIMVJIDDP5hUgZI27T9TXaCDzBpI8wssXeJZSqnlk1lJSSu3eY8zW6cIalFRq5no8fGGiYRsGZycgnpS/ELyKQdo0hAPMsevpsKhZ3vBvl4xe2syOT9azDB9ac+S4TeRF7OWNyux1yDJ9jj+1eFS42sqRPPLsp8yjs+KTKpWKGESK282Mk+hJOPYVK54jLd3ifMQxroXbGcEml76yurW8STh4knTOlljJYjyOKwcLvI50ubkxwKxyAZNRJ8gP5rbpxnu+csql+5Z0lheDRoe2E7Af+NdtvXrWpr1pYhGlpAviI8nT6k1WyWon0LKGcA/Ux/YHf3NHt4IYyI1wwHRdlH7VAYRHXC1bmGgurpyqNgIPykgedPrE+kBZdiN1IzgUuh7SRUA2xuAMYHj/AIp0CNIiBnJ69SaIxJ5WE4V8iJShwxRcFVGSFGKxZn2KSlVHXBrRcfMFHfTG40tjoPGpS8Ptbm3VXkOpc9jIgJB8uXj5VHIihqPEnkwAjaQubqMhe2nDNjYnvCtqqSKpVVGRkhlqrEaQXqQfLXLNEdJZF1RjHmRzpy7vI0UtGNOsd7s9mOPHIFKcVUFmMqw2hTBC+pI44zpwG5A0sbWOFS7WaeYPUePpShu1QmVu7CAV78OCc/etnittJDGGxkEYUA71QYnHEWmqxCy2FtMA5tVdCf8A5tnT60pcWFlI6pLGysBuQMZ8BTC3UqKXtZMJ+U/8v4NRF48pKTLlgchQDnP2NUX1BwYVZ/Eq7jgVqJAFZ8nfmCAPCsp4NG82O6soydDIcH/c1lW9bINiZb13HJMQtLDjeB8xMlmq/wBCl/sP3q3tUQHsr57m9zzQOEP9ht71Br6NlC/iqu/cRVAx+potvckABU0A74AG9M+puRPV7YxbW62xPZwR28Rz+EGDOfUjAocca28ja3DlsnQoJkPuTgfYVkjhF1SylAc4wMk1Hg0ttcy9nNDcRQlipeNlMhbbx6b86UKdyZxImpO3kdlVFVSPpB2z5nmfQYp2JZViSFjGZN9ZVcKg9DzNb7WIXIt7MPIU7zM2xjB/N5+VS0rHlUQFBy7x5/vTfaophogsKaIdhnLHqc9c9TWp5cTaNIHZprJPQtsB+tLS3DwyoBbNID+RhgHzyf0zW3dB2jSoe1mOqQE5wRyH2Cj70CKg/MhHM0VwweJXycZA3FMQjS8jspwmdnAfGemOX96XW97OdjjBbBGrn/vOmxxOKRlEds8s7DBUlQrEddz1rNmVieJzcQ8kMt3bSLw25WC6x+EGA0sR0I3x4ZFcbPx7iqyTWfGr027oQpjForsPfIx7GugsI57niYhtrdrNm5K8wjz4jn60z8XfCdzfWsOi0Pzig6JI2DgjqGI6deW3nXYDixPpy1R/FiJ2jtJnMRSSuzTRcSQxnGH7HBx5+HnvQJIJ7aVpfmBInXQNGaNw6DiHC45uHygJlyxSaIgk46Z6U9Ckr2scPafNSuWARocgY8TjrWtmCnaq/qYshZXIFf57SvjmWEjQjSu++lznf2zUbviUoXsptGegAGR50te2t3cXRMFoYZU2KDu6fuaFFaz2dxG9zYvNFjvKqkg5/qHI1RUQ7+Y64sZonmbk4jiQ5BDHmdv3rKsBKsf4rWTRg7aAGBX1zjPrWVxr6Zxr6Lh4YgVUx9d9RFHMsUCEbtj6iTsPUn9KD2wyuDkH/l1Pp/NAWEzTHWzMoY4XV3U/k/pTgDzN8dE01yVVW0a+TMNyo8AeQ6eNHnujGy2lmdUzbu/Movic9SNgKQuJZTMbaxwszL35SuRGv8+VPWUKW0ehcsx3dm5sfE0CAN4ajVtGlvGEjznqTzY+J86I8Ql0hic+AOxoRkC42znw61sDuEtjURuaS4DNuoUokeo521BskefOgXTnU538SM9KxphrfSNkxsKUuJhqHf0ht9jvnauXkxeZBmzId86hutTSdklXQ5DMQpwBvv4eNLyzau8y4KHB86jBcS2ji4gIWRGDISurSfHeucWISJ3/AAv4btobRrz4ilZVK5WJNjEoHU53PXyo9lxuOzi0QWbNbE6rbsxk48zk/fauI4dxZ70SG8aW4mBBZ3kb257fbbyp+a9lt1YQMY4l5tHkjHnjlv8A6K8jJ0uRyVym/wCP0mLKGuqnW311cPYSyx2zGZl1dncaWjJHiMEj2oXBeJy8ZW7iED2aIAgkhYBwxzkKCMYHjVYvxla2/D1ItjOQuGZiF396q+G/FKR8RR0EdtDqb8OEDc8t89Mnpis69LlONhoquDEVWrcToeM2vB+D3K3vHAJe37qyXCnW7Drgdf8AFVLr8L8VRpbO6+RmO2iVmjGfMH9qNx2yh+IZlu2vpe3iUqnJgnoCNq5HiXAr+1ikZrxpYxvnTjPrvWjpsaOBqyEP+3txFBxnzAX6K15JFMFZ4zhtEoYHwIx0x71uqaIyhw0Byw6BayvaKEbAyzIb2MtQ+hPp7+Ns74/zR3ll0COAaXO3LZR/NKRzsZRFsJX5Ej6R40/BHHENIYnqSx3NFtpthbGAQw9nHsSdTMebHzNS+dgjJzOgCjLb0hxSV9AihJUNzIGS3lVeLGKQqkIaXcAvgqp8c5pQoO5Ma6nUQSJI5fKsFG2DnH+anIwPfO2N/SkLVY7WIlVChtyEyQahxO6MVrpU96TuilA8CcPvDJKJ1UxtlW2VvEeNLXESSn8RypzlXO49/wC1QVhb9lGNlRAoxWXMUjdkEyQc5XJwc0arYGLVCbugkrvFbyI7jClt8A+PnSj9rbZRt8jZsYDYPPFatLZ54zHLbZUc2UkY8PWp8SPYtGgQgb7t+maIbu0wbg1FYbsrMUI06sYPLlvUZL2fI7xG2AUOMjNDwpkJIJbOxHT2pi/t5FRSjghRjI6VQ6Q04vTAGV73UhZi8jHUc79TWlmDyZJwefPrSzqzEt51pHdc4PlyrRpEptOghvLp1ElpcKjqRkl/q9aubTjV0blBNJHJDpxIv9Vc3a3EkMSo5TAYMr7H2pzMLFnUBBzyu4PtWDLiU7ETDmxg+JYWM8PDry4l+XLpKdvFfSsqolulKjvA++1ZSN0oc23MgcGo20Zt1WMFgO83MmiNcLGNwSeZpYnehtvJv41rq56UtLXL5mk+kbgGg2s7yNId1iz3Qf71jE9koycZoVsScgkkaqkNyTCu8sNSlQdeAdu7VZcS9vxNI2yY4hqPrTh5iq+y34hNnwqiirjRsNrYuc886ajJeNFN2wwcDbNE/P6Gq+75D1oBQdjARYlgb+Xskk7ZRyyopXiF4J4lUDBX6hjr5VMookkAUY0DpVfcfW/pQx415iIoq5BXYyjQ2nbGRVzlpIUMucEbrjOfOqaz/wDYX1q7uzpKKuw08hQz/EBJZ/ESntY48OrasjljlSU0agAggYJyAOVHjJMbb+NKKT23OnQH5xU1A8xcgocBhg1ZRzalDq6hguCMc6V0ro+kfahR9ao3cJZ9xC3FuRGskTA6jui74rKYtTiQEc6ykOUrtBrqf//Z";
//	File outputFile = new File("src//main//java//com//care//hralth//resource//image/"+"pompom."+"jpg");
//	try  {
//			 FileOutputStream  outputStream = new FileOutputStream(outputFile);		     try {
//		    	byte[] base64Decoded = DatatypeConverter.parseBase64Binary(base64Encoded);					    				
//		    	///System.out.println("decodedBytes " + base64Decoded.length);
//			outputStream.write(base64Decoded);
//		     } catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	}
//		catch (FileNotFoundException e) {	    	
//	        System.out.println(e);
//
//		}
////		
//	
		
		
//		//System.out.println("makky3");

//
	//	try{
//
    ///		File file = new File("src//main//java//com//care//hralth//resource//image//cartoon.jpg");

//    		if(file.delete()){
//    			System.out.println(file.getName() + " is deleted!");
//    		}else{
//    			System.out.println("Delete operation is failed.");
//    		}
//
//    	}catch(Exception e){
//
//    		e.printStackTrace();
//
//    	}

//		
//		
//		Blog blog1 = new Blog();
//		 blog1.setTopic("new health");
//		blog1.setTitle("pompom");
//		blog1.setDetain("sadasdasdasd");
//		blog1.setType(1);
//		blog1.setUpadtePerson("narongrit");
//		blog1.setStatus(3);
//		Image image = new Image();
//		image.setName("dog");
//		image.setType("jpg");
//		image.setBytes(data);
//		List<Image> images = new ArrayList<Image>();
//		blog1.setImage(images);
//		///Blog blog =  blogService.createBlog(blog1);
//		///main main = new main();
		//FileManament f= new FileManament();
//		System.out.println(f.getConvertToByte().length);
		
		///byte[] originalBytes = new byte[] { 1, 2, 3, 4, 5};
	///
	///	String base64Encoded = DatatypeConverter.printBase64Binary(data);
	///	System.out.println("encodedBytes " + new String(base64Encoded));
//		byte[] base64Decoded = DatatypeConverter.parseBase64Binary(base64Encoded);
//		///System.out.println("decodedBytes " + base64Decoded.length);
//		File outputFile = new File("src//main//java//com//care//hralth//resource//image//makky"+"."+"jpg");
//		try  {
//			 FileOutputStream  outputStream = new FileOutputStream(outputFile);
//		     try {
//		    	///byte[] base64Decoded = DatatypeConverter.parseBase64Binary(blog.getImage().get(i).getBytes());					    				
//		    	System.out.println("decodedBytes " + base64Decoded.length);
//				outputStream.write(base64Decoded);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		catch (FileNotFoundException e) {
//	    	
//	        System.out.println(e);
//	    }
		///byte[] encodedBytes = Base64.encodeBase64("Test".getBytes());
//		System.out.println("encodedBytes " + new String(encodedBytes));
//		byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
//		System.out.println("decodedBytes " + new String(decodedBytes));
		
		
		
//		byte[] base64Decoded = DatatypeConverter.parseBase64Binary("AQIDBAU");
//		for(int i=0;i<base64Decoded.length;i++){
//		System.out.println(base64Decoded[i]);
		///main.blogRepository.save(blog1);
	//	}
	///	System.out.println(blog.getId());
		
//		TimeZone timeZone = TimeZone.getTimeZone("UTC");
//		Calendar calendar = Calendar.getInstance(timeZone);
//		SimpleDateFormat simpleDateFormat = 		       new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy", Locale.US);
//		///simpleDateFormat.setTimeZone(timeZone);
//
//		///System.out.println("Time zone: " + timeZone.getID());
//	///	System.out.println("default time zone: " + TimeZone.getDefault().getID());
//		System.out.println();
//
//		//System.out.println("UTC:     " + simpleDateFormat.format(calendar.getTime()));
//		System.out.println("Default: " + calendar.getTime());
//		main main = new main();
//		List<String> nStrings = new ArrayList<String>();
//		nStrings.add("s");
//		main.updateHospitalDetail(nStrings);
//		for(int i=0;i< nStrings.size();i++){
//			System.out.println(nStrings.get(i));
//		}
//		Integer i =0;
//		main.updateHospitalDetail1( i);
//		System.out.println(i);
//			}
//	
//	public void updateHospitalDetail(List<String> makky){
//	makky.add("pompom");
//
//	
//	
//	}
//	public void updateHospitalDetail1(Integer i){
//		i = i+1;
//
//		
//		
	}
//		}
}
