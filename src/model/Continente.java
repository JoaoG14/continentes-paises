import java.util.ArrayList;
import java.util.List;

public class Continente {
    private String nome;
    private List<Pais> paises;

    public Continente(String nome) {
        this.nome = nome;
        this.paises = new ArrayList<>();
    }

    public void adicionarPais(Pais pais) {
        paises.add(pais);
    }

    public String getNome() {
        return nome;
    }

    public double getPopulacaoTotal() {
        return paises.stream().mapToLong(Pais::getPopulacao).sum();
    }

    public double getDimensaoTotal() {
        return paises.stream().mapToDouble(Pais::getDimensaoKm2).sum();
    }

    public Pais getMaiorPais() {
        return paises.stream().max(Comparator.comparingDouble(Pais::getDimensaoKm2)).orElse(null);
    }

    public Pais getPaisComMaiorPopulacao() {
        return paises.stream().max(Comparator.comparingLong(Pais::getPopulacao)).orElse(null);
    }

    public Pais getPaisComMenorDimensao() {
        return paises.stream().min(Comparator.comparingDouble(Pais::getDimensaoKm2)).orElse(null);
    }

    public double getRazaoTerritorial() {
        Pais maior = getMaiorPais();
        Pais menor = getPaisComMenorDimensao();
        return (maior != null && menor != null) ? maior.getDimensaoKm2() / menor.getDimensaoKm2() : 0;
    }
} 