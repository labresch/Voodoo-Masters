package tabviews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import database.MainFrame;


public class AuthorSearch extends Tab{

	private JSplitPane author_search;
	private JTextField field_of_study, institution, name;
	private JPanel mainpanel;
	private JButton search;
	
	public AuthorSearch(){
		author_search = new JSplitPane();
		author_search.setEnabled(false);
		author_search.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		
		mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
		mainpanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		name = new JTextField();
		JPanel np = new JPanel();
		np.setLayout(new BoxLayout(np, BoxLayout.X_AXIS));
		np.add(new JLabel("Author Name:"));
		np.add(Box.createHorizontalStrut(5));
		np.add(name);
		
		institution = new JTextField();
		JPanel inst = new JPanel();
		inst.setLayout(new BoxLayout(inst, BoxLayout.X_AXIS));
		inst.add(new JLabel("Institution:"));
		inst.add(Box.createHorizontalStrut(5));
		inst.add(institution);
		
		field_of_study = new JTextField();
		JPanel fos = new JPanel();
		fos.setLayout(new BoxLayout(fos, BoxLayout.X_AXIS));
		fos.add(new JLabel("Field of Study:"));
		fos.add(Box.createHorizontalStrut(5));
		fos.add(field_of_study);
		
		search = new JButton("Search");
		JPanel searchpanel = new JPanel();
		searchpanel.setLayout(new BoxLayout(searchpanel, BoxLayout.X_AXIS));
		searchpanel.add(search);
		searchpanel.add(Box.createHorizontalGlue());
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				getResults();
			}
		});
		
		mainpanel.add(np);
		mainpanel.add(inst);
		mainpanel.add(fos);
		mainpanel.add(searchpanel);
		mainpanel.add(Box.createVerticalGlue());

		author_search.setLeftComponent(mainpanel);
		author_search.setRightComponent(new JLabel(""));
	
	}
	
	
	/**
	 * 
	 */
	private void getResults(){
		List<String> authorquery = new ArrayList<String>();
		// For the SQL, this is set up as a list of strings,
		// organized in pairs so that the first pair is the actual attribute name in the tables
		// and the second is the search keyword
		// probably can be parsed for SQL with something like:
		/*
		 *   for (int i = 0; i < authorquery.size(); i+2){
		 * 		if authorquery.get(i).equals("name")
		 * 				do name query on authorquery.get(i+1) 
		 *      else if authorquery.get(i).equals("studyField")
		 * 			...
		 * 		else if authorquery.get(i).equals("institution")
		 * 	 }
		 */
		
		if( !name.getText().equals("")){
			authorquery.add("name");
			authorquery.add(name.getText());
		}
		if( !field_of_study.getText().equals("")){
			authorquery.add("studyField");
			authorquery.add(field_of_study.getText());
		}
		if( !institution.getText().equals("")){
			authorquery.add("institution");
			authorquery.add(institution.getText());
		}
		
		List<String> aq = new ArrayList<String>();
		try{
			aq = MainFrame.p.getauthors(authorquery);
		}
		catch (SQLException e){
			
		}
		
		// temporary test text
		JTextArea temporaryTest = new JTextArea();
		for (String e : aq){
			temporaryTest.insert(e + " ", temporaryTest.getCaretPosition());
		}
		author_search.setRightComponent(temporaryTest);
		
		// end temp
		
	}
	
	public JComponent getComponent(){
		return author_search;
	}
	
	
}
