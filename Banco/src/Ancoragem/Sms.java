package Ancoragem;

import javax.swing.JOptionPane;

public class Sms implements notificação {

    @Override
    public void sendnotification(String operacao, double valor, String email, long num) {
        JOptionPane.showMessageDialog(null,"Mandamos uma notificação para seu número, sobre a(o) " + operacao + " de " + "R$" + valor + "\n Enviamos para: " + num);
    }

}
