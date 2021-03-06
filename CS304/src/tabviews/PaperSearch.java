package tabviews;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.*;

import database.MainFrame;
import database.ResultsDisplay;
import database.SearchField;



public class PaperSearch extends Tab{
	private JSplitPane paper_search;
	private JPanel advancedsearch, keyword_panel, as1;
	private JTextField paper_keyword, date1, date2;
	private JButton search_papers, do_advanced_search;
	private List<SearchField> fields;
	
	/**
	 * Constructor method for PaperSearch
	 * Sets up the initial search box and layout
	 */
	public PaperSearch(){
		
		paper_search = new JSplitPane();
		paper_search.setEnabled(false);
		paper_search.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		fields = new ArrayList<SearchField>();
		
		advancedsearch = new JPanel();
		advancedsearch.setLayout(new BoxLayout(advancedsearch, BoxLayout.Y_AXIS));
		advancedsearch.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		paper_search.setLeftComponent(advancedsearch);
		
		keyword_panel = new JPanel();
		keyword_panel.setLayout(new BoxLayout(keyword_panel, BoxLayout.LINE_AXIS));
		advancedsearch.add(keyword_panel);
		
		paper_keyword = new JTextField();
		paper_keyword.setColumns(10);
		paper_keyword.setMaximumSize(new Dimension(Integer.MAX_VALUE,paper_keyword.getPreferredSize().height));
		search_papers = new JButton("Search");
		search_papers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				getResults();
			}
		});
		
		keyword_panel.add(new JLabel("Enter Keywords:"));
		keyword_panel.add(paper_keyword);
		keyword_panel.add(search_papers);
		
	
		
		as1 = new JPanel();
		as1.setLayout(new BoxLayout(as1,BoxLayout.X_AXIS));
		
		do_advanced_search = new JButton("Advanced Search");
		do_advanced_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				keyword_panel.setVisible(false);
				as1.setVisible(false);
				set_up_advanced_search();
		
			}
		});
		
		as1.add(do_advanced_search);
		as1.add(Box.createHorizontalGlue());
		
		advancedsearch.add(as1);
		advancedsearch.add(Box.createVerticalGlue());
		
	//	paper_search.setRightComponent(new JLabel(""));
	ResultsDisplay rd = new ResultsDisplay(advancedsearch.getComponentCount());
		
		paper_search.setRightComponent(rd.getGUI());
	
	}
	
	
	/**
	 * Sets up the GUI for doing an advanced search for papers
	 */
	private void set_up_advanced_search(){
		
		for (int i = 0; i < SearchField.attNames.length; i++){
			SearchField f = new SearchField(i);
			fields.add(f);
			advancedsearch.add(f, advancedsearch.getComponentCount()-1);
		}
		
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Calendar calendar = Calendar.getInstance();
		
		JPanel datefield = new JPanel();
		datefield.setLayout(new BoxLayout(datefield,BoxLayout.X_AXIS));
		datefield.add(new JLabel("Published After:"));
		date1 = new JTextField();
		datefield.add(date1);
		
		datefield.add(new JLabel("Published Before:"));
		date2 = new JTextField(df.format(calendar.getTime()));
		datefield.add(date2);
		datefield.add(Box.createHorizontalGlue());
		JPanel datefield2 = new JPanel();
		datefield2.setLayout(new BoxLayout(datefield2,BoxLayout.X_AXIS));
		datefield2.add(Box.createHorizontalGlue());
		datefield2.add(new JLabel("yyyy or yyyy/mm or yyyy/mm/dd"));
		
		advancedsearch.add(datefield, advancedsearch.getComponentCount()-1);
		advancedsearch.add(datefield2, advancedsearch.getComponentCount()-1);

		JPanel searchbuttonpanel = new JPanel();
		searchbuttonpanel.setLayout(new BoxLayout(searchbuttonpanel,BoxLayout.X_AXIS));
		searchbuttonpanel.add(search_papers);
		searchbuttonpanel.add(Box.createHorizontalGlue());
		
		advancedsearch.add(searchbuttonpanel, advancedsearch.getComponentCount()-1);
		
		paper_search.resetToPreferredSizes();
	}
	
	/**
	 * Takes the contents of the search fields and displays the results from the database.
	 */
	public void getResults(){
		List<String> queries = new ArrayList<String>();
		if (fields.isEmpty()){ // no advanced search
			String text = paper_keyword.getText();
			queries.add("OR");
			queries.add("Title");
			queries.add(text);
			queries.add("OR");
			queries.add("Topic");
			queries.add(text);
			queries.add("OR");
			queries.add("Author");
			queries.add(text);
			queries.add("OR");
			queries.add("Journal");
			queries.add(text);
			queries.add("OR");
			queries.add("Publisher");
			queries.add(text);
		}
		else{
			queries.add("papersearch");
			for (SearchField sf : fields){
				queries.addAll(sf.getContents());
			}
			queries.add("datepublished");
			String temp = date1.getText();
			if (Pattern.matches("\\d\\d\\d\\d/\\d\\d/\\d\\d", temp)){ // yyyy/mm/dd
				
			}
			else if ( Pattern.matches("\\d\\d\\d\\d/\\d\\d", temp)){ // yyyy/mm
				temp = temp + "/28";
			}
			else if ( Pattern.matches("\\d\\d\\d\\d", temp)){ // yyyy
				temp = temp + "/12/31";
			}
			else{
				MainFrame.showError("Date is in an invalid format.");
				return;
			}
			queries.add(temp);
			queries.add("datepublished");
			temp = date2.getText();
			if (Pattern.matches("\\d\\d\\d\\d/\\d\\d/\\d\\d", temp)){} // yyyy/mm/dd
			else if ( Pattern.matches("\\d\\d\\d\\d/\\d\\d", temp)){ // yyyy/mm
				temp = temp + "/01";
			}
			else if ( Pattern.matches("\\d\\d\\d\\d", temp)){ // yyyy
				temp = temp + "/01/01";
			}
			else{
				MainFrame.showError("Date is in an invalid format.");
				return;
			}
			queries.add(temp);
		}
		JTextArea test = new JTextArea();
		for ( String s : queries){
			test.insert(s + " ", test.getCaretPosition());
		}
		paper_search.setRightComponent(test);
		//ResultsDisplay rd = new ResultsDisplay(advancedsearch.getComponentCount());
		
		//paper_search.setRightComponent(rd.getGUI());
	
	}
	
	/**
	 * @return the main component for this class
	 */
	public JComponent getComponent(){
		return paper_search;
	}
}
