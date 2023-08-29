package herois.herois;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroisController {

    private List<Heroi> listaHerois = new ArrayList<>();

    @GetMapping
    public List devolverLista(){
        return listaHerois;
    }

    @GetMapping("/{indice}")
    public Heroi imprimirHeroiIndice(@PathVariable Integer indice){
        if(indiceValido(indice)) {
            return listaHerois.get(indice);
        } else {
            return null;
        }
    }

    @GetMapping("/cadastrar/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
    public Heroi adicionarHeroi(@PathVariable String nome, @PathVariable String habilidade, @PathVariable Integer idade, @PathVariable Integer forca, @PathVariable Boolean vivo){
        Heroi heroi = new Heroi(
                nome,
                idade,
                habilidade,
                forca,
                vivo
        );
        listaHerois.add(heroi);
         return heroi;
    }

    @GetMapping("/atualizar/{indice}/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
    public Heroi atualizarHeroi(@PathVariable Integer indice, @PathVariable String nome, @PathVariable String habilidade, @PathVariable Integer idade, @PathVariable Integer forca, @PathVariable Boolean vivo){
        if(indiceValido(indice)){
            Heroi heroi = new Heroi(nome, idade, habilidade, forca, vivo);
            return listaHerois.set(indice, heroi);
        } else {
            return null;
        }
    }

    @GetMapping("/remover/{indice}")
    public String removerHeroi(@PathVariable Integer indice){
        if(indiceValido(indice)){
            listaHerois.remove(indice);
            return "Heroi removido";
        } else {
            return "Heroi não encontrado";
        }
    }

    private Boolean indiceValido(Integer indice){
        return indice > 0 && indice <= listaHerois.size();
    }
}
