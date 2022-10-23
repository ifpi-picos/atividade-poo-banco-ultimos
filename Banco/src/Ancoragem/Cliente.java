package Ancoragem;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Cliente {
    private final String cpf;
    private int idCliente;
    private String nome;
    private Date dataNascimento;
    private Endereco endereco;
    private String senha;
    private List<Conta> contas = new ArrayList<>();


    public Cliente(String nome, String cpf, int idCliente, Endereco endereco, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.idCliente = idCliente;
        this.endereco = endereco;
        this.senha = senha;
    }

    public String getNome() {
        return this.nome;
    }
    public String getCpf() {
        return this.cpf;
    }
    public int getIdCliente() {
        return this.idCliente;
    }
    public Endereco getEndereco() {return this.endereco;}
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getSenha() {
        return senha;
    }
}

