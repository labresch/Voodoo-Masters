package database;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ResultsDisplay {
	private static ArrayList<ArrayList<String>> papers;
	private List<JPanel> paperpanel;
	private List<JButton> paperbutton;
	
	public ResultsDisplay(int k){
		papers = new ArrayList<ArrayList<String>>();
		for (int i=k; i < 30; i++) {
			ArrayList<String> paper = new ArrayList<String>();
			paper.add("Editor: " + i);
			paper.add("Title: " + i);
			paper.add("Date Published: " + i);
			paper.add("PaperID: " + i);
			papers.add(paper);
		}
		paperpanel = new ArrayList<JPanel>();
		paperbutton = new ArrayList<JButton>();
	}

	public JScrollPane getGUI() {
		JPanel mainp = new JPanel();
		mainp.setLayout(new BoxLayout(mainp, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < papers.size(); i++){
			JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			
			for (int j=0; j < papers.get(i).size(); j++){
				JPanel tpanel = new JPanel();
				tpanel.setLayout(new BoxLayout(tpanel, BoxLayout.X_AXIS));
				tpanel.add(new JLabel(papers.get(i).get(j)));
				tpanel.add(Box.createHorizontalGlue());
				p.add(tpanel);
			}
			JButton doButton = new JButton("View Paper Information");
			paperbutton.add(doButton);
			doButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae) {
					int index = paperbutton.indexOf((JButton) ae.getSource());
					
				}
				
			});
			
			p.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),BorderFactory.createEmptyBorder(5,5,5,5)));
			mainp.add(p);
			
		}
		JScrollPane scrollPane = new JScrollPane(mainp);
		return scrollPane;
/*		JTextArea textArea = new JTextArea();


		for (int i = 0; i < papers.size(); i++) {
			for (int x = 0; x < papers.get(i).size(); x++) {
				textArea.setText(textArea.getText() + "\n" + papers.get(i).get(x));
			}
			if (i != papers.size() -1) {
				textArea.setText(textArea.getText() + "\n" + "------------------------------");
			}
		}

		JScrollPane scrollPane = new JScrollPane(textArea);

		return scrollPane;
		//jframe = new JFrame("Results");
		//jframe.getContentPane().add(scrollPane, BorderLayout.CENTER);

		//jframe.setSize(new Dimension(600, 600));

		//jframe.setLocationRelativeTo(null);

		//jframe.setVisible(true);*/
	}
}


