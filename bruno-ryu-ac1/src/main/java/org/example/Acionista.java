package org.example;

public class Acionista implements IControle{

    // atributos

    private String nome;
    private Integer qtdAcoes;
    private Double precoAcao;

    // construtor

    public Acionista(String nome, Integer qtdAcoes, Double precoAcao) {
        this.nome = nome;
        this.qtdAcoes = qtdAcoes;
        this.precoAcao = precoAcao;
    }

    // metodos

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdAcoes() {
        return qtdAcoes;
    }

    public void setQtdAcoes(Integer qtdAcoes) {
        this.qtdAcoes = qtdAcoes;
    }

    public Double getPrecoAcao() {
        return precoAcao;
    }

    public void setPrecoAcao(Double precoAcao) {
        this.precoAcao = precoAcao;
    }

    // metodos


    @Override
    public Double getValorBonus() {
        return (qtdAcoes * precoAcao) * 0.2;
    }

    // toString

    @Override
    public String toString() {
        return "Acionista{" +
                "nome='" + nome + '\'' +
                ", qtdAcoes=" + qtdAcoes +
                ", precoAcao=" + precoAcao +
                '}';
    }
}
