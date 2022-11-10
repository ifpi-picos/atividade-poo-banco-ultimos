package Ancoragem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ContaPoupança extends Conta{
    public ContaPoupança(int numAgencia, int idConta, double saldo, String tipo) {
        super(numAgencia, idConta, saldo, tipo);
    }
    public ContaPoupança(int idConta, String typo) {
        super(idConta, typo);
    }
    @Override
    public void transferir(String CPF, int idConta, List<Cliente> clientes) {
        Double trans = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferência: R$"));
        String desCpf = JOptionPane.showInputDialog("CPF destinatário: ");
        int desIdCon = Integer.parseInt(JOptionPane.showInputDialog("ID da conta (des): "));
        Double taxaTransP = trans * 0.05;

        for (Cliente cliente : clientes) {
            if (CPF.equals(cliente.getCpf())) {
                for (Conta conta : cliente.getContas()) {
                    if (idConta == conta.getIdConta()) {
                        if (trans <= conta.getSaldo()) {
                            List<String> cpfcliente = new ArrayList<>();
                            for (Cliente ccpf : clientes) {
                                cpfcliente.add(ccpf.getCpf());
                            }
                            if (cpfcliente.contains(desCpf)) {
                                for (Cliente ccli : clientes) {
                                    if (desCpf.equals(ccli.getCpf())) {
                                        List<Integer> idsContas = new ArrayList<>();
                                        for(Conta conts : ccli.getContas()) {
                                            idsContas.add(conts.getIdConta());
                                        }
                                        if (idsContas.contains(desIdCon)) {
                                            for (Conta contts : ccli.getContas()) {
                                                if (desIdCon == contts.getIdConta()) {
                                                    Double averiguação = trans + taxaTransP;
                                                    if (conta.getSaldo() - averiguação >= 0) {
                                                        conta.setSaldo(conta.getSaldo() - (trans + taxaTransP));
                                                        JOptionPane.showMessageDialog(null, "R$" + (trans) + "transferido! \nSeu saldo atual é: R$" + conta.getSaldo() + "\n\n");

                                                        contts.setSaldo(contts.getSaldo() + (trans));
                                                        String e = cliente.getEmail();
                                                        Long n = cliente.getTelefone();
                                                        String operacao = "transferência";
                                                        Email email = new Email();
                                                        email.sendnotification(operacao, trans, e, n);
                                                        Sms sms = new Sms();
                                                        sms.sendnotification(operacao, trans, e, n);

                                                        break;
                                                    } else {
                                                        JOptionPane.showMessageDialog(null,"Seu saldo (R$" + conta.getSaldo() + ")não é suficiente para realizar a \ntransferência contando com a taxa: " + (averiguação));
                                                    }
                                                }
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Conta inexistente!");
                                        }

                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "CPF inválido ou inexistente!");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                        }
                    }
                }
            }
        }
    }
    @Override
    public void sacar(String CPF, int idConta, List<Cliente> clientes) {
        Double saque = Double.parseDouble(JOptionPane.showInputDialog("Valor de saque: "));
        for (Cliente cliente : clientes) {
            if (CPF.equals(cliente.getCpf())) {
                for (Conta conta : cliente.getContas()) {
                    if (idConta == conta.getIdConta()) {
                        Double averiguação = conta.getSaldo() - saque;
                        if (averiguação >= 0) {
                            conta.setSaldo(conta.getSaldo() - saque);
                            JOptionPane.showMessageDialog(null, "R$" + saque + "sacado! \nSeu saldo atual é de: R$" + conta.getSaldo() + "\n\n");
                            String e = cliente.getEmail();
                            Long n = cliente.getTelefone();
                            String operacao = "o saque";
                            Email email = new Email();
                            email.sendnotification(operacao, saque,e,n);
                            Sms sms = new Sms();
                            sms.sendnotification(operacao, saque,e,n);
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                        }
                    }
                }
            }
        }
    }

    @Override
    public void depositar(String CPF, int idConta, List<Cliente> clientes) {
        double deposito = Double.parseDouble(JOptionPane.showInputDialog("Valor de depósito: R$"));
        double rendimento = deposito * 0.1;
        for (Cliente cliente : clientes) {
            if (CPF.equals(cliente.getCpf())) {
                for (Conta conta : cliente.getContas()) {
                    if (idConta == conta.getIdConta()) {
                        conta.setSaldo(conta.getSaldo() + deposito + rendimento);
                        JOptionPane.showMessageDialog(null, "R$" + deposito + "  depositado! \nSaldo atual da conta: R$" + conta.getSaldo() + "\n\n");
                        String e = cliente.getEmail();
                        Long n = cliente.getTelefone();
                        String operacao = "deposito";
                        Email email = new Email();
                        email.sendnotification(operacao, deposito, e , n);
                        Sms sms = new Sms();
                        sms.sendnotification(operacao, deposito, e, n);
                    }
                }
            }
        }
    }
}
