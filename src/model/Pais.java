import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String codigoISO;
    private String nome;
    private long populacao;
    private double dimensaoKm2;
    private List<Pais> paisesFronteira;

    public Pais(String codigoISO, String nome, long populacao, double dimensaoKm2) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        this.populacao = populacao;
        this.dimensaoKm2 = dimensaoKm2;
        this.paisesFronteira = new ArrayList<>();
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public double getDimensaoKm2() {
        return dimensaoKm2;
    }

    public void setDimensaoKm2(double dimensaoKm2) {
        this.dimensaoKm2 = dimensaoKm2;
    }

    public void adicionarFronteira(Pais pais) {
        if (paisesFronteira.size() < 40) {
            paisesFronteira.add(pais);
        }
    }

    public boolean ehIgual(Pais outroPais) {
        return this.codigoISO.equals(outroPais.codigoISO);
    }

    public Pais limite(Pais outroPais) {
        return paisesFronteira.contains(outroPais) ? outroPais : null;
    }

    public double getDensidadePopulacional() {
        return populacao / dimensaoKm2;
    }

    public List<Pais> vizinhos() {
        return new ArrayList<>(paisesFronteira);
    }
} 