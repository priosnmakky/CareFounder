package com.care.health.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.health.model.Blogger;
import com.care.health.model.YoutubeVideo;
import com.care.health.youtube.api.dao.UploadVideoDao;
@Service
public class YoutubeVideoServiceImpl implements YoutubeVideoService{
	@Autowired
	UploadVideoDao uploadVideoDao;
	public YoutubeVideo createYoutueVideo(String part,YoutubeVideo youtubeVideo) throws IOException {
		craeteFolder(part);
		File outputFile = new File(part+youtubeVideo.getId()+".mp4");
		FileOutputStream  outputStream = new FileOutputStream(outputFile);
		byte[] base64Decoded = DatatypeConverter.parseBase64Binary(youtubeVideo.getByteOrpart());
		outputStream.write(base64Decoded);
		outputStream.close();
		youtubeVideo.setByteOrpart(part+youtubeVideo.getId()+".mp4");
		YoutubeVideo uplodvideo =uploadVideoDao.createVideoYoutube(youtubeVideo);
		deleteYoutubeVideo(youtubeVideo);
		
		return uplodvideo;
		

	}
	public void deleteYoutubeVideo(YoutubeVideo youtubeVideo){
		File file = new File(youtubeVideo.getByteOrpart());

		if(file.delete()){
			System.out.println("C:\\Users\\narongrit\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\healthCare\\WEB-INF\\resource\\Video\\Youtube\\"+youtubeVideo.getId()+".mp4");
				System.out.println(file.getName() + " is deleted!");
		}else{
			System.out.println(youtubeVideo.getByteOrpart());
				System.out.println("Delete operation is failed.");
			}
	} 
	public void craeteFolder(String part){
		File theDir = new File(part);
		if (!theDir.exists()) {
		    System.out.println("creating directory: " );
		    theDir.mkdir();
		   }
	}
}
