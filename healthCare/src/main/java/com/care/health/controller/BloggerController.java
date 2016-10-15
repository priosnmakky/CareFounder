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
import javax.swing.text.html.HTML.Tag;
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
import com.care.health.model.BloggerTag;
import com.care.health.model.Employee;
import com.care.health.model.HospitalDetail;
import com.care.health.model.Image;
import com.care.health.model.YoutubeVideo;
import com.care.health.service.BloggerService;
import com.care.health.service.BloggerTagService;
import com.care.health.service.ImageService;
import com.care.health.service.YoutubeVideoService;
import com.care.health.youtube.api.dao.DeleteVideoDaoImpl;
import com.care.health.youtube.api.dao.UpdateVideoDaoImpl;
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
	@Autowired
	BloggerTagService bloggerTagService;
	SimpleDateFormat simpleDateFormat =new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy");
	
//	Authentication authentication = SecurityContextHolder.getContext()
//		    .getAuthentication();
	
	UploadVideoDaoImpl uploadVideo = new UploadVideoDaoImpl();
	
	UpdateVideoDaoImpl updateVideo = new UpdateVideoDaoImpl();
	DeleteVideoDaoImpl deleteVideo = new DeleteVideoDaoImpl();

	@RequestMapping(value = "/drummy",method = RequestMethod.GET)
	public @ResponseBody Blogger getDrummy(){
		Blogger b= new Blogger();
		
//		b.setTitle("บทความ");
//	/////	b.setDetain("i am detain");
		Image image = new Image();
		image.setId("ID-01");
		///image.setName("makky")
		image.setType("sadada");
		image.setByteOrpart("cdzxczczxcz");
		Image image1 = new Image();
		image1.setId("id-02");
		image1.setByteOrpart("mmaerfgg");
		List<Image> images = new ArrayList<Image>();
		images.add(image);
		images.add(image1);
		b.setImages(image1);
		List<BloggerTag> bloggerTags = new ArrayList<BloggerTag>();
		BloggerTag bloggerTag = new BloggerTag();
		bloggerTag.setName("mmak");
		bloggerTags.add(bloggerTag);
		b.setTag( bloggerTags );
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
		blogger.setViewCount(0);
		///blogger.setImages(null);
		if(null!=blogger.getTag()){
			blogger.setTag(addTag(blogger.getTag()));
		}
		///blogger.getYoutubeVideo().setByteOrpart(test);
		if(blogger.getType()==1||blogger.getType()==2){	
			if(null!=blogger.getImages()&&null!=blogger.getImages().getByteOrpart()){
				String part = context.getRealPath("")+"WEB-INF\\resources\\images\\Blogger\\";
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
				blogger.setImages(null);
				return bloggerService.updateBlogger(blogger);
			}
			
		}
		if(blogger.getType()==3){
			if(null!=blogger.getYoutubeVideo()&&null!=blogger.getYoutubeVideo().getByteOrpart()){
				blogger.setImages(null);
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
		blogger.setUpdateDate(getCurrentTime());
		if(null!=blogger.getTag()){
			blogger.setTag(upadteTag(blogger.getTag()));
			
		}
		if(blogger.getType()==1||blogger.getType()==2){
			blogger.setUpdateDate(getCurrentTime());
			if(null!=blogger.getImages()&&null!=blogger.getImages().getByteOrpart()){
				String part = context.getRealPath("")+"WEB-INF\\resource\\image\\Blogger\\";
				Blogger getBlogger  = bloggerService.getBloggerById(blogger.getId());
				imageService.removeImage(getBlogger.getImages()); 
				blogger.getImages().setId(blogger.getId());
				Image image = imageService.createImage(part,blogger.getImages());
				blogger.setImages(image);
				return bloggerService.updateBlogger(blogger);
				
			}
			else{
				blogger.setImages(null);
				return bloggerService.updateBlogger(blogger);
				
			}


		}
		else if(blogger.getType()==3){
			    blogger.setImages(null);
				YoutubeVideo youtubeVideo = youtubeVideoService.updateYoutubeVide(blogger.getYoutubeVideo());
				blogger.setYoutubeVideo(youtubeVideo);
				return bloggerService.updateBlogger(blogger);
			
			}
		
		return null;
	}
	
	
	@RequestMapping(value = "/remove/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody Blogger  deleteBlog(@PathVariable("id") String id){
		Blogger blogger =bloggerService.getBloggerById(id);
		Blogger returnBlogger =  bloggerService.removeBlogger(blogger);
		if(blogger.getType()==1||blogger.getType()==2){
		if(null!=returnBlogger&&null!=returnBlogger.getImages()&&null!=returnBlogger.getImages().getByteOrpart()){
			imageService.removeImage(blogger.getImages()); 
		}
		
		}
		else if(blogger.getType()==3){
			youtubeVideoService.removeYoutubeVideo(blogger.getYoutubeVideo());
		}

		
		return returnBlogger;
		
	}
	 @RequestMapping(value = "/list",method = RequestMethod.GET)
	    public @ResponseBody List<Blogger> getAllBlogger() throws IOException{
		 List<Blogger> bloggers =bloggerService.getAllBlogger();
		 for(int i=0;i<bloggers.size();i++){
			 List<BloggerTag> tags = new ArrayList<BloggerTag>();
			 if(bloggers.get(i).getType()==1||bloggers.get(i).getType()==2){
				 if(null!=bloggers.get(i).getImages())
				 bloggers.get(i).setImages(imageService.getImagefile(bloggers.get(i).getImages()));
			 }
			 if(null!=bloggers.get(i).getTag()){
				for(int x=0;x<bloggers.get(i).getTag().size();x++){
					tags.add(bloggerTagService.getBloggerTagById(bloggers.get(i).getTag().get(x).getId()));
				} 
			 }
			 bloggers.get(i).setTag(tags);
					
		 }
		 return bloggers;

	    }

	 
	 @RequestMapping(value = "/tag/{id}",method = RequestMethod.POST)
	    public @ResponseBody List<Blogger> getBloggerFromTag(@PathVariable("id") String id) throws IOException{
		 return bloggerService.getBloggerByTagName(bloggerTagService.getBloggerTagById(id).getName());

	    }
	 
	 @RequestMapping(value = "/viewCount/{id}",method = RequestMethod.POST)
	    public @ResponseBody Blogger addViewCount(@PathVariable("id") String id) throws IOException{
		 Blogger blogger = bloggerService.getBloggerById(id);
		 blogger.setViewCount(blogger.getViewCount()+1);
		 System.out.println(blogger.getViewCount());
		 bloggerService.updateBlogger(blogger);
		 return blogger;

	    }
	 public List<BloggerTag> addTag(List<BloggerTag> bloggerTags){
		 Date current = getCurrentTime();
		 for(int i=0;i<bloggerTags.size();i++){
		 bloggerTags.get(i).setCreateDate(current);
	     BloggerTag bloggerTag = bloggerTagService.getBloggerTagByName(bloggerTags.get(i).getName());
		 if(null!=bloggerTag){
			 BloggerTag	bloggerTagById =  bloggerTagService.getBloggerTagById(bloggerTag.getId());
			 bloggerTags.set(i, bloggerTagById);
			 bloggerTags.get(i).setCreateDate(null);
			 bloggerTags.get(i).setCreatePerson(null);
		 }
		 else{
			 bloggerTags.set(i, bloggerTagService.createBloggerTag(bloggerTags.get(i)));
			 bloggerTags.get(i).setCreateDate(null);
			 bloggerTags.get(i).setCreatePerson(null);
		 }
		 }	

		 return bloggerTags;
		    
		}

	 public List<BloggerTag> upadteTag(List<BloggerTag> bloggerTags){
		 Date current = getCurrentTime();
		 for(int i=0;i<bloggerTags.size();i++){
			
			 BloggerTag bloggerTag = bloggerTagService.getBloggerTagByName(bloggerTags.get(i).getName());
			 if(null!=bloggerTag){
				 BloggerTag	bloggerTagById =  bloggerTagService.getBloggerTagById(bloggerTag.getId());
				 bloggerTags.set(i, bloggerTagById);
				 bloggerTags.get(i).setCreateDate(null);
				 bloggerTags.get(i).setCreatePerson(null);
			 }
			 else{
				 bloggerTags.get(i).setCreateDate(current);
				 bloggerTags.set(i, bloggerTagService.createBloggerTag(bloggerTags.get(i)));
				 bloggerTags.get(i).setCreateDate(null);
				 bloggerTags.get(i).setCreatePerson(null);
			 }
			 }	
		
			
		 return bloggerTags;
		    
		}
		public Date getCurrentTime(){
			TimeZone timeZone = TimeZone.getTimeZone("UTC");
			Calendar calendar = Calendar.getInstance(timeZone);
			SimpleDateFormat simpleDateFormat =new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy");
			
			return calendar.getTime();
			
		}
	
}
