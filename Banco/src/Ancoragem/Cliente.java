package Ancoragem;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Cliente {
    private final String cpf;
    private int idCliente;
    private String nome;
    private Date dataNascimento;
    private String senha;
    private List<Conta> contas = new ArrayList<>();
    private String cep;
    private String numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String endId;


    public Cliente(String nome, String cpf, int idCliente, String senha, String cep, String numero, String rua, String bairro, String cidade, String estado, String endId) {
        this.nome = nome;
        this.cpf = cpf;
        this.idCliente = idCliente;
        this.senha = senha;
        this.cep = cep;
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.endId = endId;
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
    public String getCep() {
        return this.cep;
    }
    public String getNumero() {
        return this.numero;
    }
    public String getRua() {
        return this.rua;
    }
    public String getBairro() {
        return this.bairro;
    }
    public String getCidade() {
        return this.cidade;
    }
    public String getEstado() {
        return this.estado;
    }
    public String getEndId() {return this.endId;}
    public void setEndId(String endId) {
        this.endId = endId;
    }
}

