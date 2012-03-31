package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PaperDisplay extends JFrame {

	private JPanel contentPane;
	private List<String> paper;
	
	/**
	 * Create the frame.
	 */
	public PaperDisplay( ArrayList<String> paperinfo) {
		paper = paperinfo;
		
		setTitle(paper.get(4));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
	}

}
