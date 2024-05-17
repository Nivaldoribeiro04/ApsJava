import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

public class ChatUsuario extends JFrame {

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
					ChatUsuario frame = new ChatUsuario();
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
	public ChatUsuario() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 456);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setForeground(Color.GRAY);
		scrollBar.setBackground(Color.GRAY);
		scrollBar.setBounds(426, 44, 17, 328);
		contentPane.add(scrollBar);
		
		txt_msg = new JTextField();
		txt_msg.setBounds(10, 382, 317, 27);
		contentPane.add(txt_msg);
		txt_msg.setColumns(10);
		
		JButton btn_enviar = new JButton("Enviar");
		btn_enviar.setBounds(337, 383, 106, 25);
		contentPane.add(btn_enviar);
		
		JLabel lblNewLabel = new JLabel("Suporte Desk");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(10, 11, 416, 21);
		contentPane.add(lblNewLabel);
		
		JTextArea msg_area = new JTextArea();
		msg_area.setBackground(Color.LIGHT_GRAY);
		msg_area.setBounds(10, 43, 416, 328);
		contentPane.add(msg_area);
	}
}
