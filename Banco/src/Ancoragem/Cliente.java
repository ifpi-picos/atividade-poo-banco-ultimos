package Ancoragem;
import java.util.ArrayList;
import java.util.Date;

public class Cliente {
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private Endereco endereco;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    public String getNome() {
        return this.nome;
    }
    public String getCpf() {
        return this.cpf;
    }
    public Date getDataNascimento() {
        return this.dataNascimento;
    }
    public Endereco getEndereco() {return this.endereco;}
}

