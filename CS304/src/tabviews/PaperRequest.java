package tabviews;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;


public class PaperRequest extends Tab{
private JPanel mainPanel;
private int tBoxSize = 300;
	
	public PaperRequest() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel editorLine = inputLine("Editor");
		JPanel titleLine = inputLine("Title");
		JPanel dateLine = inputLine("Date Published");
		
		JButton reqButton = new JButton("Request");
		reqButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				request();
			}
		});
		
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
		editorLine.setAlignmentX(Component.RIGHT_ALIGNMENT);
		subPanel.add(editorLine);
		titleLine.setAlignmentX(Component.RIGHT_ALIGNMENT);
		subPanel.add(titleLine);
		dateLine.setAlignmentX(Component.RIGHT_ALIGNMENT);
		subPanel.add(dateLine);
		reqButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		subPanel.add(reqButton);
		
		subPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(subPanel);
	}
	
	public JPanel getComponent() {
		return mainPanel;
	}
	
	private JPanel inputLine(String s) {
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.LINE_AXIS));

		JLabel inputLabel = new JLabel(s + ":");
		inputPanel.add(inputLabel);

		JTextField inputBox = new JTextField();
		inputBox.setMaximumSize(new Dimension(tBoxSize, inputBox.getPreferredSize().height));
		inputPanel.add(inputBox);
		return inputPanel;
	}
	
	private void request() {
		/* do something??? */
	}

}
