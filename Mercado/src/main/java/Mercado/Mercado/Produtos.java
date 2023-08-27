package Mercado.Mercado;

public class Produtos {

    private String nome;
    private Double preco;
    private Integer qtdEstoque;
    private Double valorTotalEstoque;

    public Produtos(String nome, Double preco, Integer qtdEstoque){
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.valorTotalEstoque = qtdEstoque * preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Double getValorTotalEstoque() {
        return valorTotalEstoque;
    }

    public void setValorTotalEstoque(Double valorTotalEstoque) {
        this.valorTotalEstoque = valorTotalEstoque;
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", qtdEstoque=" + qtdEstoque +
                ", valorTotalEstoque=" + valorTotalEstoque +
                '}';
    }
}
