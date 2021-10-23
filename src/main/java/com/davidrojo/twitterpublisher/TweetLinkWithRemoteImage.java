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


	public static void main(String[] args) throws TwitterException {

		Twitter twitter = TwitterFactory.getSingleton();

		try {
			// post a tweet link with image
			String statusMessage = "My Profile Picture";
			String imageLocation = "http://pbs.twimg.com/profile_images/1418229439977164804/baRT3OKj_400x400.png";
			InputStream inputStreamImg = new URL(imageLocation).openStream();

			long[] mediaIds = new long[1];
			UploadedMedia media = twitter.uploadMedia("image.jpg", inputStreamImg);
			mediaIds[0] = media.getMediaId();

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
		}
	}

}
