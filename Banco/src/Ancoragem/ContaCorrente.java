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
}
