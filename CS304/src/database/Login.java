package database;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class Login {
	private JPanel mainPanel;
	private JPanel login;
	private JPanel uName;
	private JTextField uNameText;
	private JPanel pass;
	private JTextField passText;
	private JButton loginbutton;
	private JLabel loginFail;
	private JLabel loginSuccess;
	private MainFrame mFrame;
	private int labelSize = 20;
	private int textSize = 300;
	
	public Login(MainFrame mf) {
		mFrame = mf;

		login = new JPanel();
		login.setLayout(new BoxLayout(login, BoxLayout.Y_AXIS));
		
		uName = new JPanel();
		uName.setLayout(new BoxLayout(uName, BoxLayout.LINE_AXIS));
		
		uNameText = new JTextField();
		uNameText.setMaximumSize(new Dimension(textSize, uNameText.getPreferredSize().height));
		loginFail = new JLabel("Failure");
		loginFail.setVisible(false);
		loginSuccess = new JLabel("Success");
		loginSuccess.setVisible(false);
		
		JLabel uLabel = new JLabel("UserName:");
		uLabel.setSize(labelSize, uLabel.getPreferredSize().height);
		uName.add(uLabel);
		uName.add(uNameText);
		uName.setAlignmentX(Component.RIGHT_ALIGNMENT);
		login.add(uName);
		
		pass = new JPanel();
		pass.setLayout(new BoxLayout(pass, BoxLayout.LINE_AXIS));
		
		passText = new JPasswordField(10);
		passText.setMaximumSize(new Dimension(textSize, passText.getPreferredSize().height));
		
		JLabel passLabel = new JLabel("Password:");
		passLabel.setSize(labelSize, passLabel.getPreferredSize().height);
		pass.add(passLabel);
		pass.add(passText);
		
		loginbutton = new JButton("Login");
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				checkLogin();
			}
		});
		pass.setAlignmentX(Component.RIGHT_ALIGNMENT);
		login.add(pass);
		
		JPanel lbPanel = new JPanel();
		lbPanel.setLayout(new BoxLayout(lbPanel, BoxLayout.LINE_AXIS));
		lbPanel.add(loginFail);
		lbPanel.add(loginSuccess);
		lbPanel.add(loginbutton);
		lbPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		login.add(lbPanel);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		login.setAlignmentX(Component.CENTER_ALIGNMENT);
		login.setAlignmentY(Component.CENTER_ALIGNMENT);
		mainPanel.add(login);
		
	}
	enum UserStatus {
		NONSUBSCRIBER,
		SUBSCRIBER,
		PUBLISHER,
		ADMIN;
	}

	public JPanel getComponent() {
		return mainPanel;
	}
	
	private void checkLogin() {
		String user = uNameText.getText();
		String pword = passText.getText();
		uNameText.setText("");
		passText.setText("");
		
		if (user.equals("admin") && pword.equals("admin")) {
			mFrame.updateUserStatus(UserStatus.ADMIN);
			loginSuccess.setVisible(true);
			loginFail.setVisible(false);
			mFrame.homeView();
		}
		else if (user.equals("publisher") && pword.equals("publisher")) {
			mFrame.updateUserStatus(UserStatus.PUBLISHER);
			loginSuccess.setVisible(true);
			loginFail.setVisible(false);
			mFrame.homeView();
		}
		else if (user.equals("subscriber") && pword.equals("subscriber")) {
			mFrame.updateUserStatus(UserStatus.SUBSCRIBER);
			loginSuccess.setVisible(true);
			loginFail.setVisible(false);
			mFrame.homeView();
		}
		else {
			mFrame.updateUserStatus(UserStatus.NONSUBSCRIBER);
			loginSuccess.setVisible(false);
			loginFail.setVisible(true);
		}
	}

}
