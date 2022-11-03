package Ancoragem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ContaPoupança extends Conta{
    public ContaPoupança(int numAgencia, int idConta, double saldo, String tipo) {
        super(numAgencia, idConta, saldo, tipo);
    }
    public ContaPoupança(int identificadorConta, String typo) {
        super(identificadorConta, typo);
    }
}
