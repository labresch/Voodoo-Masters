package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JButton;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;

import tabviews.AuthorSearch;
import tabviews.Login;
import tabviews.MostPublished;
import tabviews.PaperRequest;
import tabviews.PaperSearch;
import tabviews.SignUp;
import tabviews.Subscriptions;
import tabviews.Tab;
import tabviews.Login.UserStatus;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.CardLayout;

public class MainFrame extends JFrame {

	private JPanel mainPanel, infopanel;
	private final JToolBar mainToolBar = new JToolBar();
	private JLabel statusbar;
	private UserStatus uStatus = UserStatus.NONSUBSCRIBER;
	private JButton tb_papersearch, tb_login, tb_logout, tb_subscriptions, tb_signup, tb_paperrequest, tb_mostpub;
	
	public static project p;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 640);
	
		set_up_menubar();
		
		mainPanel = new JPanel();
		setContentPane(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
	
		p = new project();
		//p.makeConnection();
		
		// Create the tool bar
		mainToolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		// set up tool bar buttons
		JButton tb_quit = new JButton("Exit");
		tb_quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?",
						"Exit", JOptionPane.OK_CANCEL_OPTION) == 0){
					System.exit(0);
				}	  
			}
		});
		JButton tb_journals = new JButton("Search Journals");
		JButton tb_publishers = new JButton("Search Publishers");
/*
		tb_login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				if (uStatus.equals(UserStatus.NONSUBSCRIBER)) {
				CardLayout cl = (CardLayout) infopanel.getLayout();
				cl.show(infopanel, "Login");
				}
				else {
					logout();
				}
			}
		});
		*/
		infopanel = new JPanel();
		mainPanel.add(infopanel, BorderLayout.CENTER);
		infopanel.setLayout(new CardLayout(0, 0));
		
		mainToolBar.add(tb_quit);
		tb_papersearch = addTab(new PaperSearch(), "Search Papers", true);
		mainToolBar.add(tb_journals);
		mainToolBar.add(tb_publishers);
		addTab(new AuthorSearch(), "Browse Authors", true);
		tb_subscriptions = addTab(new Subscriptions(), "Subscriptions", false);
		tb_paperrequest = addTab(new PaperRequest(), "Request", false);
		tb_mostpub = addTab(new MostPublished(), "Most Published", false);
		mainToolBar.add(Box.createHorizontalGlue());
		tb_signup = addTab(new SignUp(), "Sign Up!", true);
		tb_login = addTab(new Login(this), "Login", true);
		tb_logout = addTab(new Login(this), "Logout", false);
		tb_logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				logout();
			}
		});
		mainPanel.add(mainToolBar, BorderLayout.NORTH);
		
		statusbar = new JLabel("Status OK");
		statusbar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		mainPanel.add(statusbar, BorderLayout.SOUTH);
		
		
		JPanel welcome = new JPanel();
		welcome.add(new JLabel("Welcome to the Database"));
		
		
	//	infopanel.add(welcome, "Welcome");
	}
	
	/**
	 * initialize menubar at top of screen
	 */
	private void set_up_menubar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu_file = new JMenu("File");
		JMenuItem menu_quit = new JMenuItem("Exit");
		
		JMenu menu_edit = new JMenu("Edit");
		
		menuBar.add(menu_file);
		menu_file.add(menu_quit);
		menuBar.add(menu_edit);

		setJMenuBar(menuBar);
	}	
	public void updateUserStatus(UserStatus us){
		uStatus = us;
		if (uStatus.equals(UserStatus.ADMIN)) {
			adminView();

		}
		if (uStatus.equals(UserStatus.PUBLISHER)) {
			publisherView();
		}
		if (uStatus.equals(UserStatus.SUBSCRIBER)) {
			subscriberView();
		}
		if (uStatus.equals(UserStatus.NONSUBSCRIBER)) {
			generalView();
		}
	}
	private void logout() {
		updateUserStatus(UserStatus.NONSUBSCRIBER);
		homeView();
	}

	public void homeView() {
		tb_papersearch.doClick();
	}
	
	private void adminView() {
		statusbar.setText("Status OK: Signed in as Admin");
		tb_subscriptions.setVisible(false);
		tb_signup.setVisible(false);
		tb_paperrequest.setVisible(false);
		tb_mostpub.setVisible(false);
		tb_logout.setVisible(true);
		tb_login.setVisible(false);
	}
	private void publisherView() {
		statusbar.setText("Status OK: Signed in as Publisher");
		tb_subscriptions.setVisible(false);
		tb_signup.setVisible(false);
		tb_paperrequest.setVisible(false);
		tb_mostpub.setVisible(false);
		tb_logout.setVisible(true);
		tb_login.setVisible(false);
	}
	private void subscriberView() {
		statusbar.setText("Status OK: Signed in as Subscriber");
		tb_subscriptions.setVisible(true);
		tb_signup.setVisible(false);
		tb_paperrequest.setVisible(true);
		tb_mostpub.setVisible(true);
		tb_logout.setVisible(true);
		tb_login.setVisible(false);
	}
	private void generalView() {
		statusbar.setText("Status OK");
		tb_subscriptions.setVisible(false);
		tb_signup.setVisible(true);
		tb_paperrequest.setVisible(false);
		tb_mostpub.setVisible(false);
		tb_logout.setVisible(false);
		tb_login.setVisible(true);
	}
	
	private JButton addTab(Tab tab, final String label, boolean visible) {
		JComponent box = tab.getComponent();
		JButton button = new JButton(label);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				CardLayout cl = (CardLayout) infopanel.getLayout();
				cl.show(infopanel, label);
			}
		});
		button.setVisible(visible);
		mainToolBar.add(button);
		infopanel.add(box, label);
		return button;
	}
}
