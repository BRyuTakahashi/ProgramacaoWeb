package org.example;

public class FuncionarioHoraExtra extends  Funcionario{

    // atributos

    private Double salario;
    private Integer qtdHoraExtra;
    private Double valorHoraExtra;

    // construtor

    public FuncionarioHoraExtra(String codigo, String nome, Double salario, Integer qtdHoraExtra, Double valorHoraExtra) {
        super(codigo, nome);
        this.salario = salario;
        this.qtdHoraExtra = qtdHoraExtra;
        this.valorHoraExtra = valorHoraExtra;
    }

    // metodos

    @Override
    public Double getGanho(){
        return salario + getValorBonus();
    }

    public Double getValorBonus(){
        return qtdHoraExtra * valorHoraExtra;
    }

    // toString


    @Override
    public String toString() {
        return "FuncionarioHoraExtra{" +
                "salario=" + salario +
                ", qtdHoraExtra=" + qtdHoraExtra +
                ", valorHoraExtra=" + valorHoraExtra +
                "} " + super.toString();
    }
}
