package tabviews;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import database.ResultsDisplay;


import apple.laf.CoreUIConstants.Orientation;

public class Subscriptions extends Tab{
	
	private JSplitPane mainPanel;
	
	public Subscriptions() {
		mainPanel = new JSplitPane();
		mainPanel.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JPanel reqPanel = new JPanel();
		reqPanel.setLayout(new BoxLayout(reqPanel, BoxLayout.LINE_AXIS));
		
		reqPanel.add(new JLabel("Paper ID:"));
		
		JTextField reqBox = new JTextField();
		reqBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, reqBox.getPreferredSize().height));
		reqPanel.add(reqBox);
		
		JButton reqButton = new JButton("Subscribe");
		reqButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				subscribe();
			}
		});
		reqPanel.add(reqButton);
		mainPanel.setLeftComponent(reqPanel);
		
		ResultsDisplay rd = new ResultsDisplay(0);
		JScrollPane results = rd.getGUI();
		
		JPanel subs = new JPanel();
		subs.setLayout(new BoxLayout(subs, BoxLayout.Y_AXIS));
		subs.add(new JLabel("Subscriptions:"));
		subs.add(results);
		mainPanel.setRightComponent(subs);
	}
	
	public JSplitPane getComponent() {
		return mainPanel;
	}
	
	public void subscribe() {
		/*oracle wizardry*/
	}

}
