package Mercado.Mercado;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/produtos")
@RestController
public class ProdutosController {

    private List<Produtos> lista = new ArrayList<>();

    @PostMapping
    public Produtos cadastrarProduto(@RequestBody Produtos produto){
        lista.add(produto);
        return produto;
    }

    @GetMapping
    public List<Produtos> consultarProdutos(){
        if(!lista.isEmpty()){
            return lista;
        } else {
            return null;
        }
    }

    @PutMapping("/{indice}")
    public Produtos atualiarProduto(@PathVariable Integer indice, @RequestBody Produtos produto){
        if(indiceValido(indice)){
            lista.set(indice, produto);
            return produto;
        } else {
            return null;
        }
    }

    @GetMapping("/estoque/{qtdEstoque}")
    public Produtos consultarProdutoEstoque(@PathVariable Integer qtdEstoque){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getQtdEstoque() >= qtdEstoque){
                return lista.get(i);
            }
        }
        return null;
    }


    public Boolean indiceValido(Integer indice){
        return indice >= 0 && indice < lista.size();
    }
}
