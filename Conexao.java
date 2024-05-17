import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Conexao {

	
	  public static Connection faz_conexao() throws SQLException{
		  try {
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/aps_unip","root","1234");
		  return conexao;
	  }catch(ClassNotFoundException e) {
		  throw new SQLException(e.getException());
	  }
		  
	  }
	  
	  
}
