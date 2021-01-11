package nesti;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Subscribe {

	private JFrame frame;
	private JTextField lastNameSub;
	private JTextField firstNameSub;
	private JTextField citySub;
	private JTextField userNameSub;
	private JTextField emailSub;
	private JTextField pwdSub;
	private JTextField pwd2Sub;

	/**
	 * Create the application.
	 */
	public Subscribe() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 400, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel titleSub = new JLabel("Inscription");
		titleSub.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 24));
		titleSub.setHorizontalAlignment(SwingConstants.CENTER);
		titleSub.setBounds(50, 10, 284, 50);
		frame.getContentPane().add(titleSub);

		JLabel textLastNameSub = new JLabel("Nom");
		textLastNameSub.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textLastNameSub.setHorizontalAlignment(SwingConstants.CENTER);
		textLastNameSub.setBounds(22, 80, 140, 30);
		frame.getContentPane().add(textLastNameSub);

		JLabel textFirstNameSub = new JLabel("Pr\u00E9nom");
		textFirstNameSub.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textFirstNameSub.setHorizontalAlignment(SwingConstants.CENTER);
		textFirstNameSub.setBounds(22, 130, 140, 30);
		frame.getContentPane().add(textFirstNameSub);

		JLabel textCitySub = new JLabel("Ville");
		textCitySub.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textCitySub.setHorizontalAlignment(SwingConstants.CENTER);
		textCitySub.setBounds(22, 180, 140, 30);
		frame.getContentPane().add(textCitySub);

		JLabel textUserNameSub = new JLabel("Nom d'utilisateur *");
		textUserNameSub.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textUserNameSub.setHorizontalAlignment(SwingConstants.CENTER);
		textUserNameSub.setBounds(22, 230, 140, 30);
		frame.getContentPane().add(textUserNameSub);

		JLabel textEmailSub = new JLabel("E-mail *");
		textEmailSub.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textEmailSub.setHorizontalAlignment(SwingConstants.CENTER);
		textEmailSub.setBounds(22, 280, 140, 30);
		frame.getContentPane().add(textEmailSub);

		JLabel textPwdSub = new JLabel("Mot de passe *");
		textPwdSub.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textPwdSub.setHorizontalAlignment(SwingConstants.CENTER);
		textPwdSub.setBounds(22, 330, 140, 30);
		frame.getContentPane().add(textPwdSub);

		JLabel textPwd2Sub = new JLabel("Confirmation *");
		textPwd2Sub.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textPwd2Sub.setHorizontalAlignment(SwingConstants.CENTER);
		textPwd2Sub.setBounds(22, 380, 140, 30);
		frame.getContentPane().add(textPwd2Sub);

		lastNameSub = new JTextField();
		lastNameSub.setBounds(162, 80, 200, 30);
		frame.getContentPane().add(lastNameSub);
		lastNameSub.setColumns(10);

		firstNameSub = new JTextField();
		firstNameSub.setBounds(162, 130, 200, 30);
		frame.getContentPane().add(firstNameSub);
		firstNameSub.setColumns(10);

		citySub = new JTextField();
		citySub.setBounds(162, 180, 200, 30);
		frame.getContentPane().add(citySub);
		citySub.setColumns(10);

		userNameSub = new JTextField();
		userNameSub.setBounds(162, 230, 200, 30);
		frame.getContentPane().add(userNameSub);
		userNameSub.setColumns(10);

		emailSub = new JTextField();
		emailSub.setBounds(162, 280, 200, 30);
		frame.getContentPane().add(emailSub);
		emailSub.setColumns(10);

		pwdSub = new JPasswordField();
		pwdSub.setBounds(162, 330, 200, 30);
		frame.getContentPane().add(pwdSub);
		pwdSub.setColumns(10);

		pwd2Sub = new JPasswordField();
		pwd2Sub.setBounds(162, 380, 200, 30);
		frame.getContentPane().add(pwd2Sub);
		pwd2Sub.setColumns(10);

		JLabel lblErrorSub = new JLabel("");
		lblErrorSub.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblErrorSub.setForeground(Color.RED);
		lblErrorSub.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorSub.setBounds(0, 418, 384, 30);
		frame.getContentPane().add(lblErrorSub);

		JButton btnRegister = new JButton("S'enregistrer");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (QueryUser.findUser("user_name", userNameSub.getText()) != null) {
					lblErrorSub.setText("");
					lblErrorSub.setText("Nom d'utilisateur déjà utilisé");
				} else if (QueryUser.findUser("email", emailSub.getText()) != null) {
					lblErrorSub.setText("");
					lblErrorSub.setText("Adresse mail déjà utilisé");
				} else if (pwdSub.getText().equals(pwd2Sub.getText())) {
					if (Validator.usernameIsValid(userNameSub.getText())) {
						if (Validator.emailIsValid(emailSub.getText())) {
							if (Validator.pwdIsValid(pwdSub.getText())) {
								lblErrorSub.setText("");
								User user = new User(lastNameSub.getText(), firstNameSub.getText(), citySub.getText(),
										userNameSub.getText(), emailSub.getText(), pwdSub.getText());
								QueryUser.createUser(user);
								Connection co = new Connection();
								frame.setVisible(false);
							} else {
								lblErrorSub.setText("");
								lblErrorSub.setText("Mot de passe non sécurisé");
							}
						} else {
							lblErrorSub.setText("");
							lblErrorSub.setText("Adresse email non conforme");
						}

					} else {
						lblErrorSub.setText("");
						lblErrorSub.setText("Nom d'utilisateur non conforme");
					}

				} else {
					lblErrorSub.setText("");
					lblErrorSub.setText("Confirmation du mot de passe non valide");
				}

			}
		});
		btnRegister.setBounds(21, 455, 150, 30);
		frame.getContentPane().add(btnRegister);

		JButton btnReturnSub = new JButton("Annuler");
		btnReturnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection co = new Connection();
				frame.setVisible(false);
			}
		});
		btnReturnSub.setBounds(213, 455, 150, 30);
		frame.getContentPane().add(btnReturnSub);

		JLabel lblMandatory = new JLabel("* Champ obligatoire pour inscription");
		lblMandatory.setHorizontalAlignment(SwingConstants.CENTER);
		lblMandatory.setBounds(0, 490, 384, 20);
		frame.getContentPane().add(lblMandatory);
	}
}
