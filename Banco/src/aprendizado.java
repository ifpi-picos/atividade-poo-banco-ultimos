import java.util.Scanner;
import javax.swing.JOptionPane;

public class aprendizado {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escreva o nome do indivíduo: ");
        String nome = teclado.nextLine();
        System.out.print("Escreva a nota dele: ");
        float nota = teclado.nextFloat();
        System.out.printf("A nota de %s \n é: %.1f \n", nome, nota);
    }
}
