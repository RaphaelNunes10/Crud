package nota3_exe1;

//imports
import java.sql.*;
import javax.swing.JOptionPane;

public class insert_banco {
    
    //Referencia a classe conexao
    conexao_banco bk = new conexao_banco();

    //funcao de insert
    public String inserte_banco(String entrada) {
        String sql = "insert into teste values (default, '" + entrada + "');";
        Connection banco = bk.conecao_banco();
        try {
            Statement tabela = banco.createStatement();
            tabela.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Inserindo no registro: " + entrada);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return null;
    }
}
