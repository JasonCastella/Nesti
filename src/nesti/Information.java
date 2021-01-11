package nesti;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Information {

	private JFrame frame;
	private JTextField lastNameInfo;
	private JTextField firstNameInfo;
	private JTextField cityInfo;
	private JTextField userNameInfo;
	private JTextField emailInfo;
	private JTextField pwdInfo;
	private User user;

	// Jtext.setEditable(false);
	// Jtext.setEnable(false);
	// frame.setVisible(false);
	// JOptionPane.showMessageDialog(frame, "L'adresse email n'est pas correcte.");

	/**
	 * Create the application.
	 */
	/*
	 * public Information(String id) { user=QueryUser.readUser(id); initialize();
	 * this.frame.setVisible(true); }
	 */

	public Information(User user_modify) {
		user = user_modify;
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

		JLabel titleInfo = new JLabel("Mes Informations");
		titleInfo.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 24));
		titleInfo.setHorizontalAlignment(SwingConstants.CENTER);
		titleInfo.setBounds(50, 10, 290, 30);
		frame.getContentPane().add(titleInfo);

		JLabel textLastNameInfo = new JLabel("Nom :");
		textLastNameInfo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textLastNameInfo.setHorizontalAlignment(SwingConstants.CENTER);
		textLastNameInfo.setBounds(92, 70, 200, 20);
		frame.getContentPane().add(textLastNameInfo);

		lastNameInfo = new JTextField();
		lastNameInfo.setEditable(false);
		lastNameInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameInfo.setBounds(92, 90, 200, 30);
		frame.getContentPane().add(lastNameInfo);
		lastNameInfo.setColumns(10);
		lastNameInfo.setText(user.getLastName());

		JLabel textFirstNameInfo = new JLabel("Pr\u00E9nom :");
		textFirstNameInfo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textFirstNameInfo.setHorizontalAlignment(SwingConstants.CENTER);
		textFirstNameInfo.setBounds(92, 130, 200, 20);
		frame.getContentPane().add(textFirstNameInfo);

		firstNameInfo = new JTextField();
		firstNameInfo.setEditable(false);
		firstNameInfo.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameInfo.setBounds(92, 150, 200, 30);
		frame.getContentPane().add(firstNameInfo);
		firstNameInfo.setColumns(10);
		firstNameInfo.setText(user.getFirstName());

		JLabel textCityInfo = new JLabel("Ville :");
		textCityInfo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textCityInfo.setHorizontalAlignment(SwingConstants.CENTER);
		textCityInfo.setBounds(92, 190, 200, 20);
		frame.getContentPane().add(textCityInfo);

		cityInfo = new JTextField();
		cityInfo.setEditable(false);
		cityInfo.setHorizontalAlignment(SwingConstants.CENTER);
		cityInfo.setBounds(92, 210, 200, 30);
		frame.getContentPane().add(cityInfo);
		cityInfo.setColumns(10);
		cityInfo.setText(user.getCity());

		JLabel textUserNameInfo = new JLabel("Nom d'utilisateur :");
		textUserNameInfo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textUserNameInfo.setHorizontalAlignment(SwingConstants.CENTER);
		textUserNameInfo.setBounds(92, 250, 200, 20);
		frame.getContentPane().add(textUserNameInfo);

		userNameInfo = new JTextField();
		userNameInfo.setEditable(false);
		userNameInfo.setHorizontalAlignment(SwingConstants.CENTER);
		userNameInfo.setBounds(92, 270, 200, 30);
		frame.getContentPane().add(userNameInfo);
		userNameInfo.setColumns(10);
		userNameInfo.setText(user.getUserName());

		JLabel textEmailInfo = new JLabel("E-mail :");
		textEmailInfo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textEmailInfo.setHorizontalAlignment(SwingConstants.CENTER);
		textEmailInfo.setBounds(92, 310, 200, 20);
		frame.getContentPane().add(textEmailInfo);

		emailInfo = new JTextField();
		emailInfo.setEditable(false);
		emailInfo.setHorizontalAlignment(SwingConstants.CENTER);
		emailInfo.setBounds(92, 330, 200, 30);
		frame.getContentPane().add(emailInfo);
		emailInfo.setColumns(10);
		emailInfo.setText(user.getEmail());

		JLabel textPwdInfo = new JLabel("Mot de passe :");
		textPwdInfo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textPwdInfo.setHorizontalAlignment(SwingConstants.CENTER);
		textPwdInfo.setBounds(92, 370, 200, 20);
		frame.getContentPane().add(textPwdInfo);

		pwdInfo = new JPasswordField();
		pwdInfo.setEditable(false);
		pwdInfo.setHorizontalAlignment(SwingConstants.CENTER);
		pwdInfo.setBounds(92, 390, 200, 30);
		frame.getContentPane().add(pwdInfo);
		pwdInfo.setColumns(10);
		pwdInfo.setText(user.getPassword());

		JButton btnModify = new JButton("Modifier");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modify mod = new Modify(user);
				frame.setVisible(false);
			}
		});
		btnModify.setBounds(21, 470, 150, 30);
		frame.getContentPane().add(btnModify);

		JButton btnReturnInfo = new JButton("Retour");
		btnReturnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection co = new Connection();
				frame.setVisible(false);
			}
		});
		btnReturnInfo.setBounds(213, 470, 150, 30);
		frame.getContentPane().add(btnReturnInfo);
	}
}
