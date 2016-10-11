package com.google.api.services.sample.youtube;
import com.google.gdata.client.*;
import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.client.http.AuthSubUtil;
import com.google.gdata.client.youtube.*;
import com.google.gdata.data.*;
import com.google.gdata.data.calendar.CalendarEntry;
import com.google.gdata.data.calendar.CalendarFeed;
import com.google.gdata.data.geo.impl.*;
import com.google.gdata.data.media.*;
import com.google.gdata.data.media.mediarss.*;
import com.google.gdata.data.youtube.*;
import com.google.gdata.data.extensions.*;
import com.google.gdata.util.*;
import java.io.IOException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
public class main {

	public static void main(String[] args) throws MalformedURLException, AuthenticationException {
		// TODO Auto-generated method stub
		
//		Auth auth = new Auth();
//		auth.authorize(scopes, credentialDatastore);
		
		
		YouTubeService service = new YouTubeService("39353544201-ou61j8b6098lhf1uicct87k8i4034p58.apps.googleusercontent.com","aN2gE7bxe5OFnobRGhW3ULO5");
		///service.
	service.setUserCredentials("carevasDeveloper@gmail.com", "prison51");
		
		
		/// HttpServletRequest httpServletRequest.getURL(req);
//		 main main = new main ();
//		
//		YouTubeService service = new YouTubeService("859481630664-5i3kdg540es1ispgljvfl251bs4d3kvu.apps.googleusercontent.com", "AIzaSyDCuY-RTbjbgmgrKvyIdKEETaxa6ub0s9I");
//	
//		String requestUrl =
//				AuthSubUtil.getRequestUrl("www.facebook.com",
//				                        "http://gdata.youtube.com",
//				                        false,
//				                        true);
	///String onetimeUseToken =
		////		  AuthSubUtil.getTokenFromReply(httpServletRequest.getQueryString());
		////System.out.println(main.getURL(httpServletRequest.setAttribute(, arg1);));

		//		String requestUrl =
//				AuthSubUtil.getRequestUrl("http://www.example.com/RetrieveToken",
//				                        "http://gdata.youtube.com",
//				                        false,
//				                        true);
//		VideoFeed videoFeed = service.getFeed(new URL(feedUrl), VideoFeed.class);
//		printVideoFeed(videoFeed, true);
		
	//	CalendarService myService = new CalendarService("exampleCo-exampleApp-1.0");
//        try {
//			myService.setUserCredentials("root@gmail.com", "pa$$word");
//		} catch (AuthenticationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//        URL feedUrl = new URL("http://www.google.com/calendar/feeds/default/allcalendars/full");
//        CalendarFeed resultFeed = myService.getFeed(feedUrl, CalendarFeed.class);
//
//        System.out.println("Your calendars:");
//        System.out.println();
//
//        for (int i = 0; i < resultFeed.getEntries().size(); i++) {
//          CalendarEntry entry = resultFeed.getEntries().get(i);
//          System.out.println("\t" + entry.getTitle().getPlainText());
//        }

		
	}
	public static String getURL(HttpServletRequest req) {

	    String scheme = req.getScheme();             // http
	    String serverName = req.getServerName();     // hostname.com
	    int serverPort = req.getServerPort();        // 80
	    String contextPath = req.getContextPath();   // /mywebapp
	    String servletPath = req.getServletPath();   // /servlet/MyServlet
	    String pathInfo = req.getPathInfo();         // /a/b;c=123
	    String queryString = req.getQueryString();          // d=789

	    // Reconstruct original requesting URL
	    StringBuilder url = new StringBuilder();
	    url.append(scheme).append("://").append(serverName);

	    if (serverPort != 80 && serverPort != 443) {
	        url.append(":").append(serverPort);
	    }

	    url.append(contextPath).append(servletPath);

	    if (pathInfo != null) {
	        url.append(pathInfo);
	    }
	    if (queryString != null) {
	        url.append("?").append(queryString);
	    }
	    return url.toString();
	}
	
	
}
