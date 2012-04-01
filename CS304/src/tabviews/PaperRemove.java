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

public class PaperRemove extends Tab{
	JPanel mainPanel;
	JTextField pBox;
	public PaperRemove() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.add(new JLabel("PaperID:"));
		pBox = new JTextField(); 
		pBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, pBox.getPreferredSize().height));
		mainPanel.add(pBox);
		
		JButton rmBut = new JButton("Remove");
		rmBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				removePaper();
			}
		});
		mainPanel.add(rmBut);
	}

	@Override
	public JComponent getComponent() {
		return mainPanel;
	}

	private void removePaper() {
		if (isAuthorized()) {
			String paperID = pBox.getText();
		}
	}
	
	private boolean isAuthorized() {
		return false;
	}
}
