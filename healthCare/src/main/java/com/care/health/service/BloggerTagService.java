package com.care.health.service;

import java.util.List;

import com.care.health.model.Blogger;
import com.care.health.model.BloggerTag;

public interface BloggerTagService {
	public BloggerTag createBloggerTag(BloggerTag bloggerTag);
    public BloggerTag updateBloggerTag(BloggerTag bloggerTag);
    public void removeBloggerTag(BloggerTag bloggerTag);
    public List<BloggerTag> getAllBloggerTag();
    public BloggerTag getBloggerTagById(String id);

}
