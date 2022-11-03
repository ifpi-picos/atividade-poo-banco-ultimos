package Ancoragem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public abstract class Conta {
    private int numAgencia;
    private int idConta;
    private double saldo;
    private String Tipo;

    public Conta(int identificadorConta, String typo) {
        this.idConta = identificadorConta;
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

    public void setSaldo() {
        this.saldo = saldo;
    }

    public int getNumAgencia() {
        return this.numAgencia;
    }

    public String getTipo() {
        return this.Tipo;
    }
    public int getIdConta() {return this.idConta;}

}
