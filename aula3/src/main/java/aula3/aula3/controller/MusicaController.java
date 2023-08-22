package aula3.aula3.controller;

import aula3.aula3.entity.Musica;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// @Controller -> MCV -> retorna paginas em html
@RestController // API em REST
@RequestMapping("/musicas")
public class MusicaController {

    private List<Musica> musicas = new ArrayList<>();

    @GetMapping //usar verbos da lingua portuguesa
    public List<Musica> listar(){
        return musicas;
    }

    @PostMapping
    public Musica cadastrar(@RequestBody Musica novaMusica){

        // Musica novaMusica = new Musica(nome, artista);
        musicas.add(novaMusica);
        return novaMusica;
    }

    @GetMapping("/{indice}")
    public Musica consultarPorIndice(@PathVariable Integer indice){
        if(indiceValido(indice)){
            return musicas.get(indice);
        } else {
            return null;
        }
    }

    @PutMapping("/{indice}")
    public Musica atualizar(@PathVariable Integer indice, @RequestBody Musica novaMusica){
        if(indiceValido(indice)){
            return musicas.set(indice, novaMusica);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{indice}")
    public String remover(@PathVariable int indice){
        if(indiceValido(indice)){
            musicas.remove(indice);
            return "Música removida com sucesso";
        } else {
            return "Música não encontrada";
        }
    }

    public Boolean indiceValido(Integer indice){
        return indice >= 0 || indice <= musicas.size();
    }
}
