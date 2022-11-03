import Ancoragem.Cliente;
import Ancoragem.ContaCorrente;
import Ancoragem.ContaPoupança;
import Ancoragem.Conta;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Random;

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
    private static void cadastrarCliente() throws ParseException {
        Random cIdConta = new Random();
        int idConta = cIdConta.nextInt(51);
        String tipo = "Corrente";
        String nomeCliente = JOptionPane.showInputDialog("nome:");
        String cpfCliente = JOptionPane.showInputDialog("cpf:");
        String dataNascimentoCliente = JOptionPane.showInputDialog("Data de Nascimento: ");
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy");
        Date dataFormat = formato.parse(dataNascimentoCliente);
        int idClienteCliente = numid;
        String endIdCliente = cpfCliente;
        String estadoCliente = JOptionPane.showInputDialog("estado:");
        String cidadeCliente = JOptionPane.showInputDialog("cidade:");
        String bairroCliente = JOptionPane.showInputDialog("bairro:");
        String ruaCliente = JOptionPane.showInputDialog("rua:");
        String numeroCliente = JOptionPane.showInputDialog("número:");
        String cepCliente = JOptionPane.showInputDialog("cep:");
        String senhaCliente = JOptionPane.showInputDialog("Crie uma senha: ");
        ContaCorrente pConta = new ContaCorrente(idConta, tipo);
        Cliente newCliente = new Cliente(nomeCliente, cpfCliente, idClienteCliente, senhaCliente, cepCliente, numeroCliente, ruaCliente, bairroCliente, cidadeCliente, estadoCliente, endIdCliente, dataFormat);
        newCliente.addConta(pConta);
        newCliente.addContaCorrente(pConta);
        clientes.add(newCliente);
        incrementoIdCliente();
        JOptionPane.showMessageDialog(null, "Uma conta corrente foi automaticamente gerada. \n\nId da conta: " + idConta + "\nAgência:      1\nSaldo:           R$0,00\n\n\n");
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

                    java.lang.Object[] menuLogin = opções.toArray();
                    int opçãoEscolhida = 0;
                    while (opçãoEscolhida != 2) {
                        opçãoEscolhida = JOptionPane.showOptionDialog(null, "1. Ver informações de cliente \n2. Gerenciar contas (" + cliente.getContas().size() + ")\n3. Sair do login \n\n\nOpções:", "Login: " + cliente.getNome(), JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, menuLogin, null);

                        if (opçãoEscolhida == 0) {

                            if (usercpf.equals(cliente.getEndId())) {

                                String info = "";
                                info = info + "  -Informações pessoais-\n\nnome: " + cliente.getNome() + "\ncpf:      " + cliente.getCpf() + "\nd/nascimento: " + cliente.getDataNascimento() + "\nid:         " + cliente.getIdCliente() + "\nn.contas corrente:    " + cliente.getContasCorrente().size() + "\nn.contas poupança:  " + cliente.getContasPoupança().size() + "\n\n  -Endereço-\n\nEstado:     " + cliente.getEstado() + "\nCidade:     " + cliente.getCidade() + "\nBairro:      " + cliente.getBairro() + "\nRua:          " + cliente.getRua() + "\nNúmero:  " + cliente.getNumero() + "\nCep:          " + cliente.getCep() + "\n----------------------------------------------\n\n";
                                JOptionPane.showMessageDialog(null, info, "Informações", JOptionPane.PLAIN_MESSAGE);

                            }
                        } else if (opçãoEscolhida == 1) {
                            List<Integer> options = new ArrayList<>();

                            options.add(1);
                            options.add(2);
                            options.add(3);

                            java.lang.Object[] menuContas = options.toArray();
                            int optionSelected = 0;
                            while (optionSelected != 2) {
                                optionSelected = JOptionPane.showOptionDialog(null,"1. Acessar conta (" + cliente.getContas().size() + ")\n2. Criar nova conta \n3. Sair do menu contas \n\n", "Contas: " + cliente.getNome(), JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, menuContas, null);

                                if (optionSelected == 0) {

                                } else if (optionSelected == 1) {
                                    List<Integer> optione = new ArrayList<>();

                                    optione.add(1);
                                    optione.add(2);
                                    optione.add(3);

                                    java.lang.Object[] criaçãoContas = optione.toArray();
                                    int optioneSelected = 0;
                                    while (optioneSelected != 2) {
                                        optioneSelected = JOptionPane.showOptionDialog(null,"1. Conta corrente\n2. Conta Poupança\n3. Cancelar criação de conta\n\n","Criação de Conta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, criaçãoContas, null);

                                        if (optioneSelected == 0) {
                                            List<Integer> escolha = new ArrayList<>();

                                            escolha.add(1);
                                            escolha.add(2);

                                            java.lang.Object[] decisãoFinalCriaçãoConta = escolha.toArray();
                                            int escolhaTomada = 0;
                                            while (escolhaTomada != 1) {
                                                escolhaTomada = JOptionPane.showOptionDialog(null,"Tem certeza que deseja criar uma nova conta corrente?\n\n1. 'Sim, desejo criar uma nova conta corrente!'\n2. 'Não, desejo cancelar a criação de uma nova conta corrente!'\n\n","Finalização de criação", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, decisãoFinalCriaçãoConta, null);

                                                if (escolhaTomada == 0) {

                                                    Random cIdConta = new Random();
                                                    int idConta = cIdConta.nextInt(51);
                                                    String tipo = "Corrente";
                                                    ContaCorrente Conta = new ContaCorrente(idConta, tipo);
                                                    cliente.addConta(Conta);
                                                    cliente.addContaCorrente(Conta);
                                                    JOptionPane.showMessageDialog(null, "Uma nova conta corrente foi adicionada à sua conta!\n\nId da conta: " + idConta + "\nAgência:      1\nSaldo:           R$0,00\n\n\n");

                                                    
                                                }

                                            }

                                        } else if (optioneSelected == 1) {

                                            List<Integer> escolha = new ArrayList<>();

                                            escolha.add(1);
                                            escolha.add(2);

                                            java.lang.Object[] decisãoFinalCriaçãoConta = escolha.toArray();
                                            int escolhaTomada = 0;
                                            while (escolhaTomada != 1) {
                                                escolhaTomada = JOptionPane.showOptionDialog(null,"\nTem certeza que deseja criar uma nova conta poupança?\n\n1. 'Sim, desejo criar uma nova conta poupança!'\n2. 'Não, desejo cancelar a criação de uma nova conta poupança!'\n\n","Finalização de criação", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, decisãoFinalCriaçãoConta, null);


                                                if (escolhaTomada == 0) {

                                                    Random cIdConta = new Random();
                                                    int idConta = cIdConta.nextInt(51);
                                                    String tipo = "Poupança";
                                                    ContaPoupança Conta = new ContaPoupança(idConta, tipo);
                                                    cliente.addConta(Conta);
                                                    cliente.addContaPoupança(Conta);
                                                    JOptionPane.showMessageDialog(null, "Uma nova conta poupança foi adicionada à sua conta!\n\nId da conta: " + idConta + "\nAgência:      1\nSaldo:           R$0,00\n\n\n");

                                                }

                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado ainda!\ntende de novo após realizar um cadastro.");
        }
    }
}
