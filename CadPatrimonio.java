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

public class CadPatrimonio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeEqui;
	private JTextField numSerie;
	private JTextField textQuantidade;
	private JTextField numPatri;
	private JTextField nomeEmp;
	public int idU;
	private JTextField textDesc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadPatrimonio frame = new CadPatrimonio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void mudID(int a) {
		this.idU = a;
		
	}
	
	public CadPatrimonio() {
		
		setBounds(100, 100, 450, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Solicitar Atendimento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = Conexao.faz_conexao();
					String sql2 ="SELECT * FROM patrimonio where id_usuario=? and (status='N�o Atendido' OR status='Atendimento')";
					PreparedStatement stmt2= con.prepareStatement(sql2);
					stmt2.setInt(1, idU);
					ResultSet rs = stmt2.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Chamado aberto, aguarde atendimento \n N�o � possivel abrir outro atendimento!!");
						nomeEqui.setText("");
						numSerie.setText("");
						textQuantidade.setText("");
						numPatri.setText("");
						nomeEmp.setText("");
						textDesc.setText(" ");
					}else {
					String sql = "INSERT INTO patrimonio(nome_equipamento,numero_serie,quntidade,numero_patrimonio,nome_empresa,descricao,id_usuario) VALUES(?,?,?,?,?,?,?)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, nomeEqui.getText());
					stmt.setString(2, numSerie.getText());
					stmt.setString(3, textQuantidade.getText());
					stmt.setString(4, numPatri.getText());
					stmt.setString(5, nomeEmp.getText());
					stmt.setString(6, textDesc.getText());
					stmt.setInt(7, idU);
					stmt.execute();
					JOptionPane.showMessageDialog(null, "Chamado aberto, aguarde atendimento");
					nomeEqui.setText("");
					numSerie.setText("");
					textQuantidade.setText("");
					numPatri.setText("");
					nomeEmp.setText("");
					textDesc.setText(" ");
				}
					con.close();
					stmt2.close();
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		nomeEqui = new JTextField();
		nomeEqui.setColumns(10);
		
		numSerie = new JTextField();
		numSerie.setColumns(10);
		
		textQuantidade = new JTextField();
		textQuantidade.setColumns(10);
		
		numPatri = new JTextField();
		numPatri.setColumns(10);
		
		nomeEmp = new JTextField();
		nomeEmp.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome do equipamento:");
		
		JLabel lblNewLabel_1 = new JLabel("Numero de serie:");
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		
		JLabel lblNewLabel_3 = new JLabel("Nome da empresa:");
		
		JLabel lblNewLabel_4 = new JLabel("Numero do Patrimonio:");
		
		JLabel lblNewLabel_5 = new JLabel("De uma descri\u00E7\u00E3o sobre o problema:");
		
		textDesc = new JTextField();
		textDesc.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel)
								.addComponent(nomeEqui)
								.addComponent(lblNewLabel_1)
								.addComponent(numSerie)
								.addComponent(lblNewLabel_2)
								.addComponent(textQuantidade)
								.addComponent(lblNewLabel_4)
								.addComponent(numPatri)
								.addComponent(lblNewLabel_3)
								.addComponent(nomeEmp, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
								.addComponent(lblNewLabel_5)
								.addComponent(textDesc)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(115)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nomeEqui, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(numSerie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(numPatri, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(nomeEmp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textDesc, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
