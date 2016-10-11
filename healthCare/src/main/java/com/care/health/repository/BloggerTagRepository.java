package com.care.health.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.care.health.model.BloggerTag;

@Repository
public interface BloggerTagRepository extends MongoRepository<BloggerTag, String>{
	
}


