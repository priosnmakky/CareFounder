package com.care.health.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.health.model.BloggerTag;
import com.care.health.repository.BloggerRepository;
import com.care.health.repository.BloggerTagRepository;
@Service
public class BloggerTagServiceImpl implements BloggerTagService{
	@Autowired
	BloggerTagRepository bloggerTagRepository;
	public BloggerTag createBloggerTag(BloggerTag bloggerTag) {
		// TODO Auto-generated method stub
		 try{
			  return bloggerTagRepository.save(bloggerTag);

	        }catch (Exception e){
	            e.printStackTrace();
	            return null;
	        }
	}

	public BloggerTag updateBloggerTag(BloggerTag bloggerTag) {
		// TODO Auto-generated method stub
	     try{
	            return bloggerTagRepository.save(bloggerTag);
	        }catch (Exception e){
	            return null;
	        }
		
	}

	public void removeBloggerTag(BloggerTag bloggerTag) {
		// TODO Auto-generated method stub
		try{
		     bloggerTagRepository.delete(bloggerTag);

	        }catch (Exception e){
	         
	        }
	}

	public List<BloggerTag> getAllBloggerTag() {
		// TODO Auto-generated method stub
		try{
		   return  bloggerTagRepository.findAll();

	       }catch (Exception e){
	         return null;
	        }
	}

	public BloggerTag getBloggerTagById(String id) {
		// TODO Auto-generated method stub
		try{
			   return  bloggerTagRepository.findOne(id);

		       }catch (Exception e){
		         return null;
		        }

	}

}
