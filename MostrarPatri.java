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
	public String a;
	public String b;
	public String c;
	public String d;
	public String n;
	public String k;
	public String i;
	public int l;
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
		
		setBounds(100, 100, 1496, 512);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setContentPane(contentPane);
		
		JScrollBar scrollBar = new JScrollBar();
		
		JTextArea textArea = new JTextArea(8,8);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textArea.setLineWrap(true);
		JLabel lblNewLabel = new JLabel("Digite o Nome do Usu\u00E1rio que deseja atender:");
		
		JButton btnNewButton = new JButton("Atender");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = Conexao.faz_conexao();
				
					String sqla ="SELECT patrimonio.id,usuario.nome,patrimonio.nome_equipamento, patrimonio.numero_serie,patrimonio.quntidade,patrimonio.numero_patrimonio,patrimonio.nome_empresa,patrimonio.descricao,patrimonio.status "
							+ "FROM patrimonio"
							+ "	INNER JOIN usuario"
							+ "	ON usuario.ID = patrimonio.id_usuario"
							+" WHERE patrimonio.status='Não Atendido' and usuario.nome=?;";
					PreparedStatement stmt2 = con.prepareStatement(sqla);
					stmt2.setString(1, textNome.getText());
					ResultSet rsa = stmt2.executeQuery();
					if(rsa.next()) {
						Atendimento telaAtendimento = new Atendimento();
						telaAtendimento.setLocationRelativeTo(null);
						telaAtendimento.mudNome(rsa.getString("usuario.nome"));
						telaAtendimento.mudId(rsa.getInt("patrimonio.id"));
						textArea.setText(" ");
					}
					else {
						JOptionPane.showMessageDialog(null,"Impossivel realizar o atendimento \nPor favor verifique o usuário digitado!");
					}
					con.close();
					stmt2.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Buscar Atendimento");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection con = Conexao.faz_conexao();
					
					String sql ="SELECT usuario.nome,patrimonio.nome_equipamento, patrimonio.numero_serie,patrimonio.quntidade,patrimonio.numero_patrimonio,patrimonio.nome_empresa,patrimonio.descricao,patrimonio.status "
							+ "FROM patrimonio"
							+ "	INNER JOIN usuario"
							+ "	ON usuario.ID = patrimonio.id_usuario"
							+" WHERE status='Não Atendido' OR status='Em Atendimento';";
					
					PreparedStatement stmt = con.prepareStatement(sql);

					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()) {
						textArea.setText(" ");
						textArea.append("Status:  "+rs.getString("status")+"  ");
						textArea.append("Nome do usuário:   "+rs.getString("nome")+"  ");
						textArea.append("Nome do Equimamento:   "+rs.getString("nome_equipamento")+"  ");
						textArea.append("Numero de Serie:   "+rs.getString("numero_serie")+"  ");
						textArea.append("Quantidade:   "+rs.getString("quntidade")+"   ");
						textArea.append("Numero do Patrimonio:   "+rs.getString("numero_patrimonio")+"  ");
						textArea.append("Nome da Empresa:   "+rs.getString("nome_empresa")+"  ");
						textArea.append("Descrição do defeito:   "+rs.getString("descricao")+" "+"\n"+"\n"+"\n");
						
					}
					con.close();
					stmt.close();
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textNome, GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton)
									.addGap(12))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 1324, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(23)))
					.addGap(90))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(617)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(683, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollBar, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
					.addGap(68)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(119))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
