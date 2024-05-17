import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CadastroUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField repSenha;

	
	public static void main(String[] args) {
		CadastroUser frame = new CadastroUser();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 470, 400);
		frame.setLocationRelativeTo(null);
		
			
			
		
	}

	
	public CadastroUser() {
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 5, 438, 20);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("CADASTRO");
		panel.add(lblNewLabel);
		
		setTitle("Cadastro de Usuário");
        setSize(460, 360);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel labelUsuario = new JLabel("Nome do Usu\u00E1rio:");
        labelUsuario.setBounds(36, 36, 342, 20);
        JTextField campoNome = new JTextField();
        campoNome.setBounds(36, 55, 379, 20);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(36, 78, 124, 20);
        JTextField repEmail = new JTextField();
        repEmail.setBounds(36, 134, 379, 20);

        JLabel labelRepetirEmail = new JLabel("Repetir Email:");
        labelRepetirEmail.setBounds(36, 113, 124, 20);
        JTextField textEmail = new JTextField();
        textEmail.setBounds(36, 97, 379, 20);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(36, 165, 124, 20);
        JPasswordField textSenha = new JPasswordField();
        textSenha.setBounds(36, 185, 379, 20);

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		String a = textEmail.getText();
        		
        		String b = repEmail.getText();
        	
        		String c = new String(textSenha.getPassword());
        		
        		String d = new String (repSenha.getPassword());
        	
        		 if(a.equals(b)) {
        			if(c.equals(d)) {
        				try {
        					Connection con = Conexao.faz_conexao();
					
        					String sql = "INSERT INTO usuario(nome, email,senha, help_desk) VALUES(?, ?, ?,0)";
					
        					PreparedStatement stmt = con.prepareStatement(sql);
					
        					stmt.setString(1, campoNome.getText());
        					stmt.setString(2, textEmail.getText());
        					stmt.setString(3, new String(textSenha.getPassword()));
        					stmt.execute();
        					JOptionPane.showMessageDialog(null, "Usuário cadastrado, faça o seu Login para continuar");
        					campoNome.setText("");
        					textEmail.setText("");
							repEmail.setText("");
							textSenha.setText("");
							repSenha.setText("");
							con.close();
							stmt.close();
        					} catch (SQLException e1) {
        						// TODO Auto-generated catch block
        						e1.printStackTrace();
        					}
        				}else {
        					JOptionPane.showMessageDialog(null, "A senha digitada não é a mesma, Por favor Digite novamente");
        				}
        		}else {
        			JOptionPane.showMessageDialog(null, "O Email digitado não é o mesmo, Por favor Digite novamente");
        		}
        		
        	}
        });
        botaoCadastrar.setBounds(235, 277, 131, 33);
    

        getContentPane().add(labelUsuario);
        getContentPane().add(campoNome);
        getContentPane().add(labelEmail);
        getContentPane().add(repEmail);
        getContentPane().add(labelRepetirEmail);
        getContentPane().add(textEmail);
        getContentPane().add(labelSenha);
        getContentPane().add(textSenha);
        JLabel label = new JLabel();
        label.setBounds(6, 155, 124, 50);
        getContentPane().add(label); 
        getContentPane().add(botaoCadastrar);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoginUser telaLoginU = new LoginUser();
        		telaLoginU.setLocationRelativeTo(null);
        	}
        });
       
        btnLogin.setBounds(87, 277, 131, 33);
        contentPane.add(btnLogin);
        
        JLabel lblRepetirSenha = new JLabel("Repetir Senha:");
        lblRepetirSenha.setBounds(36, 204, 124, 20);
        contentPane.add(lblRepetirSenha);
        
        repSenha = new JPasswordField();
        repSenha.setBounds(36, 225, 379, 20);
        contentPane.add(repSenha);

        
    }	
}
