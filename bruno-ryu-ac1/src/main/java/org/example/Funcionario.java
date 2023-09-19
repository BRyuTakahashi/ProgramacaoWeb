package org.example;

public abstract class Funcionario implements  IControle{

    // atributos
    private String codigo;
    private String nome;

    // construtor

    public Funcionario(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }


    // metodos

    public Double getValorBonus(){
        return null;
    }

    public abstract Double getGanho();

    // toString


    @Override
    public String toString() {
        return "Funcionario{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
