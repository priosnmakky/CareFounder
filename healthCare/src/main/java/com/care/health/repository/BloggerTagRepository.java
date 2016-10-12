package com.care.health.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.care.health.model.Blogger;
import com.care.health.model.BloggerTag;

@Repository
public interface BloggerTagRepository extends MongoRepository<BloggerTag, String>{
	BloggerTag findByName(String name);	
}


