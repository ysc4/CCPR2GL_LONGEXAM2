import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class TrySwing extends MainTwitter{

	File file = new File("Remember.txt");
	int attempt = 3;
	
	JFrame frame;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private HashMap<String, String> user_pass = new HashMap<String, String>();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrySwing window = new TrySwing();
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
	public TrySwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		
		user_pass.put("jessy_02", "beomgyu123");
		user_pass.put("jassy07", "pearl5678");
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 653, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox chckbxShowPass = new JCheckBox("Show password");
		chckbxShowPass.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		chckbxShowPass.setBackground(Color.WHITE);
		chckbxShowPass.setBounds(437, 245, 138, 21);
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
		
			
		JButton btnNext = new JButton("Log In");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (attempt > 0) {
					String user = userNameField.getText();
					String pass = String.valueOf(passwordField.getPassword());
					
					if (((pass.contains(user_pass.get("jessy_02")))||((pass.contains(user_pass.get("jassy07")))))) {
						Welcome window2 = new Welcome();
						window2.frame.setVisible(true);
						frame.dispose();
							
					}
					else if (!((pass.contains(user_pass.get("jessy_02")))||((pass.contains(user_pass.get("jassy07")))))){
						--attempt;
						JTextField txtWrongUserPass = new JTextField();
						txtWrongUserPass.setBackground(Color.WHITE);
						txtWrongUserPass.setForeground(Color.RED);
						txtWrongUserPass.setFont(new Font("Roboto", Font.PLAIN, 7));
						txtWrongUserPass.setText("Wrong username or password. Please try again. Attempts left: " + attempt);
						txtWrongUserPass.setBorder(null);
						txtWrongUserPass.setBounds(204, 273, 227, 19);
						frame.getContentPane().add(txtWrongUserPass);
						txtWrongUserPass.setColumns(10);
						passwordField.setText("");
					}
				}
				if (attempt == 0) {
					JOptionPane.showMessageDialog(null, "You have reached the maximum attempts.\nPlease try again in a few minutes." );
					frame.dispose();
				}
			}
		});
		
		JTextField txtCapsLock = new JTextField();
		txtCapsLock.setFont(new Font("Century Gothic", Font.PLAIN, 8));
		txtCapsLock.setForeground(Color.RED);
		txtCapsLock.setBackground(Color.WHITE);
		txtCapsLock.setBorder(null);
		txtCapsLock.setBounds(204, 273, 227, 19);
		frame.getContentPane().add(txtCapsLock);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
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
		passwordField.setBounds(204, 231, 227, 43);
		frame.getContentPane().add(passwordField);
			
		btnNext.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnNext.setForeground(Color.WHITE);
		btnNext.setBackground(new Color(0, 191, 255));
		btnNext.setBorder(new LineBorder(new Color(0, 191, 255), 10, true));
		btnNext.setBounds(204, 313, 227, 31);
		frame.getContentPane().add(btnNext);
		frame.getContentPane().add(chckbxShowPass);
		
		JLabel lblLogIn = new JLabel("Log in to Twitter");
		lblLogIn.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setBounds(204, 130, 227, 62);
		frame.getContentPane().add(lblLogIn);
		
		userNameField = new JTextField();
		userNameField.setBackground(Color.WHITE);
		userNameField.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255), 1, true), "Username", TitledBorder.LEFT, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		userNameField.setBounds(204, 184, 227, 43);
		frame.getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		JButton btnForgotPassword = new JButton("Forgot password?");
		btnForgotPassword.setForeground(new Color(0, 191, 255));
		btnForgotPassword.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnForgotPassword.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnForgotPassword.setBackground(Color.WHITE);
		btnForgotPassword.setBounds(204, 349, 227, 31);
		frame.getContentPane().add(btnForgotPassword);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("C:\\Users\\Jessy\\Downloads\\twitter (2).png"));
		lblLogo.setBounds(243, 65, 150, 80);
		frame.getContentPane().add(lblLogo);
	
		JCheckBox chckbxRememberMe = new JCheckBox("Remember me");
		chckbxRememberMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxRememberMe.isSelected()) {
					Save();
				}
				else {
					userNameField.setText("");
					passwordField.setText("");
					
				}
			}
		});
		chckbxRememberMe.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		chckbxRememberMe.setBackground(Color.WHITE);
		chckbxRememberMe.setBounds(204, 291, 138, 21);
		frame.getContentPane().add(chckbxRememberMe);
		
		Update();
	}
	
	public void Save(){  
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
            bw.write(userNameField.getText()); 
            bw.newLine(); 
            bw.write(String.valueOf(passwordField.getPassword())); 
            bw.close(); 
        } 
        catch (IOException e) { 
        	e.printStackTrace(); 
        }        
	}
	
	public void Update(){ 
	       try {
	         if(file.exists()){ 
	           BufferedReader read = new BufferedReader(new FileReader(file.getAbsolutePath()));  
	           userNameField.setText(read.readLine());  
	           passwordField.setText(read.readLine()); 
	           read.close();
	           }
	       	} 
	        catch (IOException e) {         
	            e.printStackTrace();
	        }                
	   }
}
