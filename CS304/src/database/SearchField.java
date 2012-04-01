package database;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchField extends JPanel{
	
	private JTextField keyword;
	private JComboBox subtopicBox;
	//private String[] booleans = {"AND", "OR", "NOT"};
	private String[] subtopics = {"Title", "Topic", "Author", "Journal"};
	private int topicindex;
	public static String[] attNames = {"title", "topicname", "name", "journalname"};
	
	public SearchField(int topic){
		topicindex = topic;
		if (topic > subtopics.length){
			MainFrame.showError("Specified subtopic does not exist.");
			return;
		}
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		add(new JLabel(subtopics[topic] + ":"));
		add(Box.createHorizontalStrut(5));
		keyword = new JTextField();
		keyword.setMaximumSize(new Dimension(Integer.MAX_VALUE, keyword.getPreferredSize().height));
		add(keyword);
		
	}
	
	/**
	 * Set up a new search field with AND/OR/NOT options, textarea, and topic choice
	 * @param showBooleans if TRUE show AND/OR/NOT options
	 * 					  if FALSE do not show boolean options
	 */
	public SearchField(boolean showBooleans){
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		
	//		booleanBox = new JComboBox(booleans);
	//		booleanBox.setSelectedIndex(0);
		if (showBooleans){
	//		add(booleanBox);	
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
	
	public ArrayList<String> getContents(){
		ArrayList<String> contents = new ArrayList<String>();
		if (keyword.getText().equals("")){
			return contents;
		}
		String topic = attNames[topicindex];
		String temp = keyword.getText();
		String[] parsed = temp.split(" ");
		for (int i = 0; i < parsed.length; i++){
			contents.add(topic);
			contents.add(parsed[i]);
		}
		return contents;
	}
		
	/**
	 * Get the String contents of the SearchField
	 * @return the contents of the SearchField as a String 
	 */
	/*public List<String> getContents(){
		if ( keyword.getText().equals("")){
			return contents;
		}
		
		if ( subtopicBox.getSelectedIndex() == 0){
			for(int i = 1; i < subtopics.length; i++){
				contents.add("OR");
				contents.add(subtopics[i]);
				contents.add(keyword.getText());
			}
		}
		else{
			contents.add((String) booleanBox.getSelectedItem());
			contents.add((String) subtopicBox.getSelectedItem());
			contents.add(keyword.getText());
		}
		return contents;
	}*/

}
