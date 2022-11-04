package Ancoragem;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;

public class ContaCorrente extends Conta{
    public ContaCorrente(int numAgencia, int idConta, double saldo, String tipo) {
        super(numAgencia, idConta, saldo, tipo);
    }
    public ContaCorrente(int identificadorConta, String typo) {
        super(identificadorConta, typo);
    }
    public static void depositar(String usercpf, int idConta, List<Cliente> clientes) {
        double deposito = Double.parseDouble(JOptionPane.showInputDialog("Valor de depósito: R$"));
        for (Cliente cliente : clientes) {
            if (usercpf.equals(cliente.getCpf())) {
                for (Conta conta : cliente.getContas()) {
                    if (idConta == conta.getIdConta()) {
                        conta.setSaldo(conta.getSaldo() + deposito);
                        JOptionPane.showMessageDialog(null, "R$" + deposito + "  depositado! \nSaldo atual da conta: R$" + conta.getSaldo() + "\n\n");
                    }
                }
            }
        }
    }


}
