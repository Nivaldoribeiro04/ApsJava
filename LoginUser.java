import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class LoginUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textUser;
	private JPasswordField textSenha;
	public boolean login = false;
	public String a = null;
	public String b = null;
	public int id1;
	

	
	
	
	/**
	 * Launch the application.
	 */
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUser frame = new LoginUser();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setLogin() {
		this.login= true;
	}

	

	/**
	 * Create the frame.
	 */
	public LoginUser() {
		setTitle("Login de Usu\u00E1rio");
		setFocusable(true);
		setBounds(100, 100, 411, 309);
		
		textUser = new JTextField();
		textUser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email:");
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = Conexao.faz_conexao();
					
					String sql = "SELECT * FROM usuario where (email=? AND senha=?) AND help_desk=0";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, textUser.getText());
					
					stmt.setString(2, new String(textSenha.getPassword()));
					
					ResultSet rs = stmt.executeQuery();
					
					String sql2 = "SELECT * FROM desk where (email=? AND senha=?) AND help_desk=1";
					
					PreparedStatement stmt2 = con.prepareStatement(sql2);
					
					stmt2.setString(1, textUser.getText());
					
					stmt2.setString(2, new String(textSenha.getPassword()));
					
					ResultSet rs2 = stmt2.executeQuery();
					
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Bem Vindo ao Sistema!!!");
					    a = rs.getString(2);
					    id1 = rs.getInt(1);
						ProgramaMain2 pr2 = new ProgramaMain2();
						pr2.setBounds(100, 100, 850, 500);
						pr2.setLocationRelativeTo(null);
						pr2.setVisible(true);
						pr2.setTitle(a);
						pr2.mudID(id1);
						setVisible(false);
					}else if(rs2.next()) {
						JOptionPane.showMessageDialog(null, "Bem Vindo ao Sistema, help desk");
						b = rs2.getString(2);
						ProgramaMainDesk telaDesk = new ProgramaMainDesk();
						telaDesk.setBounds(100, 100, 850, 500);
						telaDesk.setLocationRelativeTo(null);
						telaDesk.setVisible(true);
						telaDesk.setTitle(b);
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "Usuario Não Encontrado!!");
						textUser.setText(" ");
						textSenha.setText(" ");
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();	
				
			} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
		});
		
		textSenha = new JPasswordField();
		textSenha.setText("");
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(21)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblNewLabel)
									.addComponent(textUser, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
									.addComponent(textSenha)
									.addComponent(lblNewLabel_1))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(139)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);
	}
}

