package com.care.health.youtube.api.dao;

import java.io.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;

import com.care.health.model.YoutubeVideo;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.java6.auth.oauth2.FileCredentialStore;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sample.youtube.Auth;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoSnippet;
import com.google.api.services.youtube.model.VideoStatus;
import com.google.common.collect.Lists;

/**
 * Demo of uploading a video to a user's account using the YouTube Data API (V3) with OAuth2 for
 * authorization.
 *
 *  TODO: PLEASE NOTE, YOU MUST ADD YOUR VIDEO FILES TO THE PROJECT FOLDER TO UPLOAD THEM WITH THIS
 * APPLICATION!
 *
 * @author Jeremy Walker
 */
@Repository
public class UploadVideoDaoImpl implements UploadVideoDao {

    /** Global instance of the HTTP transport. */
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();

    /** Global instance of Youtube object to make all API requests. */
    private static YouTube youtube;

    /* Global instance of the format used for the video being uploaded (MIME type). */
    private static String VIDEO_FILE_FORMAT = "video/*";

    /**
     * Authorizes the installed application to access user's protected data.
     *
     * @param scopes list of scopes needed to run youtube upload.
     */
   

    /**
     * Uploads user selected video in the project folder to the user's YouTube account using OAuth2
     * for authentication.
     *
     * @param args command line args (not used).
     */
    
    public YoutubeVideo createVideoYoutube(YoutubeVideo youtubeVideo){
    	
    	
    	YoutubeVideo returnYoutubeVideo = new YoutubeVideo();
    	// Scope required to upload to YouTube.
        List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube.upload");
        Video returnedVideo = null;
        try {
            // Authorization.
        	Credential credential = Auth.authorize(scopes, "uploadvideo");

            // YouTube object used to make all API requests.
            youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(
                    "youtube-cmdline-uploadvideo-sample").build();

            // We get the user selected local video file to upload.
            File videoFile = getLocalVideoFiles(youtubeVideo.getByteOrpart());
            System.out.println("You chose " + videoFile + " to upload.");

            // Add extra information to the video before uploading.
            Video videoObjectDefiningMetadata = new Video();

      /*
       * Set the video to public, so it is available to everyone (what most people want). This is
       * actually the default, but I wanted you to see what it looked like in case you need to set
       * it to "unlisted" or "private" via API.
       */
            VideoStatus status = new VideoStatus();
            status.setPrivacyStatus(youtubeVideo.getPrivacyStatus());
            videoObjectDefiningMetadata.setStatus(status);

            // We set a majority of the metadata with the VideoSnippet object.
            VideoSnippet snippet = new VideoSnippet();

      /*
       * The Calendar instance is used to create a unique name and description for test purposes, so
       * you can see multiple files being uploaded. You will want to remove this from your project
       * and use your own standard names.
       */
            Calendar cal = Calendar.getInstance();
            snippet.setTitle(youtubeVideo.getTitle());
            snippet.setDescription(youtubeVideo.getDescription());

            // Set your keywords.
          
            snippet.setTags(youtubeVideo.getTag());

            // Set completed snippet to the video object.
            videoObjectDefiningMetadata.setSnippet(snippet);

            InputStreamContent mediaContent = new InputStreamContent(
                    VIDEO_FILE_FORMAT, new BufferedInputStream(new FileInputStream(videoFile)));
            mediaContent.setLength(videoFile.length());
           /// mediaContent.

      /*
       * The upload command includes: 1. Information we want returned after file is successfully
       * uploaded. 2. Metadata we want associated with the uploaded video. 3. Video file itself.
       */
            YouTube.Videos.Insert videoInsert = youtube.videos()
                    .insert("snippet,statistics,status", videoObjectDefiningMetadata, mediaContent);

            // Set the upload type and add event listener.
            MediaHttpUploader uploader = videoInsert.getMediaHttpUploader();

      /*
       * Sets whether direct media upload is enabled or disabled. True = whole media content is
       * uploaded in a single request. False (default) = resumable media upload protocol to upload
       * in data chunks.
       */
            uploader.setDirectUploadEnabled(false);

            MediaHttpUploaderProgressListener progressListener = new MediaHttpUploaderProgressListener() {
                public void progressChanged(MediaHttpUploader uploader) throws IOException {
                    switch (uploader.getUploadState()) {
                        case INITIATION_STARTED:
                            System.out.println("Initiation Started");
                            break;
                        case INITIATION_COMPLETE:
                            System.out.println("Initiation Completed");
                            System.out.print(uploader.getUploadState());
                            break;
                        case MEDIA_IN_PROGRESS:
                            System.out.println("Upload in progress");
                            System.out.println("Upload percentage: " + uploader.getProgress());
                            break;
                        case MEDIA_COMPLETE:
                            System.out.println("Upload Completed!");
                            break;
                        case NOT_STARTED:
                            System.out.println("Upload Not Started!");
                            break;
                    }
                }
            };
            uploader.setProgressListener(progressListener);

            // Execute upload.
            returnedVideo = videoInsert.execute();

            // Print out returned results.
            System.out.println("\n================== Returned Video ==================\n");
            System.out.println("  - Id: " + returnedVideo.getId());
            System.out.println("  - Title: " + returnedVideo.getSnippet().getTitle());
            System.out.println("  - Tags: " + returnedVideo.getSnippet().getTags());
            System.out.println("  - Privacy Status: " + returnedVideo.getStatus().getPrivacyStatus());
            System.out.println("  - Video Count: " + returnedVideo.getStatistics().getViewCount());
            
            
            returnYoutubeVideo.setId(returnedVideo.getId());
            returnYoutubeVideo.setTitle(returnedVideo.getSnippet().getTitle());
            returnYoutubeVideo.setTag(returnedVideo.getSnippet().getTags());
            returnYoutubeVideo.setDescription(returnedVideo.getSnippet().getDescription());
            returnYoutubeVideo.setPrivacyStatus(returnedVideo.getStatus().getPrivacyStatus());
            returnYoutubeVideo.setViewCount(returnedVideo.getStatistics().getViewCount());
        } catch (GoogleJsonResponseException e) {
            System.err.println("GoogleJsonResponseException code: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            e.printStackTrace();
        } catch (Throwable t) {
            System.err.println("Throwable: " + t.getMessage());
            t.printStackTrace();
        }
    	return returnYoutubeVideo;
    }
    public static void main(String[] args) {

        // Scope required to upload to YouTube.
        List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube.upload");

        try {
            // Authorization.
        	Credential credential = Auth.authorize(scopes, "uploadvideo");

            // YouTube object used to make all API requests.
            youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(
                    "youtube-cmdline-uploadvideo-sample").build();

            // We get the user selected local video file to upload.
            File videoFile = getVideoFromUser("src//main//java//com//care//hralth//resource//image//titanic.mp4");
            System.out.println("You chose " + videoFile + " to upload.");

            // Add extra information to the video before uploading.
            Video videoObjectDefiningMetadata = new Video();

      /*
       * Set the video to public, so it is available to everyone (what most people want). This is
       * actually the default, but I wanted you to see what it looked like in case you need to set
       * it to "unlisted" or "private" via API.
       */
            VideoStatus status = new VideoStatus();
            status.setPrivacyStatus("public");
            videoObjectDefiningMetadata.setStatus(status);

            // We set a majority of the metadata with the VideoSnippet object.
            VideoSnippet snippet = new VideoSnippet();

      /*
       * The Calendar instance is used to create a unique name and description for test purposes, so
       * you can see multiple files being uploaded. You will want to remove this from your project
       * and use your own standard names.
       */
            Calendar cal = Calendar.getInstance();
            snippet.setTitle("Test Upload via Java on " + cal.getTime());
            snippet.setDescription(
                    "Video uploaded via YouTube Data API V3 using the Java library " + "on " + cal.getTime());

            // Set your keywords.
            List<String> tags = new ArrayList<String>();
            tags.add("test");
            tags.add("example");
            tags.add("java");
            tags.add("YouTube Data API V3");
            tags.add("erase me");
            snippet.setTags(tags);

            // Set completed snippet to the video object.
            videoObjectDefiningMetadata.setSnippet(snippet);

            InputStreamContent mediaContent = new InputStreamContent(
                    VIDEO_FILE_FORMAT, new BufferedInputStream(new FileInputStream(videoFile)));
            mediaContent.setLength(videoFile.length());
           /// mediaContent.

      /*
       * The upload command includes: 1. Information we want returned after file is successfully
       * uploaded. 2. Metadata we want associated with the uploaded video. 3. Video file itself.
       */
            YouTube.Videos.Insert videoInsert = youtube.videos()
                    .insert("snippet,statistics,status", videoObjectDefiningMetadata, mediaContent);

            // Set the upload type and add event listener.
            MediaHttpUploader uploader = videoInsert.getMediaHttpUploader();

      /*
       * Sets whether direct media upload is enabled or disabled. True = whole media content is
       * uploaded in a single request. False (default) = resumable media upload protocol to upload
       * in data chunks.
       */
            uploader.setDirectUploadEnabled(false);

            MediaHttpUploaderProgressListener progressListener = new MediaHttpUploaderProgressListener() {
                public void progressChanged(MediaHttpUploader uploader) throws IOException {
                    switch (uploader.getUploadState()) {
                        case INITIATION_STARTED:
                            System.out.println("Initiation Started");
                            break;
                        case INITIATION_COMPLETE:
                            System.out.println("Initiation Completed");
                            System.out.print(uploader.getUploadState());
                            break;
                        case MEDIA_IN_PROGRESS:
                            System.out.println("Upload in progress");
                            System.out.println("Upload percentage: " + uploader.getProgress());
                            break;
                        case MEDIA_COMPLETE:
                            System.out.println("Upload Completed!");
                            break;
                        case NOT_STARTED:
                            System.out.println("Upload Not Started!");
                            break;
                    }
                }
            };
            uploader.setProgressListener(progressListener);

            // Execute upload.
            Video returnedVideo = videoInsert.execute();

            // Print out returned results.
            System.out.println("\n================== Returned Video ==================\n");
            System.out.println("  - Id: " + returnedVideo.getId());
            System.out.println("  - Title: " + returnedVideo.getSnippet().getTitle());
            System.out.println("  - Tags: " + returnedVideo.getSnippet().getTags());
            System.out.println("  - Privacy Status: " + returnedVideo.getStatus().getPrivacyStatus());
            System.out.println("  - Video Count: " + returnedVideo.getStatistics().getViewCount());

        } catch (GoogleJsonResponseException e) {
            System.err.println("GoogleJsonResponseException code: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            e.printStackTrace();
        } catch (Throwable t) {
            System.err.println("Throwable: " + t.getMessage());
            t.printStackTrace();
        }
    }

    /**
     * Gets the user selected local video file to upload.
     */
    private static File getVideoFromUser(String part) throws IOException {
        getLocalVideoFiles(part);

        return getLocalVideoFiles(part);
    }

    /**
     * Gets an array of videos in the current directory.
     */
    private static File getLocalVideoFiles(String part) throws IOException {

        File currentDirectory = new File(part);



//        byte[] b = new byte[(int) currentDirectory.length()];
//        try {
//            FileInputStream fileInputStream = new FileInputStream(file);
//            fileInputStream.read(b);
//            for (int i = 0; i < b.length; i++) {
//                System.out.print((char)b[i]);
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File Not Found.");
//            e.printStackTrace();
//        }
//        catch (IOException e1) {
//            System.out.println("Error Reading The File.");
//            e1.printStackTrace();
//        }




        System.out.println("Video files from " + currentDirectory.getAbsolutePath() + ":");


        // Filters out video files. This list of video extensions is not comprehensive.
        FilenameFilter videoFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".webm") || lowercaseName.endsWith(".flv")
                        || lowercaseName.endsWith(".f4v") || lowercaseName.endsWith(".mov")
                        || lowercaseName.endsWith(".mp4")) {
                    System.out.print("maffff1");
                    return true;
                } else {
                    System.out.print("maffff2");
                    return false;
                }
            }
        };
        System.out.print("maffff3");
File [] file = new File[1];
        file[0] =currentDirectory;
        return currentDirectory;
    }

    /**
     * Outputs video file options to the user, records user selection, and returns the video (File
     * object).
     *
     * @param videoFiles Array of video File objects
     */
    private static File getUserChoice(File videoFiles[]) throws IOException {
        System.out.print("mmmmmmmmmmmmmmm");
        if (videoFiles.length < 1) {
            System.out.print("mmmmmmmmmmmmmmm");
            throw new IllegalArgumentException("No video files in this directory.");
        }

        for (int i = 0; i < videoFiles.length; i++) {
            System.out.print("mmmmmmmmmmmmmmm");
            System.out.println(" " + i + " = " + videoFiles[i].getName());
        }
        System.out.print("mmmmmmmmmmmmmmm");
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String inputChoice;

        do {
            System.out.print("Choose the number of the video file you want to upload: ");
            inputChoice = bReader.readLine();
        } while (!isValidIntegerSelection(inputChoice, videoFiles.length));

        return videoFiles[Integer.parseInt(inputChoice)];
    }

    /**
     * Checks if string contains a valid, positive integer that is less than max. Please note, I am
     * not testing the upper limit of an integer (2,147,483,647). I just go up to 999,999,999.
     *
     * @param input String to test.
     * @param max Integer must be less then this Maximum number.
     */
    public static boolean isValidIntegerSelection(String input, int max) {
        if (input.length() > 9) return false;

        boolean validNumber = false;
        // Only accepts positive numbers of up to 9 numbers.
        Pattern intsOnly = Pattern.compile("^\\d{1,9}$");
        Matcher makeMatch = intsOnly.matcher(input);

        if (makeMatch.find()) {
            int number = Integer.parseInt(makeMatch.group());
            if ((number >= 0) && (number < max)) {
                validNumber = true;
            }
        }
        return validNumber;
    }
    }
