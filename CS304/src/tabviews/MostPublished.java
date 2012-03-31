package tabviews;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import database.ResultsDisplay;


public class MostPublished extends Tab{
	
	private JPanel mainPanel;

	public MostPublished() {
		mainPanel = new JPanel();
		ResultsDisplay rd = new ResultsDisplay(27);
		JScrollPane results = rd.getGUI();
		
		JPanel subs = new JPanel();
		subs.setLayout(new BoxLayout(subs, BoxLayout.Y_AXIS));
		subs.add(new JLabel("The Top Published Authors:"));
		subs.add(results);
		mainPanel.add(subs);
	}
	
	public JPanel getComponent() {
		return mainPanel;
	}
}
