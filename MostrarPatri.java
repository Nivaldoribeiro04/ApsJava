import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class MostrarPatri extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField textNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarPatri frame = new MostrarPatri();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public MostrarPatri() {
		
		setBounds(100, 100, 1382, 526);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setContentPane(contentPane);
		
		JScrollBar scrollBar = new JScrollBar();
		
		JTextArea textArea = new JTextArea();
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Digite o Nome do Usu\u00E1rio que deseja buscar:");
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idU;
					Connection con = Conexao.faz_conexao();
					String sql = "SELECT * FROM usuario where nome=?";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, textNome.getText());

					ResultSet rs = stmt.executeQuery();
					
				
					
					if(rs.next()) {
						idU = rs.getInt(1);
						String sql2 = "SELECT * FROM patrimonio where id_usuario=?";
						PreparedStatement stmt2 = con.prepareStatement(sql2);
						stmt2.setInt(1, idU);
						ResultSet rs2 = stmt2.executeQuery();
					while(rs2.next()) {
						textArea.append("Nome do Equimamento:   "+rs2.getString("nome_equipamento")+"   ");
						textArea.append("Numero de Serie:   "+rs2.getString("numero_serie")+"   ");
						textArea.append("Quantidade:   "+rs2.getString("quntidade")+"   ");
						textArea.append("Numero do Patrimonio:   "+rs2.getString("numero_patrimonio")+"   ");
						textArea.append("Nome da Empresa:   "+rs2.getString("nome_empresa")+"   "+"\n");
						
					}}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textNome, GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton))
								.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
