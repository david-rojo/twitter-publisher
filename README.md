# Twitter Publisher

## Get API keys and tokens

Keys needed for using an application, configure a plugin or connect in some way a Twitter account are:

- Consumer Key (API Key)
- Consumer Secret (API Secret)
- Access Token
- Access Token Secret

## Access to Twitter applications development center

Access to [https://developer.twitter.com/en/apps](https://developer.twitter.com/en/apps)

Complete form to get access to Twitter API

Create a new project and inside it, a new application. Application name and APPID are shown.

Set the application with Read and Write permissions

In the new application generate credentials:

- API Key
- API Key Secret
- Bearer Token

Generate an access token and access token secret

## twitter4j.properties location

In order to post tweets is mandatory to create a file named `twitter4j.properties` in `src/main/resources` with following content:

```
debug=true
oauth.consumerKey=<consumer_key>
oauth.consumerSecret=<consumer_secret>
oauth.accessToken=<access_token>
oauth.accessTokenSecret=<access_token_secret>
```

## Post tweets

[TweetManagementApi.java](src/main/java/com/davidrojo/twitterpublisher/TweetManagementApi.java)

Reference: [How to post tweets using Twitter4j Java API](https://roytuts.com/how-to-post-tweets-using-twitter4j-java-api/)

## Post tweets with an image

[TweetLinkWithRemoteImage.java](src/main/java/com/davidrojo/twitterpublisher/TweetLinkWithRemoteImage.java)

Reference: [How to post image tweets to Twitter using Twitter4j Java API](https://roytuts.com/how-to-post-image-tweets-to-twitter-using-twitter4j-java-api/)