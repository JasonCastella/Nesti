package nesti;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Connection {

	private JFrame frame;
	private JTextField idCo;
	private JPasswordField pwdCo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection window = new Connection();
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
	public Connection() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 400, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		idCo = new JTextField();
		idCo.setHorizontalAlignment(SwingConstants.CENTER);
		idCo.setBounds(162, 200, 200, 30);
		frame.getContentPane().add(idCo);
		idCo.setColumns(10);

		JLabel titleCo = new JLabel("Nesti");
		titleCo.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 72));
		titleCo.setHorizontalAlignment(SwingConstants.CENTER);
		titleCo.setBounds(50, 70, 284, 70);
		frame.getContentPane().add(titleCo);

		JLabel textIDCo = new JLabel("Identifiant :");
		textIDCo.setHorizontalAlignment(SwingConstants.CENTER);
		textIDCo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textIDCo.setBounds(22, 200, 140, 30);
		frame.getContentPane().add(textIDCo);

		JLabel textPwdCo = new JLabel("Mot de passe :");
		textPwdCo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textPwdCo.setHorizontalAlignment(SwingConstants.CENTER);
		textPwdCo.setBounds(22, 260, 140, 30);
		frame.getContentPane().add(textPwdCo);

		pwdCo = new JPasswordField();
		pwdCo.setHorizontalAlignment(SwingConstants.CENTER);
		pwdCo.setBounds(162, 260, 200, 30);
		frame.getContentPane().add(pwdCo);

		JLabel lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblError.setBounds(0, 330, 384, 30);
		frame.getContentPane().add(lblError);

		JButton subscribe = new JButton("Cliquez ici pour vous inscrire");
		subscribe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Subscribe sub = new Subscribe();
				frame.setVisible(false);
			}
		});
		subscribe.setHorizontalAlignment(SwingConstants.CENTER);
		subscribe.setFont(new Font("NSimSun", Font.ITALIC, 16));
		subscribe.setBounds(50, 450, 284, 30);
		subscribe.setBorderPainted(false);
		subscribe.setContentAreaFilled(false);
		subscribe.setOpaque(false);
		frame.getContentPane().add(subscribe);

		JButton connection = new JButton("Se connecter");
		connection.addActionListener((e) -> {
			User user;
			if (idCo.getText().contains("@")) {
				user = QueryUser.findUser("email", idCo.getText());
			}else {
				user = QueryUser.findUser("user_name", idCo.getText());
			}
			if (user!=null && user.getPassword().equals(pwdCo.getText())) {
				lblError.setText("");
				Information info = new Information(user);
				frame.setVisible(false);
			} else {
				lblError.setText("Paramètres de connexion invalide");
			}
		});
		connection.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		connection.setBounds(100, 400, 184, 30);
		frame.getContentPane().add(connection);

	}

}
