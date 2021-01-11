package nesti;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Modify {

	private JFrame frame;
	private JTextField lastNameMod;
	private JTextField firstNameMod;
	private JTextField cityMod;
	private JTextField userNameMod;
	private JTextField emailMod;
	private JTextField pwdMod;
	private JTextField pwd2Mod;
	private User user;

	/**
	 * Create the application.
	 */
	public Modify(User userBis) {
		user = userBis;
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

		JLabel titleMod = new JLabel("Modifier mes Informations");
		titleMod.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 26));
		titleMod.setHorizontalAlignment(SwingConstants.CENTER);
		titleMod.setBounds(0, 10, 384, 30);
		frame.getContentPane().add(titleMod);

		JLabel textLastNameMod = new JLabel("Nom :");
		textLastNameMod.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textLastNameMod.setHorizontalAlignment(SwingConstants.CENTER);
		textLastNameMod.setBounds(92, 45, 200, 20);
		frame.getContentPane().add(textLastNameMod);

		lastNameMod = new JTextField();
		lastNameMod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lastNameMod.setText("");
			}
		});
		lastNameMod.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameMod.setBounds(92, 65, 200, 30);
		frame.getContentPane().add(lastNameMod);
		lastNameMod.setColumns(10);
		lastNameMod.setText(user.getLastName());

		JLabel textNameMod = new JLabel("Pr\u00E9nom :");
		textNameMod.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textNameMod.setHorizontalAlignment(SwingConstants.CENTER);
		textNameMod.setBounds(92, 100, 200, 20);
		frame.getContentPane().add(textNameMod);

		firstNameMod = new JTextField();
		firstNameMod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				firstNameMod.setText("");
			}
		});
		firstNameMod.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameMod.setBounds(92, 120, 200, 30);
		frame.getContentPane().add(firstNameMod);
		firstNameMod.setColumns(10);
		firstNameMod.setText(user.getFirstName());

		JLabel textCityMod = new JLabel("Ville :");
		textCityMod.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textCityMod.setHorizontalAlignment(SwingConstants.CENTER);
		textCityMod.setBounds(92, 155, 200, 20);
		frame.getContentPane().add(textCityMod);

		cityMod = new JTextField();
		cityMod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cityMod.setText("");
			}
		});
		cityMod.setHorizontalAlignment(SwingConstants.CENTER);
		cityMod.setBounds(92, 175, 200, 30);
		frame.getContentPane().add(cityMod);
		cityMod.setColumns(10);
		cityMod.setText(user.getCity());

		JLabel textUserNameMod = new JLabel("Nom d'utilisateur :");
		textUserNameMod.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textUserNameMod.setHorizontalAlignment(SwingConstants.CENTER);
		textUserNameMod.setBounds(92, 210, 200, 20);
		frame.getContentPane().add(textUserNameMod);

		userNameMod = new JTextField();
		userNameMod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userNameMod.setText("");
			}
		});
		userNameMod.setHorizontalAlignment(SwingConstants.CENTER);
		userNameMod.setBounds(92, 230, 200, 30);
		frame.getContentPane().add(userNameMod);
		userNameMod.setColumns(10);
		userNameMod.setText(user.getUserName());

		JLabel textEmailMod = new JLabel("E-mail :");
		textEmailMod.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textEmailMod.setHorizontalAlignment(SwingConstants.CENTER);
		textEmailMod.setBounds(92, 265, 200, 20);
		frame.getContentPane().add(textEmailMod);

		emailMod = new JTextField();
		emailMod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				emailMod.setText("");
			}
		});
		emailMod.setHorizontalAlignment(SwingConstants.CENTER);
		emailMod.setBounds(92, 285, 200, 30);
		frame.getContentPane().add(emailMod);
		emailMod.setColumns(10);
		emailMod.setText(user.getEmail());

		JLabel textPwd2Mod = new JLabel("Confirmer le mot de passe :");
		textPwd2Mod.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textPwd2Mod.setHorizontalAlignment(SwingConstants.CENTER);
		textPwd2Mod.setBounds(92, 375, 200, 20);
		frame.getContentPane().add(textPwd2Mod);
		textPwd2Mod.setVisible(false);

		pwd2Mod = new JPasswordField();
		pwd2Mod.setHorizontalAlignment(SwingConstants.CENTER);
		pwd2Mod.setBounds(92, 395, 200, 30);
		frame.getContentPane().add(pwd2Mod);
		pwd2Mod.setColumns(10);
		pwd2Mod.setVisible(false);
		pwd2Mod.setText(user.getPassword());

		JLabel textPwdMod = new JLabel("Mot de passe");
		textPwdMod.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textPwdMod.setHorizontalAlignment(SwingConstants.CENTER);
		textPwdMod.setBounds(92, 320, 200, 20);
		frame.getContentPane().add(textPwdMod);

		pwdMod = new JPasswordField();
		pwdMod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pwdMod.setText("");
				textPwdMod.setText("Nouveau mot de passe :");
				pwd2Mod.setText("");
				pwd2Mod.setVisible(true);
				textPwd2Mod.setVisible(true);
			}
		});
		pwdMod.setHorizontalAlignment(SwingConstants.CENTER);
		pwdMod.setBounds(92, 340, 200, 30);
		frame.getContentPane().add(pwdMod);
		pwdMod.setColumns(10);
		pwdMod.setText(user.getPassword());

		JLabel lblErrorMod = new JLabel("");
		lblErrorMod.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblErrorMod.setForeground(Color.RED);
		lblErrorMod.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMod.setBounds(0, 433, 380, 30);
		frame.getContentPane().add(lblErrorMod);

		JButton btnReturnMod = new JButton("Enregistrer");
		btnReturnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User usernameTest;
				User emailTest;
				usernameTest = QueryUser.findUser("user_name", userNameMod.getText());
				emailTest = QueryUser.findUser("email", emailMod.getText());
				if (usernameTest == null || user.getUserName().equals(userNameMod.getText())) {
					if (emailTest == null || user.getEmail().equals(emailMod.getText())) {
						int res = update();
						if (res == 0) {
							QueryUser.updateUser(user);
							Information info = new Information(user);
							frame.setVisible(false);
						} else if (res == 1) {
							lblErrorMod.setText("Nom d'utilisateur non conforme");
						} else if (res == 2) {
							lblErrorMod.setText("Adresse email non conforme");
						} else if (res == 3) {
							lblErrorMod.setText("Mot de passe faible");
						} else if (res == 4) {
							lblErrorMod.setText("Confirmation du mot de passe non valide");
						}
					} else {
						lblErrorMod.setText("");
						lblErrorMod.setText("Adresse mail déjà utilisé");
					}
				} else {
					lblErrorMod.setText("");
					lblErrorMod.setText("Nom d'utilisateur déjà utilisé");
				}
			}
		});
		btnReturnMod.setBounds(21, 470, 150, 30);
		frame.getContentPane().add(btnReturnMod);

		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Information info = new Information(user);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(213, 470, 150, 30);
		frame.getContentPane().add(btnNewButton);
	}

	public int update() {
		int res = 0;
		// res = 0 ok update
		// res = 1 username non conforme
		// res = 2 email non conforme
		// res = 3 mot de passe "faible"
		// res = 4 mot de passe de confirmation non valide
		user.setLastName(lastNameMod.getText());
		user.setFirstName(firstNameMod.getText());
		user.setCity(cityMod.getText());
		if (Validator.usernameIsValid(userNameMod.getText())) {
			user.setUserName(userNameMod.getText());
		} else {
			res = 1;
		}
		if (Validator.emailIsValid(emailMod.getText())) {
			user.setEmail(emailMod.getText());
		} else {
			res = 2;
		}
		if (pwdMod.getText().equals(pwd2Mod.getText())) {
			if (Validator.pwdIsValid(pwdMod.getText())) {
				user.setPassword(pwdMod.getText());
			} else {
				res = 3;
			}
		} else {
			res = 4;
		}
		return res;
	}
}
