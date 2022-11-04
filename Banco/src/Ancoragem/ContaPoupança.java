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
                                                    conta.setSaldo(conta.getSaldo() - (trans + taxaTransP));
                                                    JOptionPane.showMessageDialog(null, "R$" + (trans) + "transferido! \nSeu saldo atual é: R$" + conta.getSaldo() + "\n\n");

                                                    break;
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
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                        }
                    }
                }
            }
        }
    }
}
