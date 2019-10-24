package nota3_exe1;

//import
import javax.swing.JOptionPane;

public class Nota3_exe1 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException {
        //referencia as classes
        teste_conexao teste = new teste_conexao();
        insert_banco inserir = new insert_banco();
        update_banco atualiza = new update_banco();
        select_banco selecionar = new select_banco();
        delete_banco deletar = new delete_banco();
       
        //menu básico de entradas
        if(teste.teste_banco_conexao() == true) {
            while(true) {
                //Opções
                String entrada = JOptionPane.showInputDialog(null, "Opções: \n-0 sair\n-1 Inserir valor\n-2 Ver a tabela\n-3 Atualizar valor\n-4 delete valor: ");
                //descisão basica
                //insert
                if("0".equals(entrada)) {
                    break;
                } else if("1".equals(entrada)) {
                    while(true) {
                        entrada = JOptionPane.showInputDialog(null, "Entre com o valor(para sair digite 1): ");
                        if("1".equals(entrada)) {
                            break;
                        }
                        inserir.inserte_banco(entrada);
                    }
                //mostrar tabela
                } else if("2".equals(entrada)) {
                    selecionar.select_tabela_banco();
                //update
                } else if("3".equals(entrada)) {
                    int contador = Integer.parseInt(selecionar.confirma());
                    if(contador > 0) {
                        String id = JOptionPane.showInputDialog(null, "ID a alterar: ");
                        String valor = JOptionPane.showInputDialog(null, "Valor do campo: ");
                        atualiza.update_tabela_banco(valor, id);
                    } else {
                        JOptionPane.showMessageDialog(null, "Não existe registro a ser atualizado!");
                    }
                //delete
                } else if("4".equals(entrada)) {
                    int contador = Integer.parseInt(selecionar.confirma());
                    if(contador > 0) {
                        while(true) {
                            entrada = JOptionPane.showInputDialog(null, "Entre com o id a ser deletado(para sair digite sair): ");
                            if("sair".equals(entrada)) {
                                break;
                            }
                            deletar.delete_tabela_banco(entrada);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Não existe registro a ser deletado!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "opção desconhecida!");
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não é possivel conectar no banco!");
        }
    }   
}
