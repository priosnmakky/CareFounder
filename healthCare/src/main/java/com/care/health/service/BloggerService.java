package com.care.health.service;

import java.util.List;

import com.care.health.model.Blogger;
import com.care.health.model.BloggerTag;

public interface BloggerService {
	public Blogger createBlogger(Blogger blogger);
    public Blogger updateBlogger(Blogger blogger);
    public Blogger removeBlogger(Blogger blogger);
    public List<Blogger> getAllBlogger();
    public Blogger getBloggerById(String id);
    public List<Blogger> getBloggerByTagName(String name);
}