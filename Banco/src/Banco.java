import Ancoragem.Cliente;
import Ancoragem.Endereco;
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

    public static String usercpf = "";
    public static int idConta = 0;
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

        contaTeste();

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

    public static void contaTeste() throws ParseException {

        Random cIdConta = new Random();
        int idConta = cIdConta.nextInt(9999);
        String tipo = "Corrente";
        String nomeCliente = "Carlos Michael";
        String cpfCliente = "10020030012";
        String dataNascimentoCliente = "22012003";
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy");
        Date dataFormat = formato.parse(dataNascimentoCliente);
        int idClienteCliente = numid;
        String endIdEndereco = cpfCliente;
        long telefoneCliente = Long.parseLong("89999774554");
        String emailCliente = "CarlosMichaelg@gmail.com";
        String estadoEndereco = "Pi";
        String cidadeEndereco = "Picos";
        String bairroEndereco = "Canto da Várzea";
        String ruaEndereco = "João Nunes";
        String numeroEndereco = "314";
        String cepEndereco = "64600184";
        String senhaCliente = "Carlos123";
        Endereco endereco = new Endereco(cepEndereco, numeroEndereco, ruaEndereco, bairroEndereco, cidadeEndereco, estadoEndereco, endIdEndereco);
        ContaCorrente pConta = new ContaCorrente(idConta, tipo);
        Cliente newCliente = new Cliente(nomeCliente, cpfCliente,emailCliente, telefoneCliente, idClienteCliente, senhaCliente, dataFormat);
        newCliente.addConta(pConta);
        newCliente.addContaCorrente(pConta);
        newCliente.addEndereco(endereco);
        clientes.add(newCliente);
        incrementoIdCliente();

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
        int idConta = cIdConta.nextInt(9999);
        String tipo = "Corrente";
        String nomeCliente = JOptionPane.showInputDialog("nome:");
        String cpfCliente = JOptionPane.showInputDialog("cpf:");
        String dataNascimentoCliente = JOptionPane.showInputDialog("Data de Nascimento: ");
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy");
        Date dataFormat = formato.parse(dataNascimentoCliente);
        int idClienteCliente = numid;
        String endIdEndereco = cpfCliente;
        long telefoneCliente = Long.parseLong(JOptionPane.showInputDialog("Número de telefone:"));
        String emailCliente = JOptionPane.showInputDialog("Email: ");
        String estadoEndereco = JOptionPane.showInputDialog("estado:");
        String cidadeEndereco = JOptionPane.showInputDialog("cidade:");
        String bairroEndereco = JOptionPane.showInputDialog("bairro:");
        String ruaEndereco = JOptionPane.showInputDialog("rua:");
        String numeroEndereco = JOptionPane.showInputDialog("número:");
        String cepEndereco = JOptionPane.showInputDialog("cep:");
        String senhaCliente = JOptionPane.showInputDialog("Crie uma senha: ");
        Endereco endereco = new Endereco(cepEndereco, numeroEndereco, ruaEndereco, bairroEndereco, cidadeEndereco, estadoEndereco, endIdEndereco);
        ContaCorrente pConta = new ContaCorrente(idConta, tipo);
        Cliente newCliente = new Cliente(nomeCliente, cpfCliente, emailCliente, telefoneCliente, idClienteCliente, senhaCliente, dataFormat);
        newCliente.addConta(pConta);
        newCliente.addContaCorrente(pConta);
        newCliente.addEndereco(endereco);
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

                            for (Endereco endereco : cliente.getEnderecos()) {
                                if (usercpf.equals(endereco.getEndId())) {
                                    String info = "";
                                    info = info + "  -Informações pessoais-\n\nnome: " + cliente.getNome() + "\ncpf:      " + cliente.getCpf() + "\nd/nascimento: " + cliente.getDataNascimento() + "\nid:         " + cliente.getIdCliente() + "\nn.contas corrente:    " + cliente.getContasCorrente().size() + "\nn.contas poupança:  " + cliente.getContasPoupança().size() + "\n\n  -Endereço-\n\nEstado:     " + endereco.getEstado() + "\nCidade:     " + endereco.getCidade() + "\nBairro:      " + endereco.getBairro() + "\nRua:          " + endereco.getRua() + "\nNúmero:  " + endereco.getNumero() + "\nCep:          " + endereco.getCep() + "\n----------------------------------------------\n\n";
                                    JOptionPane.showMessageDialog(null, info, "Informações", JOptionPane.PLAIN_MESSAGE);
                                }
                            }
                        } else if (opçãoEscolhida == 1) {
                            List<Integer> options = new ArrayList<>();

                            options.add(1);
                            options.add(2);
                            options.add(3);

                            java.lang.Object[] menuContas = options.toArray();
                            int optionSelected = 0;
                            while (optionSelected != 2) {
                                optionSelected = JOptionPane.showOptionDialog(null, "1. Acessar conta (" + cliente.getContas().size() + ")\n2. Criar nova conta \n3. Sair do menu contas \n\n", "Contas: " + cliente.getNome(), JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, menuContas, null);

                                if (optionSelected == 0) {

                                    String info = "";
                                    List<Integer> opcoes = new ArrayList<>();

                                    for (Conta conta : cliente.getContas()) {
                                        opcoes.add(conta.getIdConta());
                                        info = info + "\nTipo: " + conta.getTipo() + "  Id: " + conta.getIdConta() + "  saldo: R$" + conta.getSaldo();
                                    }

                                    Object[] acoesConta = opcoes.toArray();
                                    int contaEscolhida = JOptionPane.showOptionDialog(null, "escolha uma conta: \n" + info + "\n\n", "Contas", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, acoesConta, null);
                                    int numeroConta = opcoes.get(contaEscolhida);

                                    for (Conta conta : cliente.getContas()) {
                                        if (numeroConta == conta.getIdConta()) {

                                            List<Integer> menuDeAções = new ArrayList<>();
                                            menuDeAções.add(1);
                                            menuDeAções.add(2);
                                            menuDeAções.add(3);
                                            menuDeAções.add(4);

                                            java.lang.Object[] menuAção = menuDeAções.toArray();
                                            int itemSelecionado = 1;
                                            while (menuDeAções.get(itemSelecionado) != 4) {
                                                itemSelecionado = JOptionPane.showOptionDialog(null, "Status de conta:\n\nTipo: " + conta.getTipo() + "\nId: " + conta.getIdConta() + "\nsaldo: R$" + conta.getSaldo() + "\n\n1.depositar\n2.sacar\n3.transferir\n4.Sair de menu de ação \n\n", "Ações", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, menuAção, null);
                                                if (menuDeAções.get(itemSelecionado) == 1) {
                                                    depositar(usercpf, numeroConta);
                                                } else if (menuDeAções.get(itemSelecionado) == 2) {
                                                    sacar(usercpf, numeroConta);
                                                } else if (menuDeAções.get(itemSelecionado) == 3) {
                                                    transferir(usercpf, numeroConta);
                                                }
                                            }
                                        }
                                    }
                                } else if (optionSelected == 1) {
                                    List<Integer> optione = new ArrayList<>();

                                    optione.add(1);
                                    optione.add(2);
                                    optione.add(3);

                                    java.lang.Object[] criaçãoContas = optione.toArray();
                                    int optioneSelected = 0;
                                    while (optioneSelected != 2) {
                                        optioneSelected = JOptionPane.showOptionDialog(null, "1. Conta corrente\n2. Conta Poupança\n3. Cancelar criação de conta\n\n", "Criação de Conta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, criaçãoContas, null);

                                        if (optioneSelected == 0) {

                                            Random cIdConta = new Random();
                                            int idConta = cIdConta.nextInt(9999);
                                            String tipo = "Corrente";
                                            ContaCorrente Conta = new ContaCorrente(idConta, tipo);
                                            cliente.addConta(Conta);
                                            cliente.addContaCorrente(Conta);
                                            JOptionPane.showMessageDialog(null, "Uma nova conta corrente foi adicionada à sua conta!\n\nId da conta: " + idConta + "\nAgência:      1\nSaldo:           R$0,00\n\n\n");

                                        } else if (optioneSelected == 1) {

                                            Random cIdConta = new Random();
                                            int idConta = cIdConta.nextInt(9999);
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
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado ainda!\ntende de novo após realizar um cadastro.");
        }
    }

    public static void depositar(String CPF, int idConta) {
        for (Cliente cliente : clientes) {
            if (CPF.equals(cliente.getCpf())) {
                for (Conta conta : cliente.getContas()) {
                    if (idConta == conta.getIdConta()) {
                        conta.depositar(CPF, idConta, clientes);
                    }
                }
            }
        }
    }

    public static void transferir(String CPF, int idConta) {
        for (Cliente cliente : clientes) {
            if (CPF.equals(cliente.getCpf())) {
                for (Conta conta : cliente.getContas()) {
                    if (idConta == conta.getIdConta()) {
                        conta.transferir(CPF, idConta, clientes);
                    }
                }
            }
        }
    }

    public static void sacar(String CPF, int idConta) {
        for (Cliente cliente : clientes) {
            if (CPF.equals(cliente.getCpf())) {
                for (Conta conta : cliente.getContas()) {
                    if (idConta == conta.getIdConta()) {
                        conta.sacar(CPF, idConta, clientes);
                    }
                }
            }

        }
    }
}