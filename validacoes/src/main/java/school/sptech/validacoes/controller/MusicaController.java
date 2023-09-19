package school.sptech.validacoes.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.validacoes.MusicaRepository;
import school.sptech.validacoes.entity.Musica;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaRepository resitory;

    @GetMapping
    public ResponseEntity<List<Musica>> listar(){
        List<Musica> musicas = this.resitory.findAll();

        if(musicas.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(302).body(musicas);

        }
    }

    @PostMapping
    public ResponseEntity<Musica> cadastrar(@RequestBody @Valid Musica musica){
        Musica musicaCadastro = this.resitory.save(musica);
        return ResponseEntity.status(201).body(musica);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Musica> buscarId(@PathVariable int indice){

        Optional<Musica> musicaOpt = this.resitory.findById(indice);

        if(musicaOpt.isPresent()){
            Musica musicaId = musicaOpt.get();
            return ResponseEntity.status(302).body(musicaId);
        } else {
            return ResponseEntity.status(402).build();
        }
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Musica> atualizarMusica(@RequestBody Musica musica, @PathVariable int indice){

        if(this.resitory.existsById(indice)){
            Musica musicaAtualizada = this.resitory.save(musica);
            return ResponseEntity.status(200).body(musica);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Musica> deletarMusica(@PathVariable int indice){
        if(this.resitory.existsById(indice)){
            this.resitory.deleteById(indice);
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
