package Ancoragem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public abstract class Conta {
    private int numAgencia;
    private int idConta;
    private double saldo;
    private String Tipo;

    public Conta(int idConta, String typo) {
        this.idConta = idConta;
        this.Tipo = typo;
    }
    public Conta(int numAgencia, int idConta, double saldo, String tipo) {
        this.numAgencia = 1;
        this.idConta = idConta;
        this.saldo = 0;
        this.Tipo = tipo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumAgencia() {
        return this.numAgencia;
    }

    public String getTipo() {
        return this.Tipo;
    }
    public int getIdConta() {return this.idConta;}

    public abstract void transferir(String CPF, int idConta, List<Cliente> clientes);

    public abstract void sacar(String CPF, int idConta, List<Cliente> clientes);

    public abstract void depositar(String CPF, int idConta, List<Cliente> clientes);
    public static void depositarc(String CPF, int idConta, List<Cliente> clientes) {
        double deposito = Double.parseDouble(JOptionPane.showInputDialog("Confirme o valor da transferência: R$"));
        for (Cliente cliente : clientes) {
            if (CPF.equals(cliente.getCpf())) {
                for (Conta conta : cliente.getContas()) {
                    if (idConta == conta.getIdConta()) {
                        conta.setSaldo(conta.getSaldo() + deposito);
                    }
                }
            }
        }
    }
}


