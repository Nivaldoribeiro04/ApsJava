import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Atendimento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public String nome;
	public int idU;
	
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Atendimento frame = new Atendimento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	
	public void mudNome(String a) {
		this.nome = a;
		
	}
	
	
	public void mudId(int a) {
		this.idU = a;
		
	}
	
	
	
	public Atendimento() {
	
		setVisible(true);
		
		setBounds(100, 100, 747, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nome do Equipamento: ");
		
		JLabel lblNewLabel_1 = new JLabel("Numero de serie: ");
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade: ");
		
		JLabel lblNewLabel_3 = new JLabel("Numero de Patrimonio: ");
		
		JLabel lblNewLabel_4 = new JLabel("Nome da Empresa: ");
		
		JLabel lblNewLabel_5 = new JLabel("Descri\u00E7\u00E3o: ");
		
		JLabel lblNewLabel_6 = new JLabel("Favor ao pegar o Atendimento n\u00E3o fechar a pagina!!!");
		
		
		JButton btnNewButton = new JButton("Pegar o Atendimento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "UPDATE patrimonio "
							+ "SET status = 'Em Atendimento' "
							+ "WHERE id =?;";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1, idU);
					stmt.execute();
					JOptionPane.showMessageDialog(null, "Atendimento iniciado!");
					con.close();
					stmt.close();
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Finalizar o Atendimento");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = Conexao.faz_conexao();
					String sql3 = "UPDATE patrimonio "
							+ "SET status = 'Finalizado' "
							+ "WHERE id =?;";
					PreparedStatement stmt3 = con.prepareStatement(sql3);
					stmt3.setInt(1, idU);
					stmt3.execute();
					JOptionPane.showMessageDialog(null, "Atendimento Finalizado!");
					con.close();
					stmt3.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblNome = new JLabel("New label");
		JLabel nomeEq = new JLabel("New label");
		
		JLabel numSerie = new JLabel("New label");
		
		JLabel quantidade1 = new JLabel("New label");
		
		JLabel patrimonio1 = new JLabel("New label");
		
		JLabel emp = new JLabel("New label");
		
		JLabel descr = new JLabel("New label");
		
		JButton btnNewButton_2 = new JButton("Mostrar dados");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = Conexao.faz_conexao();
					String sqla ="SELECT usuario.nome,patrimonio.nome_equipamento, patrimonio.numero_serie,patrimonio.quntidade,patrimonio.numero_patrimonio,patrimonio.nome_empresa,patrimonio.descricao,patrimonio.status "
							+ "FROM patrimonio"
							+ "	INNER JOIN usuario"
							+ "	ON usuario.ID = patrimonio.id_usuario"
							+" WHERE patrimonio.status='Não Atendido' and usuario.nome=?;";
					PreparedStatement stmt2 = con.prepareStatement(sqla);
					stmt2.setString(1, nome);
					ResultSet rsa = stmt2.executeQuery();
					if(rsa.next()) {
						lblNome.setText(rsa.getString("usuario.nome"));
						nomeEq.setText(rsa.getString("patrimonio.nome_equipamento"));
						numSerie.setText(rsa.getString("patrimonio.numero_serie"));
						quantidade1.setText(rsa.getString("patrimonio.quntidade"));
						patrimonio1.setText(rsa.getString("patrimonio.numero_patrimonio"));
						emp.setText(rsa.getString("patrimonio.nome_empresa"));
						descr.setText(rsa.getString("patrimonio.descricao"));
						
					}
					con.close();
					stmt2.close();
				} catch (SQLException p) {
					// TODO Auto-generated catch block
					p.printStackTrace();
				}
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(148)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_1))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(descr, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(emp, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(quantidade1, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(numSerie, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(nomeEq, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_3)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(patrimonio1, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(241)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(487, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(lblNome))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(nomeEq))
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(numSerie))
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(quantidade1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(patrimonio1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(emp))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(descr))
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(26)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		contentPane.setLayout(gl_contentPane);
	}
}
