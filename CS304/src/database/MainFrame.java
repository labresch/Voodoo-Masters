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

import database.Login.UserStatus;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.CardLayout;

public class MainFrame extends JFrame {

	private JPanel mainPanel, infopanel;
	private final JToolBar mainToolBar = new JToolBar();
	private PaperSearch ps;
	private Login lg;
	private SignUp sign;
	private Subscriptions subs;
	private JComponent psBox, lgBox, subsBox, asBox, signBox; 
	private AuthorSearch as;
	private JLabel statusbar;
	private UserStatus uStatus = UserStatus.NONSUBSCRIBER;
	private JButton tb_login = new JButton("Login");
	private JButton tb_subscriptions, tb_signup;
	
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
		
		ps = new PaperSearch();
		psBox = ps.getComponent();
		
		lg = new Login(this);
		lgBox = lg.getComponent();
		
		sign = new SignUp();
		signBox = sign.getComponent();
		
		subs = new Subscriptions();
		subsBox = subs.getComponent();
		
		as = new AuthorSearch();
		asBox = as.getComponent();
	
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
		JButton tb_papers = new JButton("Search Papers");
		tb_papers.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				CardLayout cl = (CardLayout) infopanel.getLayout();
				cl.show(infopanel, "Paper");
			}
		});
		JButton tb_journals = new JButton("Search Journals");
		JButton tb_publishers = new JButton("Search Publishers");
		JButton tb_authors = new JButton("Browse Authors");
		tb_authors.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				CardLayout cl = (CardLayout) infopanel.getLayout();
				cl.show(infopanel, "Author");
			}
		});
		tb_subscriptions = new JButton("Subscriptions");
		tb_subscriptions.setVisible(false);
		tb_subscriptions.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				CardLayout cl = (CardLayout) infopanel.getLayout();
				cl.show(infopanel, "Subscriptions");
			}
		});
		
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
		tb_signup = new JButton("Sign Up!");
		tb_signup.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				CardLayout cl = (CardLayout) infopanel.getLayout();
				cl.show(infopanel, "SignUp");
			}
		});
		mainToolBar.add(tb_quit);
		mainToolBar.add(tb_papers);
		mainToolBar.add(tb_journals);
		mainToolBar.add(tb_publishers);
		mainToolBar.add(tb_authors);
		mainToolBar.add(tb_subscriptions);
		mainToolBar.add(Box.createHorizontalGlue());
		mainToolBar.add(tb_signup);
		mainToolBar.add(tb_login);
		mainPanel.add(mainToolBar, BorderLayout.NORTH);
		
		statusbar = new JLabel("Status OK");
		statusbar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		mainPanel.add(statusbar, BorderLayout.SOUTH);
		
		
		JPanel welcome = new JPanel();
		welcome.add(new JLabel("Welcome to the Database"));
		
		infopanel = new JPanel();
		mainPanel.add(infopanel, BorderLayout.CENTER);
		infopanel.setLayout(new CardLayout(0, 0));
		
	//	infopanel.add(welcome, "Welcome");
		infopanel.add(psBox, "Paper");
		infopanel.add(lgBox, "Login");
		infopanel.add(subsBox, "Subscriptions");
		infopanel.add(asBox, "Author");
		infopanel.add(signBox, "SignUp");
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
		if (us.equals(UserStatus.ADMIN)) {
			adminView();
			statusbar.setText("Status OK: Signed in as Admin");
			tb_login.setText("Logout");
		}
		if (us.equals(UserStatus.PUBLISHER)) {
			publisherView();
			statusbar.setText("Status OK: Signed in as Publisher");
			tb_login.setText("Logout");
		}
		if (us.equals(UserStatus.SUBSCRIBER)) {
			subscriberView();
			statusbar.setText("Status OK: Signed in as Subscriber");
			tb_login.setText("Logout");
		}
		if (us.equals(UserStatus.NONSUBSCRIBER)) {
			generalView();
			statusbar.setText("Status OK");
			tb_login.setText("Login");
		}
	}
	private void logout() {
		updateUserStatus(UserStatus.NONSUBSCRIBER);
		homeView();
	}

	public void homeView() {
		CardLayout cl = (CardLayout) infopanel.getLayout();
		cl.show(infopanel, "Paper");
	}
	
	private void adminView() {
		tb_subscriptions.setVisible(false);
		tb_signup.setVisible(false);
	}
	private void publisherView() {
		tb_subscriptions.setVisible(false);
		tb_signup.setVisible(false);
	}
	private void subscriberView() {
		tb_subscriptions.setVisible(true);
		tb_signup.setVisible(false);
	}
	private void generalView() {
		tb_subscriptions.setVisible(false);
		tb_signup.setVisible(true);
	}
	
}
