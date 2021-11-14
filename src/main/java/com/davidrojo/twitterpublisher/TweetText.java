package com.davidrojo.twitterpublisher;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.UploadedMedia;

public class TweetText {

	private static Logger logger = LoggerFactory.getLogger(TweetText.class);
	
	private static Twitter twitter = TwitterFactory.getSingleton();


	public static void main(String[] args) throws TwitterException {

		try {
			// post a tweet link with image
			String statusMessage = "test twitter api";

			StatusUpdate statusUpdate = new StatusUpdate(statusMessage);

			Status status = twitter.updateStatus(statusUpdate);
			Long tweetId = status.getId();
			Date publishedAt = status.getCreatedAt();
			String message = statusUpdate.getStatus();
			String user = status.getUser().getScreenName();
			String tweetUrl = "https://twitter.com/" + user + "/status/" + tweetId;
			logger.info("Successfully updated the status to [" + status.getText() + "].");

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
