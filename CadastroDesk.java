import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CadastroDesk extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField repSenha;
	private JTextField senhaMaster;

	
	public static void main(String[] args) {
		CadastroDesk frame = new CadastroDesk();
		frame.setVisible(true);
		frame.setBounds(100, 100, 470, 400);
		frame.setLocationRelativeTo(null);
		
			
			
		
	}

	
	public CadastroDesk() {
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
		
		setTitle("Cadastro de Help Desk");
        setSize(460, 416);
        

        JLabel labelUsuario = new JLabel("Nome do Help Desk:");
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
					String sql2 = "SELECT * FROM desk where nome='Master' AND senha=?";
					PreparedStatement stmt2 = con.prepareStatement(sql2);
					stmt2.setString(1, senhaMaster.getText());
					
					ResultSet rs2 = stmt2.executeQuery();
					rs2.next();
					String s = rs2.getString(5);
					String dgSenhaM = senhaMaster.getText();
        				if(dgSenhaM.equals(s)) {
        					
        					String sql = "INSERT INTO desk(nome, email,senha, help_desk) VALUES(?, ?, ?,1)";
					
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
        				}
         				}
        				catch (SQLException e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}
        				}else {
        					JOptionPane.showMessageDialog(null, "A senha digitada não é a mesma, Por favor Digite novamente");
        				}
        		}else {
        			JOptionPane.showMessageDialog(null, "O Email digitado não é o mesmo, Por favor Digite novamente");
        		}
        	
        	
        	}});
        botaoCadastrar.setBounds(227, 321, 131, 33);
    

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
       
        btnLogin.setBounds(86, 321, 131, 33);
        contentPane.add(btnLogin);
        
        JLabel lblRepetirSenha = new JLabel("Repetir Senha:");
        lblRepetirSenha.setBounds(36, 204, 322, 20);
        contentPane.add(lblRepetirSenha);
        
        repSenha = new JPasswordField();
        repSenha.setBounds(36, 225, 379, 20);
        contentPane.add(repSenha);
        
        JLabel lblNewLabel_1 = new JLabel("Senha Master:");
        lblNewLabel_1.setBounds(36, 256, 369, 14);
        contentPane.add(lblNewLabel_1);
        
        senhaMaster = new JTextField();
        senhaMaster.setBounds(36, 281, 379, 20);
        contentPane.add(senhaMaster);
        senhaMaster.setColumns(10);

        
    }	
}
