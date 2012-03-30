package database;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchField extends JPanel{
	
	private JTextField keyword;
	private JComboBox booleanBox, subtopicBox;
	private String[] booleans = {"AND", "OR", "NOT"};
	private String[] subtopics = {"All","Title", "Topic", "Author", "Journal", "Publisher"};
	
	/**
	 * Set up a new search field with AND/OR/NOT options, textarea, and topic choice
	 * @param showBooleans if TRUE show AND/OR/NOT options
	 * 					  if FALSE do not show boolean options
	 */
	public SearchField(boolean showBooleans){
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		
		if (showBooleans){
			booleanBox = new JComboBox(booleans);
			booleanBox.setSelectedIndex(0);
			add(booleanBox);
			
		}
		else{
			add(new JLabel("Enter Keywords:"));
		}
		
		keyword = new JTextField();
		keyword.setMaximumSize(new Dimension(Integer.MAX_VALUE,keyword.getPreferredSize().height));
		add(keyword);
		
		subtopicBox = new JComboBox(subtopics);
		subtopicBox.setSelectedIndex(0);
		add(subtopicBox);
	}
	
	/**
	 * Set the text in the keyword text area
	 * @param text  the text to set the text area to
	 */
	public void setText(String text){
		keyword.setText(text);
	}
	
	/**
	 * Get the String contents of the SearchField
	 * @return the contents of the SearchField as a String 
	 */
	public String getContents(){
		return "";
	}

}
