package tabviews;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import database.ResultsDisplay;

public class DirectQuery extends Tab{
	
	private JSplitPane mainPanel;
	private JTextField qBox;
	
	public DirectQuery() {
		mainPanel = new JSplitPane();
		mainPanel.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JPanel qPanel = new JPanel();
		qPanel.setLayout(new BoxLayout(qPanel, BoxLayout.X_AXIS));
		
		qBox = new JTextField(); 
		qBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, qBox.getPreferredSize().height));
		qPanel.add(qBox);
		
		JButton qBut = new JButton("Query");
		qBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				sendRawQuery();
			}
		});
		qPanel.add(qBut);
		mainPanel.setLeftComponent(qPanel);
		
		ResultsDisplay rd = new ResultsDisplay(15);
		mainPanel.setRightComponent(rd.getGUI());
	}

	@Override
	public JComponent getComponent() {
		return mainPanel;
	}
	private void sendRawQuery(){
		String qText = qBox.getText();
		qBox.setText("");
	}
	
}
