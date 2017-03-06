package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part * of the project. 
 * * @author Duncan Nguyen
 *  * @version 1.0 10/14/16
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	

	/**
	 * * Creates an instance of the Chatbot with the supplied username. * @param
	 * userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.userName = userName;
		this.content = new String("Green");
		this.buildMemesList();
		this.buildPoliticalTopicsList();
		
		
	}
	/**
	 * Adds memes to the lists
	 */
	
	private void buildMemesList()
	{
		memesList.add("doge");
		memesList.add("cute animals");
		memesList.add("grumpy cat");
		memesList.add("dat boi");
		memesList.add("willy wonka");
		memesList.add("harambe");
		memesList.add("john cena");
		memesList.add("pope");
		memesList.add("ken bone");
		memesList.add("Spongebob Squarepants");
		memesList.add("pepe");
		memesList.add("boy and girl");
		memesList.add("danny phantom");
		memesList.add("ICUP");
		memesList.add("star wars stormtroopers");
		memesList.add("School");
		memesList.add("Teachers");
		memesList.add("Autocorrect");
		
	}

	/**
	 * Adds political topics to the PoliticalTopicsLists
	 */
	private void buildPoliticalTopicsList()
	{
		politicalTopicList.add("Democrat");
		politicalTopicList.add("Republican");
		politicalTopicList.add("11/8/16");
		politicalTopicList.add("liberal");
		politicalTopicList.add("conservative");
		politicalTopicList.add("Hillary");
		politicalTopicList.add("Clinton");
		politicalTopicList.add("Trump");
		politicalTopicList.add("Kaine");
		politicalTopicList.add("Pence");
		politicalTopicList.add("Stein");
		politicalTopicList.add("Johnson");
		politicalTopicList.add("election");
		politicalTopicList.add("Jackson");
		politicalTopicList.add("Madison");
		politicalTopicList.add("Adams");
		politicalTopicList.add("Washington");
		politicalTopicList.add("Obama");
		politicalTopicList.add("JFK");
		
		
		
	}

	/**
	 * * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true. * @param currentInput * @return
	 * A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if(currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		
		return hasLength;
	}

	/**
	 * * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether it
	 *            matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
				
			return hasContent;
	}

	/**
	 * * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasTopic = false;
		
		String temp = "⇅";
		System.out.println(temp);
		
		
		for(int index = 0; index < politicalTopicList.size(); index++)
		{
			if(currentInput.equals(politicalTopicList.get(index)))
			{
				hasTopic = true;
			}
				
		}
		return hasTopic;
	}

	/**
	 * * Checks to see that the supplied String value is in the current
	 * memesList variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            supplied String is a recognized meme.
	 *            loop
	 *            if
	 *            .get()
	 *            equals
	 */
	public boolean memeChecker(String currentInput)
	{	
		boolean hasMeme = false;
	
		
		for(int index = 0; index < memesList.size(); index++)
		{
			if(currentInput.equals(memesList.get(index)))
			{
				hasMeme = true;
			}
		}
		return hasMeme;
	}
	/**
	 * Checks to see if the user is keyboard mashing in the current input
	 * @param currentInput is checked 
	 * @return 
	 */
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean keyboardMash = false;
		
		if(currentInput.equals("sdf"))
		{
			keyboardMash = true ;
		}
	
		if(currentInput.equals("dfg"))
		{
				keyboardMash = true;
		}
		if(currentInput.equals("cvb"))
		{
			keyboardMash = true;
		}
		if(currentInput.equals(",./"))
		{
			keyboardMash = true;
		}
		return keyboardMash;
	}
	/**
	 * Checks for all HTML and its tags
	 * @param currentInput
	 * @return
	 */
	public boolean inputHTMLChecker(String currentInput)
	{
		
		 boolean inputHTML = false;
	        
	        if(currentInput.contains("<P>"))
	        {
	            inputHTML = true;
	        }    
	        else if(currentInput.contains("<A HREF=\""))
	        {
	            int index = currentInput.indexOf("<A HREF=\"") + 9;
	            String sub = currentInput.substring(index);
	            
	            if(sub.contains("\">"))
	            {
	                int index2 = sub.indexOf("\">");
	                String sub2 = sub.substring(index2);
	                
	                if(sub2.contains(" </a>"))
	                {
	                    inputHTML = true;
	                }
	            }
	        }
	        else if(currentInput.contains("<"))
	        {
	            String lower = currentInput.toLowerCase();
	            int openIndex1 = lower.indexOf("<") + 1;
	            String tag = "";
	            if(lower.contains(">"))
	            {
	                int openIndex2 = lower.indexOf(">");
	                tag = lower.substring(openIndex1, openIndex2);
	                
	                String sub = lower.substring(openIndex2 + 1);
	                
	                if(sub.contains("</" + tag + ">"))
	                {
	                    inputHTML = true;
	                }    
	            }            
	        }
		return inputHTML;
	}
	/**
	 * Checks to see the current input is a twitter thing
	 * @param currentInput
	 * @return
	 */
	public boolean twitterChecker(String currentInput)
	{
		boolean twitter = false;
		if(currentInput.contains("#"))
		{
			int index = currentInput.indexOf("#");
			String sub = currentInput.substring(index + 1);
			
			if(index == 0)
			{
				if(sub.length() >= 1)
				{
					twitter = true;
				}
			}
			
		}
			else if(currentInput.contains("@"));
			{
				int index = currentInput.indexOf("@");
				String sub = currentInput.substring(index +1);
				
				if(index ==0)
				{
					if(sub.length() >- 1)
					{
						twitter = true;
					}
				}
				
			}
			return twitter;

		}
		
	

	
	/**
	 * * Returns the username of this Chatbot instance. * @return The username
	 * of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * * Returns the content area for this Chatbot instance. * @return The
	 * content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * * Getter method for the memesList object. * @return The reference to the
	 * meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}

	/**
	 * * Getter method for the politicalTopicList object. * @return The
	 * reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}

	/**
	 * * Updates the content area for this Chatbot instance. * @param content
	 * The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
	/**
	 * This checks if the current input says quit 
	 * @param currentInput quit
	 * @return 
	 */
	public boolean quitChecker(String currentInput)
	{
		boolean quit = false;
		
		if(currentInput.equals("quit"))
		{
			quit = true;
		}
		
		return quit;
	}

}