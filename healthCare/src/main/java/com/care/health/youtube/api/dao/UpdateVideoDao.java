package com.care.health.youtube.api.dao;

import com.care.health.model.YoutubeVideo;
import com.google.api.services.youtube.model.Video;

public interface UpdateVideoDao {
	public YoutubeVideo updateVideo(YoutubeVideo youtubeVideo);
}
