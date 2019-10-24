package nota3_exe1;

//import
import javax.swing.JOptionPane;

public class teste_conexao {
    
    //referencia a classe
    conexao_banco bk = new conexao_banco();

    //funcao de conexao
    public boolean teste_banco_conexao() {
         if(bk != null) {
            JOptionPane.showMessageDialog(null, "Conexao feita");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
            return false;
         }
    }
}
