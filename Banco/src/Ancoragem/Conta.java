package Ancoragem;

public class Conta {
    private int agencia;
    private int numero;
    private double saldo;

    void mostrarSaldo() {
        System.out.format("O saldo atual da conta é: %f \n", saldo);
    }

}

