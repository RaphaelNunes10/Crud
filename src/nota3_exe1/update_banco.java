package nota3_exe1;

//import
import java.sql.*;
import javax.swing.JOptionPane;

public class update_banco {
    
    //referencia a classe de conexao
    conexao_banco bk = new conexao_banco();
    select_banco confirma = new select_banco();

    //funcao de update
    public String update_tabela_banco(String entrada, String id) {
        int contador = Integer.parseInt(confirma.confirma());
        if(contador > 0) {
            String sql = "update teste set nome = '" + entrada + "' where id = '" + id + "' order by id desc limit 1;";
            Connection banco = bk.conecao_banco();
            try {
                Statement tabela = banco.createStatement();
                tabela.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Alterarndo o registro: " + id);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não existe registro a ser atualizado!");
        }
        return null;
    }
}
