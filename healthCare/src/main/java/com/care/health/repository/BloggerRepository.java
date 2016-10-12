package com.care.health.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.care.health.model.Blogger;
import com.care.health.model.BloggerTag;

@Repository
public interface BloggerRepository extends MongoRepository<Blogger, String>{
	List<Blogger> findByStatus(int status);
	List<Blogger> findByTagName(String name);	
}
