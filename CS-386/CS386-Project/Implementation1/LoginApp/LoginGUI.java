package helloworld_mvn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI {

	private JFrame frame;
	private JTextField usernameTextField;
	private JTextField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
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
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblForUsername = new JLabel("Enter Username: ");
		lblForUsername.setBounds(52, 64, 115, 25);
		frame.getContentPane().add(lblForUsername);
		
		JLabel lblForPassword = new JLabel("Enter Password: ");
		lblForPassword.setBounds(52, 136, 115, 25);
		frame.getContentPane().add(lblForPassword);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(169, 63, 188, 26);
		frame.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(169, 135, 188, 26);
		frame.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JLabel lblResponse = new JLabel("A Response", SwingConstants.CENTER);
		lblResponse.setBounds(52, 21, 328, 16);
		frame.getContentPane().add(lblResponse);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				
				AccountClass account = new AccountClass();
				boolean registerStatus = account.registerAccount(username, password);
				System.out.println(registerStatus);
				lblResponse.setText("Account registration was successful = " + registerStatus);
			}
		});
		btnRegister.setBounds(52, 213, 117, 29);
		frame.getContentPane().add(btnRegister);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				
				AccountClass account = new AccountClass();
				boolean loginStatus = account.signIn(username, password);
				System.out.println(loginStatus);
				lblResponse.setText("Login was successful = " + loginStatus);
			}
		});
		btnLogin.setBounds(263, 213, 117, 29);
		frame.getContentPane().add(btnLogin);

	}
}
