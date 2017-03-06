package chat.model;

import chat.controller.ChatController;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.*;


public class CTECTwitter 
{
	private ChatController baseController;
	private Twitter twitterBot;
	private List<Status> searchedTweets;
	private List<String> ignoredWords;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		twitterBot = TwitterFactory.getSingleton();
		ignoredWords = new ArrayList<String>();
		searchedTweets = new ArrayList<Status>();
	}
	
	public void sentTweet(String textToTweet)
	{
		try
		{
			twitterBot.updateStatus(textToTweet + " @chatbotCTEC ");
		}
		catch(TwitterException tweetError)
		{
			baseController.handleErrors(tweetError);
		}
		catch(Exception otherError)
		{
			baseController.handleErrors(otherError);
		}
	}
	
	public void createIgnoredWordList()
	{
		
	}
	
	public void collectTweets(String username)
	{
		
	}
	
	public String getMostCommonWord()
	{
		return null;
	}
}
