package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class ChatViewer
{
	private String windowMessage;
	private ImageIcon chatIcon;
	/**
	 * The viewer for chatbot and its popup
	 */
	public ChatViewer()
	{
		windowMessage = "This is your ChatBot";
		chatIcon = new ImageIcon(getClass().getResource("images/stop_button-128.png"));
		
		
	}
	/**
	 * Makes a response about typing in the right spot
	 * @param question
	 * @return
	 */
	public String collectResponse(String question)
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(null, question, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon, null, "Type here please!").toString();
		
		return response;
	}
	/**
	 * Returns a int
	 * @param question
	 * @return
	 */
	public int collectUserOption(String question)
	{
		int response = 0;
		
		response = JOptionPane.showConfirmDialog(null, question);
		
		return response;			
	}
	/**
	 * Returns a String
	 * @param message
	 */
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}

}


