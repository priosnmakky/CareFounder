package com.care.health.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.care.health.model.Blogger;
import com.care.health.model.BloggerTag;
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
			return bloggerRepository.findOne(id);
	        }catch (Exception e){
	         return null;
	        }
		
	}
	@Transactional
	public List<Blogger> getAllBlogger() {
		// TODO Auto-generated method stub
		try{
			return bloggerRepository.findByStatus(1);
		}
		catch (Exception e){
			// TODO: handle exception
			return null;
		}
		
	}
	@Transactional
	public Blogger getBloggerById(String id) {
		// TODO Auto-generated method stub
		try{
		return bloggerRepository.findOne(id);
		}
		catch (Exception e){
			return null;
		}
	}
	@Transactional
	public List<Blogger> getBloggerByTagName(String name) {
		// TODO Auto-generated method stub
		try{
			return bloggerRepository.findByTagName(name);
			}
			catch (Exception e){
				return null;
			}
		
	}

}
