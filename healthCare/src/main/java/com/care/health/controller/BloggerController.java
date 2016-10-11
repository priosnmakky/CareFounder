package com.care.health.controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.servlet.ServletContext;
import javax.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.api.services.youtube.YouTube.Videos.Delete;
import com.google.api.services.youtube.model.Video;
import com.care.health.model.Blogger;
import com.care.health.model.Employee;
import com.care.health.model.Image;
import com.care.health.model.YoutubeVideo;
import com.care.health.service.BloggerService;
import com.care.health.service.ImageService;
import com.care.health.service.YoutubeVideoService;
import com.care.health.youtube.api.dao.DeleteVideo;
import com.care.health.youtube.api.dao.UpdateVideo;
import com.care.health.youtube.api.dao.UploadVideoDaoImpl;

@Controller
@RequestMapping("blogger")
public class BloggerController {
	
	@Autowired
	private BloggerService bloggerService;
	@Autowired
    ServletContext context; 
	@Autowired
	ImageService imageService;
	@Autowired
	YoutubeVideoService youtubeVideoService;
	SimpleDateFormat simpleDateFormat =new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy");
	
//	Authentication authentication = SecurityContextHolder.getContext()
//		    .getAuthentication();
	
	UploadVideoDaoImpl uploadVideo = new UploadVideoDaoImpl();
	
	UpdateVideo updateVideo = new UpdateVideo();
	DeleteVideo deleteVideo = new DeleteVideo();

	@RequestMapping(value = "/drummy",method = RequestMethod.GET)
	public @ResponseBody Blogger getDrummy(){
		Blogger b= new Blogger();
		
//		b.setTitle("บทความ");
//	/////	b.setDetain("i am detain");
		Image image = new Image();
		image.setId("ID-01");
		///image.setName("makky")
		;		image.setType("sadada");
		image.setByteOrpart("cdzxczczxcz");
		Image image1 = new Image();
		image1.setId("id-02");
		image1.setByteOrpart("mmaerfgg");
		List<Image> images = new ArrayList<Image>();
		images.add(image);
		images.add(image1);
		b.setImages(image1);
		YoutubeVideo y = new YoutubeVideo();
		List<String> tag = new ArrayList<String>();
		tag.add("test");
		y.setTag(tag);
		y.setTitle("makky");
		y.setDescription("dfsdf");
		y.setPrivacyStatus("PUBLIC");
		b.setYoutubeVideo(y);
		b.setReference("narongrit saisuwan");
		b.setAuthor("dfvdvdvdv");
		b.setCreatePerson("mmmmmmmmm");
		b.setCreateDate(new Date(0));
		b.setUpdateDate(new Date(0));
		b.setUpdatePerson("fsfddsfsf");
		
		return  b;
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public @ResponseBody Blogger addBlogger(@RequestBody Blogger blogger) throws IOException{
		blogger.setStatus(1);
		blogger.setCreateDate(getCurrentTime());
		blogger.getYoutubeVideo().setByteOrpart(test);
		if(blogger.getType()==1||blogger.getType()==2){	
			if(null!=blogger.getImages()&&null!=blogger.getImages().getByteOrpart()){
				String part = context.getRealPath("")+"WEB-INF\\resource\\image\\Blogger\\";
				System.out.println(part);
				Image image = blogger.getImages();
				blogger.setImages(null);
				String imageId = bloggerService.createBlogger(blogger).getId();
				image.setId(imageId);
				Image returnImage = imageService.createImage(part, image);
				blogger.setImages(returnImage);
				System.out.println("vcvcv1");
				return bloggerService.updateBlogger(blogger);
				
			}
			else{
				System.out.println("vcvcv2");
				return bloggerService.updateBlogger(blogger);
			}
			
		}
		if(blogger.getType()==3){
			if(null!=blogger.getYoutubeVideo()&&null!=blogger.getYoutubeVideo().getByteOrpart()){
				String part = context.getRealPath("")+"WEB-INF\\resource\\Video\\Youtube\\";
				YoutubeVideo youtubeVideo = blogger.getYoutubeVideo();
				blogger.setYoutubeVideo(null);
				String youtubeVideoId = bloggerService.createBlogger(blogger).getId();
				youtubeVideo.setId(youtubeVideoId);
				YoutubeVideo returnVideo = youtubeVideoService.createYoutueVideo(part, youtubeVideo);
				blogger.setYoutubeVideo(returnVideo);
				System.out.println("vcvcv3");
				return bloggerService.updateBlogger(blogger);
			}
			else{
				System.out.println("vcvcv4");
				return bloggerService.updateBlogger(blogger);
			}

		}
		

		return null;

	}
	
	
	
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public  @ResponseBody Blogger  updateBlog(@RequestBody Blogger blogger) throws IOException{

		
		if(blogger.getType()==1||blogger.getType()==2){
			blogger.setUpdateDate(getCurrentTime());
			if(null!=blogger.getImages()&&null!=blogger.getImages().getByteOrpart()){
				String part = context.getRealPath("")+"WEB-INF\\resource\\image\\Employee\\";
				Blogger getBlogger  = bloggerService.getBloggerById(blogger.getId());
				imageService.removeImage(getBlogger.getImages()); 
				blogger.getImages().setId(blogger.getId());
				Image image = imageService.createImage(part,blogger.getImages());
				blogger.setImages(image);
				return bloggerService.updateBlogger(blogger);
				
			}
			else{
				return bloggerService.updateBlogger(blogger);
				
			}


		}
		else if(blogger.getType()==3){
			if(null!=blogger.getYoutubeVideo()){
				updateVideo.getUpdateVideo(blogger.getYoutubeVideo());
				}
		}
		
		if(null!=blogger.getYoutubeVideo()){
		updateVideo.getUpdateVideo(blogger.getYoutubeVideo());
		}
		return bloggerService.updateBlogger(blogger);
	}
	
	
	@RequestMapping(value = "/remove/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody Blogger  deleteBlog(@PathVariable("id") String id){
		Blogger blogger = bloggerService.getBloggerById(id);
		if(blogger.getType()==1||blogger.getType()==2){
			if(null!=blogger.getImages()&&null!=blogger.getImages().getByteOrpart()){
				String part = context.getRealPath("")+"WEB-INF\\resource\\image\\Blogger\\";
				imageService.removeImage(blogger.getImages()); 
				return bloggerService.removeBlogger(blogger);
			}
			else{
				return bloggerService.removeBlogger(blogger);
			}
		}
		if(blogger.getType()==3){
			deleteVideo.deleteVideo(blogger.getYoutubeVideo());
			return bloggerService.removeBlogger(blogger);
		}
		
		return null;
		
	}
	 @RequestMapping(value = "/list",method = RequestMethod.GET)
	    public @ResponseBody List<Blogger> getAllBlogger(){
		 
		 
		 
//		 Authentication authentication = SecurityContextHolder.getContext()
//				    .getAuthentication();
//		 System.out.println(authentication.getName());
//		 List<Blogger> returnallBlogger = bloggerService.getAllBlogger();
//			String pathImage = "WEB-INF\\resource\\image\\";
//			String uploadPath = context.getRealPath("");
//		 for(int i=0;i<returnallBlogger.size();i++){
//			 if(returnallBlogger.get(i).getType()==1||returnallBlogger.get(i).getType()==2){
//				 for(int x =0;x<returnallBlogger.get(i).getImages().size();x++){
//						Path path = Paths.get(uploadPath+pathImage+returnallBlogger.get(i).getImages().get(x).getId());
//						byte[] data =null;
//							try {
//							data = Files.readAllBytes(path);
//
//							} catch (IOException e) {
//							// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//
//							String base64Encoded = DatatypeConverter.printBase64Binary(data);
//							///System.out.print(base64Encoded);
//					 returnallBlogger.get(i).getImages().get(x).setByteOrpart(base64Encoded);
//				 }
//			 
//		 }
//		 }
//	        return returnallBlogger;
	    }

	

		public Blogger getCreateVideo(Blogger blogger){
			Blogger returnBlogger = new Blogger();
			String uploadPath = context.getRealPath("");
			String pathVideo = "WEB-INF\\resource\\video\\";
			String videoByte = blogger.getYoutubeVideo().getBytes();
			blogger.getYoutubeVideo().setBytes("");
			Blogger createBlogger =  bloggerService.createBlogger(blogger);
			String [] typeOfFile = createBlogger.getYoutubeVideo().getName().split("\\.");
			if(null!=createBlogger&&null != createBlogger.getYoutubeVideo()&&null!= createBlogger.getYoutubeVideo().getBytes()){
				File outputFile = new File(uploadPath+pathVideo+createBlogger.getId()+"."+typeOfFile[0]);
				try  {
					 FileOutputStream  outputStream = new FileOutputStream(outputFile);
				     try {
				    	byte[] base64Decoded = DatatypeConverter.parseBase64Binary(videoByte);					    				
				    	System.out.println("decodedBytes " + base64Decoded.length);
						outputStream.write(base64Decoded);
						
						
						YoutubeVideo uplodvideo =uploadVideo.createVideoYoutube(uploadPath+pathVideo+createBlogger.getId()+"."+typeOfFile[0],createBlogger.getYoutubeVideo());
						deleteVideo(uploadPath+pathVideo+createBlogger.getId()+"."+typeOfFile[0]);
						uplodvideo.setBytes("");
						createBlogger.setYoutubeVideo(uplodvideo);
						returnBlogger =bloggerService.createBlogger(createBlogger);
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
			

				    } catch (FileNotFoundException e) {
				    	
				        System.out.println(e);
				    }	
			}
			
			return returnBlogger;
		}
		public void deleteVideo(String part){

			try{
		    		File file = new File(part);
	
	    		if(file.delete()){
	    			System.out.println(file.getName() + " is deleted!");
    		}else{
	    			System.out.println("Delete operation is failed.");
	    		}
	
	    	}catch(Exception e){
	
	    		e.printStackTrace();
	
	    	}
		}
		public void deleteImage(Blogger blogger){
			String pathImage = "WEB-INF\\resource\\image\\";
			String uploadPath = context.getRealPath("");
			Blogger oldBlogger = bloggerService.getBloggerById(blogger.getId());
			if(null!=oldBlogger.getImages()){
				for(int i=0;i<oldBlogger.getImages().size();i++){
					try{
						File file = new File(uploadPath+pathImage+oldBlogger.getImages().get(i).getId()+"."+oldBlogger.getImages().get(i).getType());
						
						if(file.delete()){
						   System.out.println(file.getName() + " is deleted!");
						}else{
						   System.out.println("Delete operation is failed.");
						    }
						
						}catch(Exception e){
						
						  e.printStackTrace();
						
						}

						
				}
			}
		}
		public Blogger UpdateImage(Blogger blogger){
			Blogger returnBlogger = new Blogger();
			
			String pathImage = "WEB-INF\\resource\\image\\";
			String uploadPath = context.getRealPath("");
			if(null!=blogger.getImages()){
				for(int i=0;i<blogger.getImages().size();i++){
					if(null!=blogger.getImages().get(i).getByteOrpart()){
						///blog.getImage().get(i).setBytes(null);
						File outputFile = new File(uploadPath+pathImage+blogger.getId()+i+"."+blogger.getImages().get(i).getType());
						blogger.getImages().get(i).setId(blogger.getId()+i);
						blogger.getImages().get(i).setByteOrpart("");
						System.out.println("path :"+uploadPath+pathImage);

						try  {
								 FileOutputStream  outputStream = new FileOutputStream(outputFile);
							     try {
							    	byte[] base64Decoded = DatatypeConverter.parseBase64Binary(blogger.getImages().get(i).getByteOrpart());					    				
							    	System.out.println("decodedBytes image " + base64Decoded);
									outputStream.write(base64Decoded);
									blogger.setUpdateDate(getCurrentTime());
									returnBlogger = bloggerService.updateBlogger(blogger);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
									
						

							    } catch (FileNotFoundException e) {
							    	
							        System.out.println(e);
							    }			
					}
				}
				
				
			}
			
			return returnBlogger;
		}
		
		public Date getCurrentTime(){
			TimeZone timeZone = TimeZone.getTimeZone("UTC");
			Calendar calendar = Calendar.getInstance(timeZone);
			SimpleDateFormat simpleDateFormat =new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy");
			
			return calendar.getTime();
			
		}
	
}