package nota3_exe1;

//imports
import java.sql.*;
import javax.swing.JOptionPane;

public class select_banco {

    //referencia a classe
    conexao_banco bk = new conexao_banco();
    
    public String confirma() {
        String sql = "select count(*) as saida from teste limit 1";
        String saida = null;
        Connection banco = bk.conecao_banco();
        try {
            Statement tabela = banco.createStatement();
            ResultSet chamada = tabela.executeQuery(sql);
            while (chamada.next()) {
                saida = chamada.getString("saida");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return saida;
    }

    //select do banco
    public void select_tabela_banco() {
        String sql = "select * from teste order by id desc";
        Connection banco = bk.conecao_banco();
        try {
            Statement tabela = banco.createStatement();
            ResultSet chamada = tabela.executeQuery(sql);
            String mensagem = "";
            while (chamada.next()) {
                String id = chamada.getString("id");
                String nome = chamada.getString("nome");
                String barra = "\n---------------------------------------\n";
                mensagem = "id: " + id + "\nNome: " + nome + barra + mensagem;
            }
            if("".equals(mensagem)) {
                JOptionPane.showMessageDialog(null, "Nenhum registro!");
            } else {
                JOptionPane.showMessageDialog(null, mensagem);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }      
    }
}
