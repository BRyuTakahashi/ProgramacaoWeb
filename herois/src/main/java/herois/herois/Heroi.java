package herois.herois;

public class Heroi {

    private String nome;
    private Integer idade;
    private String habilidade;
    private Integer forca;
    private Boolean vivo;

    public Heroi(String nome, Integer idade, String habilidade, Integer forca, Boolean vivo) {
        this.nome = nome;
        this.idade = idade;
        this.habilidade = habilidade;
        this.forca = forca;
        this.vivo = vivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Boolean getVivo() {
        return vivo;
    }

    public void setVivo(Boolean vivo) {
        this.vivo = vivo;
    }

    @Override
    public String toString() {
        return "Heroi{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", habilidade='" + habilidade + '\'' +
                ", forca=" + forca +
                ", vivo=" + vivo +
                '}';
    }
}
