package database;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

class SignUp extends Tab{

	private JPanel mainPanel;
	private JPanel signup;
	private JPanel uName;
	private JTextField uNameText;
	private JPanel pass;
	private JTextField passText;
	private JButton signupButton;
	private JLabel signupFail;
	private JLabel signupSuccess;
	private int labelSize = 20;
	private int textSize = 300;
	
	public SignUp() {
		
		signup = new JPanel();
		signup.setLayout(new BoxLayout(signup, BoxLayout.Y_AXIS));
		
		uName = new JPanel();
		uName.setLayout(new BoxLayout(uName, BoxLayout.LINE_AXIS));
		
		uNameText = new JTextField();
		uNameText.setMaximumSize(new Dimension(textSize, uNameText.getPreferredSize().height));
		signupFail = new JLabel("Failure");
		signupFail.setVisible(false);
		signupSuccess = new JLabel("Success");
		signupSuccess.setVisible(false);
		
		JLabel uLabel = new JLabel("UserName:");
		uLabel.setSize(labelSize, uLabel.getPreferredSize().height);
		uName.add(uLabel);
		uName.add(uNameText);
		uName.setAlignmentX(Component.RIGHT_ALIGNMENT);
		signup.add(uName);
		
		pass = new JPanel();
		pass.setLayout(new BoxLayout(pass, BoxLayout.LINE_AXIS));
		
		passText = new JPasswordField(10);
		passText.setMaximumSize(new Dimension(textSize, passText.getPreferredSize().height));
		
		JLabel passLabel = new JLabel("Password:");
		passLabel.setSize(labelSize, passLabel.getPreferredSize().height);
		pass.add(passLabel);
		pass.add(passText);
		
		JPanel verpass = new JPanel();
		verpass.setLayout(new BoxLayout(verpass, BoxLayout.LINE_AXIS));
		
		JPasswordField verpassText = new JPasswordField(10);
		verpassText.setMaximumSize(new Dimension(textSize, passText.getPreferredSize().height));
		
		JLabel verpassLabel = new JLabel("Verify Password:");
		passLabel.setSize(labelSize, passLabel.getPreferredSize().height);
		verpass.add(verpassLabel);
		verpass.add(verpassText);
		
		pass.setAlignmentX(Component.RIGHT_ALIGNMENT);
		signup.add(pass);
		
		verpass.setAlignmentX(Component.RIGHT_ALIGNMENT);
		signup.add(verpass);
		
		signupButton = new JButton("Sign Up!");
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				signup();
			}
		});
		
		JPanel subPanel = new JPanel();
		subPanel.add(signupFail);
		subPanel.add(signupSuccess);
		subPanel.add(signupButton);

		subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.LINE_AXIS));
		subPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		signup.add(subPanel);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		signup.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(signup);
	}
	
	public JPanel getComponent() {
		return mainPanel;
	}
	
	private void signup() {
		/*oracle wizardry*/
	}
}
