package nota3_exe1;

//imports
import java.sql.*;
import javax.swing.JOptionPane;

public class conexao_banco {

    //variaveis
    private final String vlm = "jdbc:mysql://localhost:3306/teste";
    private final String user = "admin";
    private final String senha = "admin";
    
    //conexao
    public Connection conecao_banco() {
        try {
            return DriverManager.getConnection(vlm, user, senha);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
            return(null);
        }
    }
}