package org.example;

public class Main {
    public static void main(String[] args) {

        ControleBonus controle = new ControleBonus();
        FuncionarioHorista funcionarioHora = new FuncionarioHorista("01222151", "Bruno Ryu", 120, 80.0);
        FuncionarioHoraExtra funcionarioExtra = new FuncionarioHoraExtra("01222152", "Yuzo", 2000.0, 4, 15.0);

        controle.adicionarFuncionario(funcionarioHora);
        controle.adicionarFuncionario(funcionarioExtra);

        System.out.printf("Bonus total dos funcionario: R$%f.2", controle.calcBonusTotal());
    }
}