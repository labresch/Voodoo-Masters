package tabviews;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminModify extends Tab{
	
	private JPanel mainPanel;
	
	public AdminModify() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel pid = new JPanel();
		pid.setLayout(new BoxLayout(pid, BoxLayout.LINE_AXIS));
		pid.add(new JLabel("Paper ID:"));
		JTextField pidText = new JTextField();
		pidText.setMaximumSize(new Dimension(Integer.MAX_VALUE, pidText.getPreferredSize().height));
		pid.add(pidText);
		mainPanel.add(pid);
		
		JPanel pAttributes = new JPanel();
		pAttributes.setLayout(new BoxLayout(pAttributes, BoxLayout.LINE_AXIS));
		
		pAttributes = addCheckBox(pAttributes, "Title");
		pAttributes = addCheckBox(pAttributes, "Editor");
		pAttributes = addCheckBox(pAttributes, "Date Published");
		
		mainPanel.add(pAttributes);
		JButton modPaper = new JButton("Modify Paper");
		modPaper.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				modifyPaper();
			}
			
		});
		mainPanel.add(modPaper);
		/* ---------------------------------*/
		JPanel jid = new JPanel();
		jid.setLayout(new BoxLayout(jid, BoxLayout.LINE_AXIS));
		jid.add(new JLabel("Journal Name:"));
		JTextField jNameText = new JTextField();
		jNameText.setMaximumSize(new Dimension(Integer.MAX_VALUE, jNameText.getPreferredSize().height));
		jid.add(jNameText);
		
		jid.add(new JLabel("Edition:"));
		JTextField editText = new JTextField();
		editText.setMaximumSize(new Dimension(Integer.MAX_VALUE, editText.getPreferredSize().height));
		jid.add(editText);
		mainPanel.add(jid);
		
		JPanel jAttributes = new JPanel();
		jAttributes.setLayout(new BoxLayout(jAttributes, BoxLayout.LINE_AXIS));
		
		jAttributes = addCheckBox(jAttributes, "Journal");
		jAttributes = addCheckBox(jAttributes, "Edition");
		jAttributes = addCheckBox(jAttributes, "Access");
		jAttributes = addCheckBox(jAttributes, "Date Published");
		
		mainPanel.add(jAttributes);
		JButton modJournal = new JButton("Modify Journal");
		modJournal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				modifyJournal();
			}
			
		});
		mainPanel.add(modJournal);
		
		/* ---------------------------------*/
		JPanel aid = new JPanel();
		aid.setLayout(new BoxLayout(aid, BoxLayout.LINE_AXIS));
		aid.add(new JLabel("Author ID:"));
		JTextField aNameText = new JTextField();
		aNameText.setMaximumSize(new Dimension(Integer.MAX_VALUE, aNameText.getPreferredSize().height));
		aid.add(aNameText);
		
		mainPanel.add(aid);
		
		JPanel aAttributes = new JPanel();
		aAttributes.setLayout(new BoxLayout(aAttributes, BoxLayout.LINE_AXIS));
		
		aAttributes = addCheckBox(aAttributes, "Author ID");
		aAttributes = addCheckBox(aAttributes, "Author Name");
		
		mainPanel.add(aAttributes);
		JButton modAuthor = new JButton("Modify Author");
		modAuthor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				modifyAuthor();
			}
			
		});
		mainPanel.add(modAuthor);
		
	}

	@Override
	public JComponent getComponent() {
		return mainPanel;
	}
	
	private void modifyPaper() {
		
	}
	
	private void modifyJournal() {
		
	}
	
	private void modifyAuthor() {
		
	}

	private JPanel addCheckBox(JPanel panel, String label) {
		panel.add(new JCheckBox(label + ":"));
		JTextField jText = new JTextField();
		jText.setMaximumSize(new Dimension(Integer.MAX_VALUE, jText.getPreferredSize().height));
		panel.add(jText);
		return panel;
	}
}
