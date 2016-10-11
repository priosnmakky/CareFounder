package com.care.health.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.care.health.model.Blogger;
import com.care.health.repository.BloggerRepository;

@Service
public class BloggerServiceImpl implements BloggerService{
	@Autowired
	BloggerRepository bloggerRepository;
	@Transactional
	public Blogger createBlogger(Blogger blogger) {
		// TODO Auto-generated method stub
		 try{
			  return bloggerRepository.save(blogger);

	        }catch (Exception e){
	            e.printStackTrace();
	            return null;
	        }
		
	}
	@Transactional
	public Blogger updateBlogger(Blogger blogger) {
		// TODO Auto-generated method stub
	
	        try{
	            return bloggerRepository.save(blogger);
	        }catch (Exception e){
	            return null;
	        }
		
	}
	@Transactional
	public Blogger removeBlogger(Blogger blogger) {
		// TODO Auto-generated method stub
		try{
			String id = blogger.getId();
			bloggerRepository.delete(blogger);
			return null;
	        }catch (Exception e){
	         return null;
	        }
		
	}
	@Transactional
	public List<Blogger> getAllBlogger() {
		// TODO Auto-generated method stub
		
		return bloggerRepository.findByStatus(1);
		
	}
	@Transactional
	public Blogger getBloggerById(String id) {
		// TODO Auto-generated method stub
		return bloggerRepository.findOne(id);
	}

}
