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
	private JComponent psBox, lgBox; 
	private JLabel statusbar;
	private UserStatus uStatus = UserStatus.NONSUBSCRIBER;
	private JButton tb_login = new JButton("Login");
	
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
		
		// Create the tool bar
		mainToolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		// set up tool bar buttons
		JButton tb_quit = new JButton("Quit");
		JButton tb_papers = new JButton("Search Papers");
		tb_papers.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				CardLayout cl = (CardLayout) infopanel.getLayout();
				cl.show(infopanel, "Paper");
			}
		});
		JButton tb_journals = new JButton("Search Journals");
		JButton tb_publishers = new JButton("Search Publishers");
		JButton tb_sign_up = new JButton("Sign Up!");
		
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
		mainToolBar.add(tb_quit);
		mainToolBar.add(tb_papers);
		mainToolBar.add(tb_journals);
		mainToolBar.add(tb_publishers);
		mainToolBar.add(Box.createHorizontalGlue());
		mainToolBar.add(tb_sign_up);
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
		infopanel.add(welcome, "Welcome");
		infopanel.add(psBox, "Paper");
		infopanel.add(lgBox, "Login");
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
			statusbar.setText("Status OK: Signed in as Admin");
			tb_login.setText("Logout");
		}
		if (us.equals(UserStatus.PUBLISHER)) {
			statusbar.setText("Status OK: Signed in as Publisher");
			tb_login.setText("Logout");
		}
		if (us.equals(UserStatus.SUBSCRIBER)) {
			statusbar.setText("Status OK: Signed in as Subscriber");
			tb_login.setText("Logout");
		}
		if (us.equals(UserStatus.NONSUBSCRIBER)) {
			statusbar.setText("Status OK");
			tb_login.setText("Login");
		}
	}
	private void logout() {
		uStatus = UserStatus.NONSUBSCRIBER;
		statusbar.setText("Status OK");
		tb_login.setText("Login");
	}
}
