package Ancoragem;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
    // Atributos
public class Cliente {
    private final String CPF;
    private int idCliente;
    private String nome;
    private String email;
    private long telefone;
    private Date dataNascimento;
    private String senha;
    private List<Endereco> enderecos = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();
    private List<ContaCorrente> contasCorrente = new ArrayList<>();
    private List<ContaPoupança> contasPoupança = new ArrayList<>();

    // constructor de Cliente
    public Cliente(String nome, String cpf, String email, long telefone,int idCliente, String senha, Date dataNascimento) {
        this.nome = nome;
        this.CPF = cpf;
        this.email = email;
        this.telefone = telefone;
        this.idCliente = idCliente;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }
    // gets e sets
    public String getNome() {
        return this.nome;
    }
    public String getCpf() {
        return this.CPF;
    }
    public String getEmail() {return email;}
    public long getTelefone() {return telefone;}
    public int getIdCliente() {return this.idCliente;}
    public void setIdCliente(int idCliente) {this.idCliente = idCliente;}
    public Date getDataNascimento() {return this.dataNascimento;}
    public void setDataNascimento(Date dataNascimento) {this.dataNascimento = dataNascimento;}
    public String getSenha() {return senha;}
    public List<Endereco> getEnderecos() {return this.enderecos;}
    public List<Conta> getContas() {return this.contas;}
    public List<ContaCorrente> getContasCorrente() {return this.contasCorrente;}
    public List<ContaPoupança> getContasPoupança() {return this.contasPoupança;}
    public void addConta(Conta conta) {this.contas.add(conta);}
    public void addContaCorrente(ContaCorrente contaCorrente) {this.contasCorrente.add(contaCorrente);}
    public void addContaPoupança(ContaPoupança contaPoupança) {this.contasPoupança.add(contaPoupança);}
    public void addEndereco(Endereco endereco) {this.enderecos.add(endereco);}
}

