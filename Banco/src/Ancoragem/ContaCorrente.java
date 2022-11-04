package Ancoragem;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;

public class ContaCorrente extends Conta{
    private double chequeEspecial = 3000;
    private int ntrans = 0;
    public ContaCorrente(int numAgencia, int idConta, double saldo, String tipo) {
        super(numAgencia, idConta, saldo, tipo);
    }
    public ContaCorrente(int idConta, String typo) {
        super(idConta, typo);
    }
    public int getNtrans() {
        return ntrans;
    }
    public void setNtrans(Integer num) {
        ntrans = num;
    }
    public double getChequeEspecial() {
        return chequeEspecial;
    }
    public void setChequeEspecial(double chequeEspecial1) {
        chequeEspecial = chequeEspecial1;
    }
    @Override
    public void transferir(String CPF, int idConta, List<Cliente> clientes) {
        System.out.println(getChequeEspecial());
        Double trans = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferência: R$"));
        String descpf = JOptionPane.showInputDialog("CPF destinatário: ");
        int desIdCon = Integer.parseInt(JOptionPane.showInputDialog("ID da Conta (des): "));
        Double taxaTransC = trans * 0.10;
        for (Cliente cliente : clientes) {
            if (CPF.equals(cliente.getCpf())) {
                for (ContaCorrente conta : cliente.getContasCorrente()) {
                    if (idConta == conta.getIdConta()) {
                        if  (trans <= conta.getSaldo())  {
                            List<String> cpfCliente = new ArrayList<>();
                            for (Cliente ccpf : clientes) {
                               cpfCliente.add(ccpf.getCpf());
                            }
                            if (cpfCliente.contains(descpf)) {
                                for (Cliente ccli : clientes) {
                                    if (descpf.equals(ccli.getCpf())) {
                                        List<Integer> idsContas = new ArrayList<>();
                                        for (Conta conts : ccli.getContas()) {
                                            idsContas.add(conts.getIdConta());
                                        }
                                        if (idsContas.contains(desIdCon)) {
                                            for (Conta contts : ccli.getContas()) {
                                                if (desIdCon == contts.getIdConta()) {
                                                    if (conta.getNtrans() >= 2) {
                                                        conta.setSaldo(conta.getSaldo() - (trans + taxaTransC));
                                                        conta.setNtrans(conta.getNtrans() + 1);
                                                        JOptionPane.showMessageDialog(null, "R$" + (trans) + "transferido! \nSeu saldo atual é: R$" + conta.getSaldo() + "\n\n");

                                                        break;
                                                    } else {
                                                        conta.setSaldo(conta.getSaldo() - trans);
                                                        setNtrans(getNtrans() + 1);
                                                        JOptionPane.showMessageDialog(null, "R$" + (trans) + "transferido! \nSeu saldo atual é: R$" + conta.getSaldo() + "\n\n");

                                                        break;
                                                    }
                                                }
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "O ID inserido não existe!");
                                            break;
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Cpf inserido não existe!");
                                break;
                            }
                        } else {
                            List<String> cpfcliente = new ArrayList<>();
                            for (Cliente ccpf : clientes) {
                                cpfcliente.add(ccpf.getCpf());
                            }
                            if (cpfcliente.contains(descpf)) {
                                for (Cliente ccli : clientes) {
                                    if (descpf.equals(ccli.getCpf())) {
                                        List<Integer> idsConta = new ArrayList<>();
                                        for (Conta conts : ccli.getContas()) {
                                            idsConta.add(conts.getIdConta());
                                        }
                                        if (idsConta.contains(desIdCon)) {
                                            for (Conta contts : ccli.getContas()) {
                                                if (desIdCon == contts.getIdConta()) {
                                                    if (conta.getNtrans() >= 2) {
                                                        Double averiguação = conta.getSaldo() - (trans + taxaTransC);
                                                        if (conta.getSaldo() > 0) {
                                                            if (conta.getSaldo() + conta.getChequeEspecial() >= (trans + taxaTransC)) {
                                                                conta.setSaldo(conta.getSaldo() - (trans + taxaTransC));
                                                                conta.setSaldo(conta.getSaldo() + averiguação);
                                                                JOptionPane.showMessageDialog(null, "R$" + (trans) + "transferido! \nSeu saldo atual é: R$" + conta.getSaldo() + "\n\n");

                                                                break;
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "O valor ultrapassa o saldo junto ao limite do cheque!");
                                                            }
                                                        } else {
                                                            if (conta.getChequeEspecial() >= (trans + taxaTransC)) {
                                                                conta.setSaldo(conta.getSaldo() - (trans + taxaTransC));
                                                                conta.setChequeEspecial(conta.getChequeEspecial() + averiguação);
                                                                JOptionPane.showMessageDialog(null, "R$" + (trans) + "transferido! \nSeu saldo atual é: R$" + conta.getSaldo() + "\n\n");

                                                                break;
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "O valor ultrapassa o limite do cheque especial");
                                                            }
                                                        }
                                                    } else {
                                                        Double averiguação = conta.getSaldo() - trans;
                                                        if (conta.getSaldo() > 0) {
                                                            if (conta.getSaldo() + conta.getChequeEspecial() >= trans) {
                                                                conta.setSaldo(conta.getSaldo() - trans);
                                                                conta.setChequeEspecial(conta.getChequeEspecial() + averiguação);
                                                                JOptionPane.showMessageDialog(null, "R$" + (trans) + "transferido! \nSeu saldo atual é: R$" + conta.getSaldo() + "\n\n");

                                                                break;
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "O valor ultrapassa o saldo da conta com o limite do cheque!");
                                                            }
                                                        } else {
                                                            if (conta.getChequeEspecial() >= trans) {
                                                                conta.setSaldo(conta.getSaldo() - trans);
                                                                conta.setChequeEspecial(conta.getChequeEspecial() + averiguação);
                                                                JOptionPane.showMessageDialog(null, "R$" + (trans) + "transferido! \nSeu saldo atual é: R$" + conta.getSaldo() + "\n\n");

                                                                break;
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "O valor ultrapassa o limite do cheque!");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Conta não encontrada ou inexistente!");
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Cliente inexistente!");
                            }
                        }
                    }
                }
            }
        }

    }
    @Override
    public void sacar(String CPF, int idConta, List<Cliente> clientes) {
        Double saque = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor de saque: "));
        for (Cliente cliente : clientes) {
            if (CPF.equals(cliente.getCpf())) {
                for (ContaCorrente conta : cliente.getContasCorrente()) {
                    if (idConta == conta.getIdConta()) {
                        Double averiguação = conta.getSaldo() - saque;
                        if (averiguação >= 0) {
                            conta.setSaldo(conta.getSaldo() - saque);
                            JOptionPane.showMessageDialog(null, "R$" + saque + "sacado! \nSeu saldo atual é de: R$" + conta.getSaldo() + "\n\n");

                        } else {
                            if (conta.getSaldo() > 0 ) {
                                if (conta.getChequeEspecial() + conta.getSaldo() >= saque) {
                                    conta.setSaldo(conta.getSaldo() - saque);
                                    conta.setChequeEspecial(conta.getChequeEspecial() + averiguação);
                                    JOptionPane.showMessageDialog(null, "R$" + saque + "sacado! \nSeu saldo atual é de: R$" + conta.getSaldo() + "\n\n");

                                } else {
                                    JOptionPane.showMessageDialog(null, "O valor ultrapassa o saldo com o limite do cheque!");
                                }
                            } else {
                                if (conta.getChequeEspecial() >= saque) {
                                    conta.setSaldo(conta.getSaldo() - saque);
                                    conta.setChequeEspecial(conta.getChequeEspecial() + averiguação);
                                    JOptionPane.showMessageDialog(null, "R$" + saque + "sacado! \nSeu saldo atual é de: R$" + conta.getSaldo() + "\n\n");
                                } else {
                                    JOptionPane.showMessageDialog(null, "O valor ultrapassa o limite do cheque!");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
