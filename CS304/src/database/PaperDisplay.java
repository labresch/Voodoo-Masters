package database;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;

public class PaperDisplay extends JPanel {

	/**
	 * Create the panel.
	 */
	public PaperDisplay(ArrayList<String> paper) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel title = new JPanel();
		title.add(new JLabel("Paper Information"));
		title.add(Box.createHorizontalGlue());
		
		add(title);
		add(Box.createHorizontalStrut(18));
		JPanel gridlayout = new JPanel();
		
		add(gridlayout);
		add(Box.createVerticalGlue());
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridlayout.setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Title:");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		gridlayout.add(lblTitle, gbc_lblTitle);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 0;
		gridlayout.add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel lblPapertitle = new JLabel(paper.get(0));
		GridBagConstraints gbc_lblPapertitle = new GridBagConstraints();
		gbc_lblPapertitle.anchor = GridBagConstraints.WEST;
		gbc_lblPapertitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblPapertitle.gridx = 2;
		gbc_lblPapertitle.gridy = 0;
		gridlayout.add(lblPapertitle, gbc_lblPapertitle);
		
		JLabel lblAuthors = new JLabel("Author(s):");
		GridBagConstraints gbc_lblAuthors = new GridBagConstraints();
		gbc_lblAuthors.anchor = GridBagConstraints.EAST;
		gbc_lblAuthors.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthors.gridx = 0;
		gbc_lblAuthors.gridy = 1;
		gridlayout.add(lblAuthors, gbc_lblAuthors);
		
		JLabel lblPaperauthors = new JLabel(paper.get(1));
		GridBagConstraints gbc_lblPaperauthors = new GridBagConstraints();
		gbc_lblPaperauthors.anchor = GridBagConstraints.WEST;
		gbc_lblPaperauthors.insets = new Insets(0, 0, 5, 0);
		gbc_lblPaperauthors.gridx = 2;
		gbc_lblPaperauthors.gridy = 1;
		gridlayout.add(lblPaperauthors, gbc_lblPaperauthors);
		
		JLabel lblEditor = new JLabel("Editor:");
		GridBagConstraints gbc_lblEditor = new GridBagConstraints();
		gbc_lblEditor.anchor = GridBagConstraints.EAST;
		gbc_lblEditor.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditor.gridx = 0;
		gbc_lblEditor.gridy = 2;
		gridlayout.add(lblEditor, gbc_lblEditor);
		
		JLabel lblPapereditor = new JLabel(paper.get(2));
		GridBagConstraints gbc_lblPapereditor = new GridBagConstraints();
		gbc_lblPapereditor.anchor = GridBagConstraints.WEST;
		gbc_lblPapereditor.insets = new Insets(0, 0, 5, 0);
		gbc_lblPapereditor.gridx = 2;
		gbc_lblPapereditor.gridy = 2;
		gridlayout.add(lblPapereditor, gbc_lblPapereditor);
		
		JLabel lblPublicationDate = new JLabel("Publication Date:");
		lblPublicationDate.setHorizontalTextPosition(SwingConstants.LEADING);
		GridBagConstraints gbc_lblPublicationDate = new GridBagConstraints();
		gbc_lblPublicationDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblPublicationDate.gridx = 0;
		gbc_lblPublicationDate.gridy = 3;
		gridlayout.add(lblPublicationDate, gbc_lblPublicationDate);
		
		JLabel lblPaperdate = new JLabel("paperDate");
		GridBagConstraints gbc_lblPaperdate = new GridBagConstraints();
		gbc_lblPaperdate.anchor = GridBagConstraints.WEST;
		gbc_lblPaperdate.insets = new Insets(0, 0, 5, 0);
		gbc_lblPaperdate.gridx = 2;
		gbc_lblPaperdate.gridy = 3;
		gridlayout.add(lblPaperdate, gbc_lblPaperdate);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 4;
		gridlayout.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JLabel lblJournal = new JLabel("Journal:");
		lblJournal.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblJournal = new GridBagConstraints();
		gbc_lblJournal.anchor = GridBagConstraints.EAST;
		gbc_lblJournal.insets = new Insets(0, 0, 5, 5);
		gbc_lblJournal.gridx = 0;
		gbc_lblJournal.gridy = 5;
		gridlayout.add(lblJournal, gbc_lblJournal);
		
		JLabel lblPaperjournal = new JLabel("paperJournal");
		GridBagConstraints gbc_lblPaperjournal = new GridBagConstraints();
		gbc_lblPaperjournal.anchor = GridBagConstraints.WEST;
		gbc_lblPaperjournal.insets = new Insets(0, 0, 5, 0);
		gbc_lblPaperjournal.gridx = 2;
		gbc_lblPaperjournal.gridy = 5;
		gridlayout.add(lblPaperjournal, gbc_lblPaperjournal);
		
		JLabel lblJournalEdition = new JLabel("Journal Edition:");
		lblJournalEdition.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblJournalEdition = new GridBagConstraints();
		gbc_lblJournalEdition.anchor = GridBagConstraints.EAST;
		gbc_lblJournalEdition.insets = new Insets(0, 0, 5, 5);
		gbc_lblJournalEdition.gridx = 0;
		gbc_lblJournalEdition.gridy = 6;
		gridlayout.add(lblJournalEdition, gbc_lblJournalEdition);
		
		JLabel lblPaperedition = new JLabel("paperEdition");
		GridBagConstraints gbc_lblPaperedition = new GridBagConstraints();
		gbc_lblPaperedition.anchor = GridBagConstraints.WEST;
		gbc_lblPaperedition.insets = new Insets(0, 0, 5, 0);
		gbc_lblPaperedition.gridx = 2;
		gbc_lblPaperedition.gridy = 6;
		gridlayout.add(lblPaperedition, gbc_lblPaperedition);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 7;
		gridlayout.add(verticalStrut, gbc_verticalStrut);
		
		JLabel lblTopics = new JLabel("Topics:");
		lblTopics.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblTopics = new GridBagConstraints();
		gbc_lblTopics.anchor = GridBagConstraints.EAST;
		gbc_lblTopics.insets = new Insets(0, 0, 5, 5);
		gbc_lblTopics.gridx = 0;
		gbc_lblTopics.gridy = 8;
		gridlayout.add(lblTopics, gbc_lblTopics);
		
		JLabel lblPapertopics = new JLabel("paperTopics");
		GridBagConstraints gbc_lblPapertopics = new GridBagConstraints();
		gbc_lblPapertopics.insets = new Insets(0, 0, 5, 0);
		gbc_lblPapertopics.anchor = GridBagConstraints.WEST;
		gbc_lblPapertopics.gridx = 2;
		gbc_lblPapertopics.gridy = 8;
		gridlayout.add(lblPapertopics, gbc_lblPapertopics);
		
		JLabel lblReferences = new JLabel("References:");
		GridBagConstraints gbc_lblReferences = new GridBagConstraints();
		gbc_lblReferences.anchor = GridBagConstraints.EAST;
		gbc_lblReferences.insets = new Insets(0, 0, 0, 5);
		gbc_lblReferences.gridx = 0;
		gbc_lblReferences.gridy = 9;
		gridlayout.add(lblReferences, gbc_lblReferences);
		
		JLabel lblPaperreferences = new JLabel("paperReferences");
		GridBagConstraints gbc_lblPaperreferences = new GridBagConstraints();
		gbc_lblPaperreferences.anchor = GridBagConstraints.WEST;
		gbc_lblPaperreferences.gridx = 2;
		gbc_lblPaperreferences.gridy = 9;
		gridlayout.add(lblPaperreferences, gbc_lblPaperreferences);

	}

}
