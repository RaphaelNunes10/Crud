package nota3_exe1;

//imports
import java.sql.*;
import javax.swing.JOptionPane;

public class delete_banco {
    //referencia a classe conexao
    conexao_banco bk = new conexao_banco();
    select_banco confirma = new select_banco();

    //funcao de deletar
    public String delete_tabela_banco(String entrada) {
        int contador = Integer.parseInt(confirma.confirma());
        if(contador > 0) {
            String sql = "delete from teste where id = '" + entrada + "' order by id desc limit 1;";
            Connection banco = bk.conecao_banco();
            try {
                Statement tabela = banco.createStatement();
                tabela.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Deletando o registro: " + entrada);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não existe registro a ser deletado!");
        }
        return null;
    }
}
