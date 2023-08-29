package exercicio3.heroi.controller;

import exercicio3.heroi.entity.Heroi;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    private List<Heroi> listaHerois = new ArrayList<>();

    @GetMapping("/{indice}")
    public ResponseEntity<Heroi> listarHerois(@PathVariable int indice){
        if(indiceValido(indice)){
            return ResponseEntity.status(200).body(listaHerois.get(indice));
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping()
    public ResponseEntity<Heroi> cadastrarHeroi(@RequestBody Heroi heroi){
        if(heroi.getNome().length() < 3 || heroi.getNome().isBlank()
        || heroi.getHabilidade().length() < 3 || heroi.getHabilidade().isBlank()
        || heroi.getIdade() <= 0
        || heroi.getForca() <= 0 || heroi.getForca() >= 100 ){
            return ResponseEntity.status(400).build();
        } else {
            listaHerois.add(heroi);
            return ResponseEntity.status(200).body(heroi);
        }
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Heroi> atualizarHeroi(@PathVariable int indice, @PathVariable Heroi heroi){
        if(heroi.getNome().length() < 3 || heroi.getNome().isBlank()
                || heroi.getHabilidade().length() < 3 || heroi.getHabilidade().isBlank()
                || heroi.getIdade() <= 0
                || heroi.getForca() <= 0 || heroi.getForca() >= 100
                || indice < 0 || indice >= listaHerois.size()){
            return ResponseEntity.status(400).build();
        } else {
            listaHerois.set(indice, heroi);
            return ResponseEntity.status(200).body(heroi);
        }
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Heroi> deletarHeroi(@PathVariable int indice){
        if (indiceValido(indice)){
            listaHerois.remove(indice);
            return ResponseEntity.status(204).body(listaHerois.get(indice));
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    public Boolean indiceValido(int indice){
        if(indice >= 0 && indice < listaHerois.size()){
            return true;
        } else {
            return false;
        }
    }


}
