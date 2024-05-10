import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ChatSuporte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_msg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatSuporte frame = new ChatSuporte();
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
	public ChatSuporte() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 456);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setForeground(Color.GRAY);
		scrollBar.setBackground(Color.GRAY);
		scrollBar.setBounds(426, 43, 17, 328);
		contentPane.add(scrollBar);
		
		txt_msg = new JTextField();
		txt_msg.setBounds(10, 382, 317, 27);
		contentPane.add(txt_msg);
		txt_msg.setColumns(10);
		
		JButton btn_enviar = new JButton("Enviar");
		btn_enviar.setBounds(337, 383, 106, 25);
		contentPane.add(btn_enviar);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(10, 11, 416, 21);
		contentPane.add(lblNewLabel);
		
		JTextArea msg_area = new JTextArea();
		msg_area.setBackground(Color.WHITE);
		msg_area.setBounds(10, 43, 416, 328);
		contentPane.add(msg_area);
		
		txt_msg = new JTextField();
		txt_msg.setBounds(10, 385, 317, 23);
		contentPane.add(txt_msg);
		txt_msg.setColumns(10);
	}
}
