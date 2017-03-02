package chat.view;

import javax.swing.*;
import java.awt.Color;
import chat.controller.ChatController;
import java.awt.event.ActionListener;
import javax.swing.SpringLayout;
import java.awt.event.ActionEvent;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton chatButton;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private SpringLayout baseLayout;
	private JButton chatbotButton;
	private JButton SearchButton;
	private JButton SentTweet;
	private JButton SaveButton;
	private JButton LoadButton;
	
	/**
	 * Sets up the panel 
	 * @param baseController
	 */
	public ChatPanel(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatDisplay = new JTextArea(5, 25);
		chatField = new JTextField(25);
		chatButton = new JButton("Chat");
		SentTweet = new JButton("Send a Tweet");
		SaveButton = new JButton("Save");
		LoadButton = new JButton("Load");
		SearchButton = new JButton("Search Twitter");
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		
		
	}
	/**
	 * This sets up the panel and it's objects 
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(chatDisplay);
		this.add(chatButton);
		this.add(chatField);
		this.add(chatbotButton);
		this.add(SentTweet);
		this.add(SaveButton);
		this.add(LoadButton);
		this.add(SearchButton);
		
	}
	/**
	 * Sets up the layout of the panel to make sure the objects are at the right place
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, chatDisplay, -163, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatDisplay, -75, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 32, SpringLayout.SOUTH, chatDisplay);
		baseLayout.putConstraint(SpringLayout.EAST, chatField, -65, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatbotButton, 0, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatbotButton, -6, SpringLayout.NORTH, chatDisplay);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 43, SpringLayout.EAST, SentTweet);
		baseLayout.putConstraint(SpringLayout.WEST, SentTweet, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, SentTweet, 0, SpringLayout.NORTH, SaveButton);
		baseLayout.putConstraint(SpringLayout.EAST, SaveButton, -36, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, LoadButton, 257, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, SaveButton, -6, SpringLayout.NORTH, LoadButton);
		baseLayout.putConstraint(SpringLayout.WEST, LoadButton, 0, SpringLayout.WEST, SaveButton);
		baseLayout.putConstraint(SpringLayout.NORTH, SearchButton, 6, SpringLayout.SOUTH, SentTweet);
		baseLayout.putConstraint(SpringLayout.WEST, SearchButton, 0, SpringLayout.WEST, SentTweet);
		
	}
	/**
	 * Sets up the Listeners for the actions of the panel
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Click)
			{
				String userWords = chatField.getText();
				String botResponse = baseController.useChatbotCheckers(userWords);
				
				chatDisplay.setText("You said " + userWords + "\n" + "Chatbot said :" + botResponse);
				chatField.setText("");
			}
			
			
		});
	}




}