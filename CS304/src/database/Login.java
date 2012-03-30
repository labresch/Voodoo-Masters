package database;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class Login {
	private JSplitPane login;
	private JPanel uName;
	private JTextField uNameText;
	private JPanel pass;
	private JTextField passText;
	private JButton loginbutton;
	private JLabel loginFail;
	private JLabel loginSuccess;
	private MainFrame mFrame;
	
	public Login(MainFrame mf) {
		mFrame = mf;
		
		login = new JSplitPane();
		login.setEnabled(false);
		login.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		uName = new JPanel();
		uName.setLayout(new BoxLayout(uName, BoxLayout.LINE_AXIS));
		
		uNameText = new JTextField();
		uNameText.setColumns(5);
		uNameText.setMaximumSize(new Dimension(Integer.MAX_VALUE,uNameText.getPreferredSize().height));
		loginFail = new JLabel("Failure");
		loginFail.setVisible(false);
		loginSuccess = new JLabel("Success");
		loginSuccess.setVisible(false);
		
		uName.add(new JLabel("UserName:"));
		uName.add(uNameText);
		uName.add(loginFail);
		uName.add(loginSuccess);
		login.setLeftComponent(uName);
		
		pass = new JPanel();
		pass.setLayout(new BoxLayout(pass, BoxLayout.LINE_AXIS));
		
		passText = new JTextField();
		passText.setColumns(5);
		passText.setMaximumSize(new Dimension(Integer.MAX_VALUE,passText.getPreferredSize().height));
		
		pass.add(new JLabel("Password:"));
		pass.add(passText);
		
		loginbutton = new JButton("Login");
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				checkLogin();
			}
		});
		pass.add(loginbutton);
		login.setRightComponent(pass);
	}
	enum UserStatus {
		NONSUBSCRIBER,
		SUBSCRIBER,
		PUBLISHER,
		ADMIN;
	}

	public JSplitPane getComponent() {
		return login;
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
		}
		else if (user.equals("publisher") && pword.equals("publisher")) {
			mFrame.updateUserStatus(UserStatus.PUBLISHER);
			loginSuccess.setVisible(true);
			loginFail.setVisible(false);
		}
		else if (user.equals("subscriber") && pword.equals("subscriber")) {
			mFrame.updateUserStatus(UserStatus.SUBSCRIBER);
			loginSuccess.setVisible(true);
			loginFail.setVisible(false);
		}
		else {
			mFrame.updateUserStatus(UserStatus.NONSUBSCRIBER);
			loginSuccess.setVisible(false);
			loginFail.setVisible(true);
		}
	}

}
