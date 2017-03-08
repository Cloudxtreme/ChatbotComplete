package chat.view;

import javax.swing.*;
import java.awt.Color;
import chat.controller.ChatController;
import chat.controller.FileController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton chatButton;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private SpringLayout baseLayout;
	private JScrollPane ChatPane;
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
		chatField = new JTextField(25);
		chatButton = new JButton("Chat");
		SentTweet = new JButton("Send a Tweet");
		SaveButton = new JButton("Save");
		LoadButton = new JButton("Load");
		SearchButton = new JButton("Search Twitter");
		ChatPane = new JScrollPane();
		chatDisplay = new JTextArea(5, 25);
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		setupChatDisplay();
		
	}
	/**
	 * This sets up the panel and it's objects 
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(chatButton);
		this.add(chatField);
		this.add(SentTweet);
		this.add(SaveButton);
		this.add(LoadButton);
		this.add(SearchButton);
		this.add(ChatPane);
		
		
		
	}
	
	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setEnabled(false);
		chatDisplay.setWrapStyleWord(true);
		chatDisplay.setLineWrap(true);
		ChatPane.setViewportView(chatDisplay);
		ChatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		ChatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
	}
	/**
	 * Sets up the layout of the panel to make sure the objects are at the right place
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatDisplay, 71, SpringLayout.SOUTH, ChatPane);
		baseLayout.putConstraint(SpringLayout.WEST, chatDisplay, 231, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, SaveButton, 0, SpringLayout.NORTH, SentTweet);
		baseLayout.putConstraint(SpringLayout.EAST, SaveButton, 0, SpringLayout.EAST, LoadButton);
		baseLayout.putConstraint(SpringLayout.NORTH, LoadButton, 0, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, LoadButton, 115, SpringLayout.EAST, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, SearchButton, 6, SpringLayout.SOUTH, SentTweet);
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 6, SpringLayout.SOUTH, ChatPane);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, -310, SpringLayout.EAST, ChatPane);
		baseLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, ChatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, ChatPane, 100, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, ChatPane, 230, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, ChatPane, -305, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, ChatPane, -250, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, SentTweet, 375, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, SentTweet, 231, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -6, SpringLayout.NORTH, SentTweet);
		baseLayout.putConstraint(SpringLayout.WEST, SearchButton, 231, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, SearchButton, -443, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 241, SpringLayout.WEST, this);

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
				String currentText = chatDisplay.getText();
				
				chatDisplay.setText(currentText +"You said " + userWords + "\n" + "Chatbot said :" + botResponse + "\n");
				chatDisplay.setCaretPosition(chatDisplay.getCaretPosition());
				chatField.setText("");
			}
			
			
		});
		SaveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Click)
			{
				String fileName = chatField.getText();
				
				FileController.saveFile(baseController, fileName.trim(), chatDisplay.getText());
			}
		});
		LoadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Click)
			{
				String fileName = chatField.getText() + ".txt";
				String saved = FileController.readFile(baseController, fileName);
				chatDisplay.setText(saved);
			}
		});
		SearchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Click)
			{
				String username = chatField.getText();
				chatDisplay.append(baseController.searchTwitter(username));
			}
		});
		SentTweet.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Click)
			{
				baseController.useTwitter(chatField.getText());
			}
		});
		
		
	}




}