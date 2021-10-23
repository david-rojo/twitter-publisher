package com.davidrojo.twitterpublisher;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TweetManagementApi {
	
	private static Logger logger = LoggerFactory.getLogger(TweetManagementApi.class);
	
	public static void main(String[] args) throws TwitterException {
		
		Twitter twitter = TwitterFactory.getSingleton();	

		// Timelines
		List<Status> statuses = twitter.getHomeTimeline();

		logger.info("Showing home timeline.");
		for (Status status : statuses) {
			logger.info(status.getUser().getName() + ":" + status.getText());
		}

		// Post a tweet
		Status status = twitter.updateStatus("Test from java app");
		logger.info("Successfully updated the status to [" + status.getText() + "].");
	}
}
