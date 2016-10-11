package com.care.health.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.care.health.model.YoutubeVideo;

public interface YoutubeVideoService {
	public YoutubeVideo createYoutueVideo(String part,YoutubeVideo youtubeVideo)throws IOException  ;
}
