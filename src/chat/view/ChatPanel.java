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
		chatButton = new JButton("Chat with the bot.");
		chatbotButton = new JButton("This is Button");
		
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
	}
	/**
	 * Sets up the layout of the panel to make sure the objects are at the right place
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, chatDisplay, -163, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatDisplay, -75, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 27, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, -138, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 32, SpringLayout.SOUTH, chatDisplay);
		baseLayout.putConstraint(SpringLayout.EAST, chatField, -65, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatbotButton, 0, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatbotButton, -6, SpringLayout.NORTH, chatDisplay);
		
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