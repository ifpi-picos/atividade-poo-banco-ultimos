package Ancoragem;

public class Conta {
    private int numAgencia;
    private int idConta;
    private double saldo;
    private String Tipo;


    public double getSaldo() {
        return this.saldo;
    }
    public int getNumAgencia() {
        return this.numAgencia;
    }
    public void setSaldo() {
        this.saldo = saldo;
    }


    void mostrarSaldo() {
        System.out.format("O saldo atual da conta é: %f \n", saldo);
    }


}

