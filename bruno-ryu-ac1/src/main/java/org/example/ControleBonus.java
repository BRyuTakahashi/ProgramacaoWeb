package org.example;

import java.util.ArrayList;
import java.util.List;

public class ControleBonus {

    // atributos

    List<IControle> listaFuncionario;

    // construtor

    public ControleBonus(){
        listaFuncionario = new ArrayList<>();
    }

    // metodos

    public Double calcBonusTotal(){
        Double bonus = 0.0;
        for(int indice = 0; indice < listaFuncionario.size(); indice++){
            bonus += listaFuncionario.get(indice).getValorBonus();
        }
        return bonus;
    }

    public void adicionarFuncionario(IControle funcionario){
        listaFuncionario.add(funcionario);
        System.out.println("Funcionario cadastrado");
    }

    @Override
    public String toString() {
        return "ControleBonus{" +
                "listaFuncionario=" + listaFuncionario +
                '}';
    }
}
