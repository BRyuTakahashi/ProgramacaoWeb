package school.sptech.aula04verbosstatus.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.aula04verbosstatus.entity.Filme;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private List<Filme> listaFilmes = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Filme>> listar(){
        if (listaFilmes.isEmpty()){
            return ResponseEntity.status(204).build();
        } else{
            return ResponseEntity.status(200).body(listaFilmes);
        }
    }

    @PostMapping()
    public ResponseEntity<Filme> cadastrar(@RequestBody Filme filme) {
        listaFilmes.add(filme);
        return ResponseEntity.status(200).body(filme);

    }

    @GetMapping("{indice}")
    public ResponseEntity<Filme> procurarIndice(@PathVariable int indice){
        if(indiceValido(indice)){
            return ResponseEntity.status(200).body(listaFilmes.get(indice));
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Filme> atualizarFilme(@RequestBody Filme filme, @PathVariable int indice){
        if (indiceValido(indice)){
            listaFilmes.set(indice, filme);
            return ResponseEntity.status(200).body(filme);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Filme> deletarFilme(@PathVariable int indice){
        if(indiceValido(indice)){
            listaFilmes.remove(indice);
            return ResponseEntity.status(204).body(listaFilmes.get(indice));
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    public Boolean indiceValido(int indice){
        return indice >= 0 && indice < listaFilmes.size();
    }
}
