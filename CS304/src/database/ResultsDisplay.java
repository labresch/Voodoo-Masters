package database;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ResultsDisplay {
	private static ArrayList<ArrayList<String>> papers;

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

	}

	public JComponent getGUI() {

		
		JTextArea textArea = new JTextArea();


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

		//jframe.setVisible(true);
	}
}


