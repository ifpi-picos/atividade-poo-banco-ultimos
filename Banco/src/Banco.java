import Ancoragem.Cliente;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    public static int numid = 0;
    // Listas
    static List<Cliente> clientes = new ArrayList<>();
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
        String endIdCliente = cpfCliente;
        String estadoCliente = JOptionPane.showInputDialog("estado:");
        String cidadeCliente = JOptionPane.showInputDialog("cidade:");
        String bairroCliente = JOptionPane.showInputDialog("bairro:");
        String ruaCliente = JOptionPane.showInputDialog("rua:");
        String numeroCliente = JOptionPane.showInputDialog("número:");
        String cepCliente = JOptionPane.showInputDialog("cep:");
        String senhaCliente = JOptionPane.showInputDialog("senha: ");
        Cliente newCliente = new Cliente(nomeCliente, cpfCliente, idClienteCliente, senhaCliente, cepCliente, numeroCliente, ruaCliente, bairroCliente, cidadeCliente, estadoCliente, endIdCliente);
        clientes.add(newCliente);
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
                    opções.add(4);

                    java.lang.Object[] menuLogin = opções.toArray();
                    int opçãoEscolhida = 0;
                    while (opçãoEscolhida != 3) {
                        opçãoEscolhida = JOptionPane.showOptionDialog(null, "1. Ver informações de cliente \n2. Gerenciar contas \n3. Sair do login \n\n\nOpções:", "Login: " + cliente.getNome(), JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, menuLogin, null);

                        if (opçãoEscolhida == 0) {

                            if (usercpf.equals(cliente.getEndId())) {

                                String info = "";
                                info = info + "  -Informações pessoais-\n\nnome: " + cliente.getNome() + "\ncpf:      " + cliente.getCpf() + "\nid:        " + cliente.getIdCliente() + "\n\n  -Endereço-\n\nEstado:     " + cliente.getEstado() + "\nCidade:     " + cliente.getCidade() + "\nBairro:      " + cliente.getBairro() + "\nRua:          " + cliente.getRua() + "\nNúmero:  " + cliente.getNumero() + "\nCep:          " + cliente.getCep() + "\n----------------------------------------------\n\n";
                                JOptionPane.showMessageDialog(null, info, "Informações", JOptionPane.PLAIN_MESSAGE);

                            }
                        } else if (opçãoEscolhida == 1) {

                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado ainda!\ntende de novo após realizar um cadastro.");
        }
    }
}
