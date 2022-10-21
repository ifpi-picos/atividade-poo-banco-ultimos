import Ancoragem.Cliente;
import Ancoragem.Conta;
import Ancoragem.Endereco;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Banco {
    static List<Cliente> clientes = new ArrayList<>();
    static List<Endereco> enderecos = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        List<Integer> opcoes = new ArrayList<>();
        opcoes.add(1);
        opcoes.add(2);
        opcoes.add(3);

        int opcaoEscolhida = 0;
        while (opcoes.get(opcaoEscolhida) != 3) {
            opcaoEscolhida = mostrarMenu(opcoes);
            if (opcoes.get(opcaoEscolhida) == 1) {
                cadastrarCliente();
            } else if (opcoes.get(opcaoEscolhida) == 2) {
                mostrarInformacoesClientes();
            }

        }
    }
    private static int mostrarMenu(List<Integer> opcoes) {
        Object[] optionsArray = opcoes.toArray();
        int opcaoEscolhida = JOptionPane.showOptionDialog(null, "1. cadastrar cliente \n2. lista de clientes \n3. finalizar programa \n \n \nOpções:", "Banco -alpha test-", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsArray, null);
        return opcaoEscolhida;
    }
    private static void cadastrarCliente() {
        String nomeCliente = JOptionPane.showInputDialog("nome:");
        String cpfCliente = JOptionPane.showInputDialog("cpf:");
        String estadoEndereco = JOptionPane.showInputDialog("estado:");
        String cidadeEndereco = JOptionPane.showInputDialog("cidade:");
        String bairroEndereco = JOptionPane.showInputDialog("bairro:");
        String ruaEndereco = JOptionPane.showInputDialog("rua:");
        String numeroEndereco = JOptionPane.showInputDialog("número:");
        String cepEndereco = JOptionPane.showInputDialog("cep:");
        Endereco newEndereco = new Endereco(cepEndereco, numeroEndereco, ruaEndereco, bairroEndereco, cidadeEndereco, estadoEndereco);
        Cliente newCliente = new Cliente(nomeCliente, cpfCliente);
        clientes.add(newCliente);
        enderecos.add(newEndereco);
    }
    private static void mostrarInformacoesClientes() {
        String info = "";
        for (Cliente cliente : clientes) {
            info = info + cliente.getNome() + " cpf: " + cliente.getCpf() + "\nEndereço:" + cliente.getEndereco();
        }
        JOptionPane.showMessageDialog(null, info, "Clientes", JOptionPane.PLAIN_MESSAGE);
    }

}
