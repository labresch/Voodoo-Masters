package tabviews;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminRemove extends Tab{
	JPanel mainPanel;
	JTextField uBox;
	public AdminRemove() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.add(new JLabel("Username:"));
		uBox = new JTextField(); 
		uBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, uBox.getPreferredSize().height));
		mainPanel.add(uBox);
		
		JButton rmBut = new JButton("Remove");
		rmBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				removeUser();
			}
		});
		mainPanel.add(rmBut);
	}

	@Override
	public JComponent getComponent() {
		return mainPanel;
	}
	
	private void removeUser() {
		String username = uBox.getText();
	}
}
