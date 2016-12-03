package chat.controller;

import chat.view.ChatViewer;
import chat.model.Chatbot;
import chat.view.ChatFrame;

public class ChatController
{
	private Chatbot stupidBot; 
	private ChatViewer chatView;
	private ChatFrame baseFrame;
	/**
	 * Gets the Chatbot, ChatViewer, and ChatFrame and makes it to variables
	 */
	public ChatController() 
	{
		stupidBot= new Chatbot("Bob");
		chatView = new ChatViewer();
		baseFrame = new ChatFrame(this);
	}
	/**
	 * Does nothing
	 */
	public void start()
	{
//		String response = "Hello";
//		
//		while(stupidBot.lengthChecker(response))
//		{
//			chatView.displayMessage(useChatbotCheckers(response));
//			response = chatView.collectResponse("What do you want to chat about today?");
//		}		
	}	
	/**
	 * Takes current input and uses checkers to reply
	 * @param input
	 * @return
	 */
	public String useChatbotCheckers(String input)
	{
		String answer ="";
				
		if(!stupidBot.quitChecker(input))
		{
			if(stupidBot.contentChecker(input))
			{
				answer += "\nYou know my specail secret\n";
			}
			if(stupidBot.memeChecker(input))
			{
				answer += "\nI can has memes?\n";
			}
		
			if(!stupidBot.lengthChecker(answer))
			{
				answer +="Sorry, I don't know about " + input;
			}
			int canBeRandom = (int) (Math.random() * 7);
			if(canBeRandom % 2 == 0)
			{
				answer += randomTopicGenerator();
			}
		}
		else
		{
			chatView.displayMessage("Thanks for talking with me");
			System.exit(0);
		}
		return answer;
	}	
	/**
	 * Takes a random topic and uses it 
	 * @return
	 */
	private String randomTopicGenerator()
	{
		String randomTopic = "";
		int random = (int) (Math.random() * 7);
		
		switch(random)
		{
			case 0:
				randomTopic = "Did you know you have a face?";
				break;
			case 1:
				randomTopic = "I like to talk to you";
				break;
		}
			return randomTopic; 
	
	}
	/**
	 * Returns the Chatbot as stupidBot
	 * @return
	 */
	public Chatbot getChatbot()
	{
		return stupidBot;
	}
	/**
	 * Returns BaseFrame as baseFrame
	 * @return
	 */
	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}
}	

