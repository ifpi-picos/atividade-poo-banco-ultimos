package Ancoragem;

public class Endereco {
    private static String cep;
    private static String numero;
    private static String rua;
    private static String bairro;
    private static String cidade;
    private static String estado;
    private static int endId;

    public Endereco(String cep, String numero, String rua, String bairro, String cidade, String estado, int endId) {
        this.cep = cep;
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.endId = endId;
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
    public int getEndId() {return this.endId;}
    public void setEndId(int endId) {
        this.endId = endId;
    }
}
