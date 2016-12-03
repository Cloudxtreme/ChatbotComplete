package chat.view;

import java.awt.Dimension;
import javax.swing.JFrame;
import chat.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel appPanel;
	/**
	 * This gets the ChatPanel and it's info and adde
	 * @param baseController
	 */
	public ChatFrame(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		appPanel = new ChatPanel(baseController);
		setupFrame();
	}
	/**
	 * Set up the whole frame for the chatbot and it's conditional
	 */
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("ChatBot");
		this.setSize(new Dimension (600, 400));
		this.setResizable(false);
		this.setVisible(true);
		
	}
}
