package com.davidrojo.twitterpublisher;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.UploadedMedia;

public class TweetLinkWithRemoteImage {

	private static Logger logger = LoggerFactory.getLogger(TweetLinkWithRemoteImage.class);
	
	private static Twitter twitter = TwitterFactory.getSingleton();


	public static void main(String[] args) throws TwitterException {

		try {
			// post a tweet link with image
			String statusMessage = "Project logos";
			
			String image1Location = "https://davidrojo.eu/images/tfm/1.jpg";
			UploadedMedia media1 = uploadImage("image1.jpg", image1Location);
			String image2Location = "https://davidrojo.eu/images/tfm/2.jpg";
			UploadedMedia media2 = uploadImage("image2.jpg", image2Location);

			long[] mediaIds = new long[2];
			
			mediaIds[0] = media1.getMediaId();
			mediaIds[1] = media2.getMediaId();
			
			StatusUpdate statusUpdate = new StatusUpdate(statusMessage);
			statusUpdate.setMediaIds(mediaIds);

			Status status = twitter.updateStatus(statusUpdate);
			logger.info("Successfully updated the status to [" + status.getText() + "].");

		} catch (MalformedURLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static UploadedMedia uploadImage(String imageName, String imgLocation)
			throws MalformedURLException, IOException, TwitterException {

		InputStream imgInputStream = new URL(imgLocation).openStream();
		return twitter.uploadMedia(imageName, imgInputStream);
	}

}
