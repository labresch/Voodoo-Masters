import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ResultsDisplay {
	private static ArrayList<ArrayList<String>> papers;
	private static JFrame jframe;
	
	public static void createGUI() {
			
		papers = new ArrayList<ArrayList<String>>();
		for (int i=0; i < 30; i++) {
			ArrayList<String> paper = new ArrayList<String>();
			paper.add("Editor: " + i);
			paper.add("Title: " + i);
			paper.add("Date Published: " + i);
			paper.add("PaperID: " + i);
			papers.add(paper);
		}
		
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
        
        jframe = new JFrame("Results");
        jframe.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        jframe.setSize(new Dimension(600, 600));
        
        jframe.setLocationRelativeTo(null);
        
        jframe.setVisible(true);
	}
	
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	createGUI();
            }
        });
        
    }
}
