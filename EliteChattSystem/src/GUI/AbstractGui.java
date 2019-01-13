package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Client.ChatClient;

public abstract class AbstractGui {
	protected JFrame frame = new JFrame("Chatter");
	protected JTextField textField;
	protected JTextArea messageArea;
	private URL url;

	public AbstractGui(ChatClient client) {
		// Textfield where you enter your messages
		textField = new JTextField(40);
		textField.setEditable(false);

		// Textfield actionListener if there is any specific texts funny things will
		// happend, else just writes message and set the empty the textfield.
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("!!dance")) {
					try {
						url = new URL("https://i.makeagif.com/media/3-27-2016/xHLL7Y.gif");
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Icon icon = new ImageIcon(url);
					JLabel label = new JLabel(icon);
					JFrame f = new JFrame("Dansa som Tauron");
					textField.setText("");
					f.getContentPane().add(label);
					f.setResizable(false);
					f.pack();
					f.setVisible(true);
				}
				if (textField.getText().equals("!!shutUp")) {
					try {
						url = new URL("https://i.imgur.com/HB7qjnW.gif");
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Icon icon = new ImageIcon(url);
					JLabel label = new JLabel(icon);
					JFrame f = new JFrame("SHUT UP");
					textField.setText("");
					f.getContentPane().add(label);
					f.setResizable(true);
					f.pack();
					f.setVisible(true);
				}

				else if (!textField.getText().equalsIgnoreCase("")) {
					client.getOut().println(textField.getText());
					textField.setText("");
				}
			}
		});

		// The messageArea a JTextArea where all the messages appears
		messageArea = new JTextArea(8, 40);
		messageArea.setEditable(false);

		// new font
		Font f = new Font("Comic Sans MS", Font.PLAIN, 15);

		//Setting the text in the textfield to black and adding font to both textfield and messageArea
		textField.setForeground(Color.black);
		textField.setFont(f);
		messageArea.setFont(f);
		
		// Frame layout
		frame.getContentPane().add(textField, "South");
		frame.getContentPane().add(new JScrollPane(messageArea), "Center");
		
		//frame settings, pack, visible, and close.
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	//Getters and setters for Textfield, MessageArea, JFrame
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextArea getMessageArea() {
		return messageArea;
	}

	public void setMessageArea(JTextArea messageArea) {
		this.messageArea = messageArea;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
