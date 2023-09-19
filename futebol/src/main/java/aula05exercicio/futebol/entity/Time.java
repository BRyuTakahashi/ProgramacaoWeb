package aula05exercicio.futebol.entity;

public class Time {

    private String nome;
    private String treinador;
    private Integer vitorias;
    private Integer derrotas;
    private Integer empates;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTreinador() {
        return treinador;
    }

    public void setTreinador(String treinador) {
        this.treinador = treinador;
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates;
    }

    public Integer getPontuacaoTotal() {
        return vitorias * 3 + empates;
    }

    public Double getAproveitamento() {
        double pontuacaoTotal = vitorias * 3 + empates;
        double possivelPontuacao = (vitorias + derrotas + empates) * 3;
        return (pontuacaoTotal / possivelPontuacao) * 100.0;
    }
}
