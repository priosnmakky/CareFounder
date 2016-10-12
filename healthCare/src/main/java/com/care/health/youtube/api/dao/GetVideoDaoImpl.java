package com.care.health.youtube.api.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.care.health.model.YoutubeVideo;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.sample.youtube.Auth;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import com.google.common.collect.Lists;
@Repository
public class GetVideoDaoImpl implements GetVideoDao {
	private static YouTube youtube;

	 public YoutubeVideo getVideo(YoutubeVideo youtubeVideo){
		 // This OAuth 2.0 access scope allows for full read/write access to the
	        // authenticated user's account.
	    	 YoutubeVideo returnYoutubeVideo = new YoutubeVideo();
	  
	    
	        List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube");
	       /// Video videoResponse = null;
	        System.out.println("makky1");
	        try {
	            // Authorize the request.
	            Credential credential = Auth.authorize(scopes, "updatevideo");

	            // This object is used to make YouTube Data API requests.
	            youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential)
	                    .setApplicationName("youtube-cmdline-updatevideo-sample").build();

	            // Prompt the user to enter the video ID of the video being updated.
	            System.out.println("makky2");
	            String videoId = youtubeVideo.getId();
	            System.out.println("You chose " + videoId + " to update.");

	            // Prompt the user to enter a keyword tag to add to the video.
	           // String tag = getTagFromUser();
	            ///System.out.println("You chose " + tag + " as a tag.");

	            // Call the YouTube Data API's youtube.videos.list method to
	            // retrieve the resource that represents the specified video.
	            YouTube.Videos.List listVideosRequest = youtube.videos().list("snippet").setId(videoId);
	            VideoListResponse listResponse = listVideosRequest.execute();

	            // Since the API request specified a unique video ID, the API
	            // response should return exactly one video. If the response does
	            // not contain a video, then the specified video ID was not found.
	            List<Video>  videoList = listResponse.getItems();
	            if (videoList.isEmpty()) {
	                System.out.println("Can't find a video with ID: " + videoId);
	               return null;
	            }
	            else{
	            	returnYoutubeVideo.setId(videoList.get(0).getId());
	                returnYoutubeVideo.setTitle(videoList.get(0).getSnippet().getTitle());
	                returnYoutubeVideo.setTag(videoList.get(0).getSnippet().getTags());
	                returnYoutubeVideo.setDescription(videoList.get(0).getSnippet().getDescription());
	                returnYoutubeVideo.setPrivacyStatus(videoList.get(0).getStatus().getPrivacyStatus());
	                returnYoutubeVideo.setViewCount(videoList.get(0).getStatistics().getViewCount());	
	                return returnYoutubeVideo;
	            }
	            
	            
	        } catch (GoogleJsonResponseException e) {
	            System.err.println("GoogleJsonResponseException code: " + e.getDetails().getCode() + " : "
	                    + e.getDetails().getMessage());
	            e.printStackTrace();
	            return null;
	        } catch (IOException e) {
	            System.err.println("IOException: " + e.getMessage());
	            e.printStackTrace();
	            return null;
	        } catch (Throwable t) {
	            System.err.println("Throwable: " + t.getMessage());
	            t.printStackTrace();
	            return null;
	        }
	       
	 }
}
