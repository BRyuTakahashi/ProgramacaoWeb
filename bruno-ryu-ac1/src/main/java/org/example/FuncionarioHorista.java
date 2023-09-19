package org.example;

public class FuncionarioHorista extends Funcionario{

    // atributos

    private Integer qtdHora;
    private Double valorHora;

    // construtor

    public FuncionarioHorista(String codigo, String nome, Integer qtdHora, Double valorHora) {
        super(codigo, nome);
        this.qtdHora = qtdHora;
        this.valorHora = valorHora;
    }

    // metodos

    public Double getGanho(){
        return qtdHora * valorHora;
    }

    @Override
    public Double getValorBonus() {
        return getGanho() * 0.1;
    }

    // toString

    @Override
    public String toString() {
        return "FuncionarioHorista{" +
                "qtdHora=" + qtdHora +
                ", valorHora=" + valorHora +
                "} " + super.toString();
    }
}
