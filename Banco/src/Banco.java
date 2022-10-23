import Ancoragem.Cliente;
import Ancoragem.Conta;
import Ancoragem.Endereco;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Banco {
    public static int numid = 0;
    // Listas
    static List<Cliente> clientes = new ArrayList<>();
    static List<Endereco> enderecos = new ArrayList<>();
    // Métodos
    public static void incrementoIdCliente() {
        numid++;
    }
    // Opções (ações de interação na interface)
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
                login();
            }

        }

    }
    // amostragem de menu (automático)
        private static int mostrarMenu(List<Integer> opcoes) {
            Object[] optionsArray = opcoes.toArray();
            int opcaoEscolhida = JOptionPane.showOptionDialog(null, "1. cadastrar cliente \n2. Login \n3. finalizar programa \n \n \nOpções:", "Banco -alpha test-", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsArray, null);
            return opcaoEscolhida;
        }
    // cadastro de cliente (opção 1)
    private static void cadastrarCliente() {
        String nomeCliente = JOptionPane.showInputDialog("nome:");
        String cpfCliente = JOptionPane.showInputDialog("cpf:");
        int idClienteCliente = numid;
        int endIdEndereco = numid;
        String estadoEndereco = JOptionPane.showInputDialog("estado:");
        String cidadeEndereco = JOptionPane.showInputDialog("cidade:");
        String bairroEndereco = JOptionPane.showInputDialog("bairro:");
        String ruaEndereco = JOptionPane.showInputDialog("rua:");
        String numeroEndereco = JOptionPane.showInputDialog("número:");
        String cepEndereco = JOptionPane.showInputDialog("cep:");
        String senhaCliente = JOptionPane.showInputDialog("senha: ");
        Endereco newEndereco = new Endereco(cepEndereco, numeroEndereco, ruaEndereco, bairroEndereco, cidadeEndereco, estadoEndereco, endIdEndereco);
        Cliente newCliente = new Cliente(nomeCliente, cpfCliente, idClienteCliente, newEndereco, senhaCliente);
        clientes.add(newCliente);
        enderecos.add(newEndereco);
        incrementoIdCliente();
    }
    // Login
    public static void login() {

        if (clientes.size() != 0) {

            String usercpf = JOptionPane.showInputDialog("Seu cpf: ");
            String usersenha = JOptionPane.showInputDialog("Sua senha: ");

            for (Cliente cliente : clientes) {

                if (usercpf.equals(cliente.getCpf()) && usersenha.equals(cliente.getSenha())) {

                    List<Integer> opções = new ArrayList<>();

                    opções.add(1);
                    opções.add(2);
                    opções.add(3);

                    int opçãoEscolhida = 0;
                    while (opções.get(opçãoEscolhida) != 3) {
                        opçãoEscolhida = menuLogin(opções);
                        if (opções.get(opçãoEscolhida) == 1) {
                            mostrarInformacoesClientes();
                        } else if (opções.get(opçãoEscolhida) == 2) {
                            gerenciarContas();
                        }
                    }



                } else {
                    JOptionPane.showMessageDialog(null, "cpf ou Senha incorretos\ntente novamente.");
                }
            }
        }
    }
    private static int menuLogin(List<Integer> opções) {
        Object[] optionsArray = opções.toArray();
        int opçãoEscolhida = JOptionPane.showOptionDialog(null, "\n\n1. Mostrar informações \n2. Gerenciar Contas \n3. finalizar programa \n \n \nOpções:", "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsArray, null);
        return opçãoEscolhida;
    }
    private static void mostrarInformacoesClientes() {
        String info = "";
        for (Cliente cliente : clientes) {
            info = info + "  -Informações pessoais-\n\nnome: " +cliente.getNome() + "\ncpf:      " + cliente.getCpf() + "\nid:        " + cliente.getIdCliente() + "\n\n  -Endereço-\n\nEstado:     " + cliente.getEndereco().getEstado() + "\nCidade:     " + cliente.getEndereco().getCidade() + "\nBairro:      " + cliente.getEndereco().getBairro() +  "\nRua:          " + cliente.getEndereco().getRua() + "\nNúmero:  " + cliente.getEndereco().getNumero() + "\nCep:          " + cliente.getEndereco().getCep() + "\n----------------------------------------------\n\n";
        }
        JOptionPane.showMessageDialog(null, info, "Clientes", JOptionPane.PLAIN_MESSAGE);
    }
    private static void gerenciarContas() {

    }

}
