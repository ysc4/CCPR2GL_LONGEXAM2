import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class SignIn{

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField txtYear;
	private JTextField txtPleaseAcceptTc;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainTwitter window = new MainTwitter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainTwitter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 191, 255));
		frame.setBounds(100, 100, 980, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(504, 0, 462, 577);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrySwing login = new TrySwing();
				login.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnLogIn.setForeground(new Color(0, 191, 255));
		btnLogIn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnLogIn.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnLogIn.setBackground(Color.WHITE);
		btnLogIn.setBounds(297, 444, 113, 25);
		panel.add(btnLogIn);
		
		JLabel lblTitle = new JLabel("See what's happening in the world right now.");
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 18));
		lblTitle.setBounds(40, 124, 370, 32);
		panel.add(lblTitle);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Jessy\\Downloads\\twitter (2).png"));
		lblNewLabel_2.setBounds(40, 56, 77, 87);
		panel.add(lblNewLabel_2);
		
		JLabel lblLogin = new JLabel("Have an account?");
		lblLogin.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblLogin.setBounds(297, 429, 113, 13);
		panel.add(lblLogin);
		
		JTextField txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255), 1, true), "Username", TitledBorder.LEFT, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setBounds(40, 166, 370, 46);
		panel.add(txtUsername);
		
		JTextField txtCapsLock = new JTextField();
		txtCapsLock.setBounds(40, 269, 227, 19);
		panel.add(txtCapsLock);
		txtCapsLock.setFont(new Font("Century Gothic", Font.PLAIN, 8));
		txtCapsLock.setForeground(Color.RED);
		txtCapsLock.setBackground(Color.WHITE);
		txtCapsLock.setBorder(null);
		
		JTextField txtShortPass = new JTextField();
		txtShortPass.setBounds(40, 269, 227, 19);
		panel.add(txtShortPass);
		txtShortPass.setFont(new Font("Century Gothic", Font.PLAIN, 8));
		txtShortPass.setForeground(Color.RED);
		txtShortPass.setBackground(Color.WHITE);
		txtShortPass.setBorder(null);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
		      char[] password = passwordField.getPassword();
		        if (password.length < 8) {
		            txtShortPass.setText("Password must contain at least 8 characters!");
		        };
		    }
		});
		
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
					txtCapsLock.setText("Caps Lock is ON");
				}
				else {
					txtCapsLock.setText(null);
				}
		}});
		passwordField.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255), 1, true), "Password", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(40, 222, 370, 46);
		panel.add(passwordField);
		
		JList month = new JList();
		month.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Month", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		month.setBounds(40, 298, 136, 46);
		panel.add(month);
		
		JComboBox Month = new JComboBox();
		Month.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "june", "July", "August", "September", "October", "November", "December"}));
		Month.setBackground(Color.WHITE);
		Month.setBounds(40, 298, 157, 46);
		panel.add(Month);
		
		JList day = new JList();
		day.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Day", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		day.setBounds(207, 298, 77, 46);
		panel.add(day);
		
		JComboBox Day = new JComboBox();
		Day.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		Day.setBackground(Color.WHITE);
		Day.setBounds(207, 298, 97, 46);
		panel.add(Day);
		
		txtYear = new JTextField();
		txtYear.setColumns(10);
		txtYear.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255), 1, true), "Year", TitledBorder.LEFT, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		txtYear.setBackground(Color.WHITE);
		txtYear.setBounds(313, 298, 97, 46);
		panel.add(txtYear);
		
		JCheckBox chckbxShowPass = new JCheckBox("Show password");
		chckbxShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxShowPass.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
				}
			}
		});
		chckbxShowPass.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		chckbxShowPass.setBackground(Color.WHITE);
		chckbxShowPass.setBounds(310, 274, 100, 21);
		panel.add(chckbxShowPass);
		
		JCheckBox chckbxTermsNCondi = new JCheckBox("Accept Terms & Condition");
		chckbxTermsNCondi.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		chckbxTermsNCondi.setBackground(Color.WHITE);
		chckbxTermsNCondi.setBounds(40, 350, 183, 21);
		panel.add(chckbxTermsNCondi);
		
		JButton btnSignUp = new JButton("Create an Account");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(chckbxTermsNCondi.isSelected())) {
					txtPleaseAcceptTc = new JTextField();
					txtPleaseAcceptTc.setHorizontalAlignment(SwingConstants.LEFT);
					txtPleaseAcceptTc.setText("Please accept T&C");
					txtPleaseAcceptTc.setForeground(Color.RED);
					txtPleaseAcceptTc.setFont(new Font("Century Gothic", Font.PLAIN, 11));
					txtPleaseAcceptTc.setBorder(null);
					txtPleaseAcceptTc.setBackground(Color.WHITE);
					txtPleaseAcceptTc.setBounds(229, 351, 157, 19);
					panel.add(txtPleaseAcceptTc);
				}
				
			
				if (txtUsername.getText() == "" || String.valueOf(passwordField.getPassword())=="") {
					JOptionPane.showMessageDialog(null, "Please complete the details needed." );
				}
				
				
				
				int year = Integer.parseInt(txtYear.getText());
				if ((2023 - year) < 18) {
					JOptionPane.showMessageDialog(null, "You must be of 18 years and above." );
				}
			
			else {
				TrySwing login = new TrySwing();
				login.frame.setVisible(true);
					frame.dispose();
			}
		}});
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnSignUp.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnSignUp.setBackground(new Color(0, 191, 255));
		btnSignUp.setBounds(40, 377, 370, 31);
		panel.add(btnSignUp);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(36, 0, 469, 577);
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setBackground(new Color(0, 191, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Jessy\\Downloads\\gasdasda.png"));
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
