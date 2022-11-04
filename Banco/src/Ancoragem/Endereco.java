package Ancoragem;

public class Endereco {
    private String cep;
    private String numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String endId;

    public Endereco( String cep, String numero, String rua, String bairro, String cidade, String estado, String endId) {
        this.cep = cep;
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.endId = endId;
    }
    public String getCep() {return this.cep;}
    public String getNumero() {return this.numero;}
    public String getRua() {return this.rua;}
    public String getBairro() {return this.bairro;}
    public String getCidade() {return this.cidade;}
    public String getEstado() {return this.estado;}
    public String getEndId() {return this.endId;}
    public void setEndId(String endId) {this.endId = endId;}
}
