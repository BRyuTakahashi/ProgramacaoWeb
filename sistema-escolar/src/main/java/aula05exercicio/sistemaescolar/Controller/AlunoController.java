package aula05exercicio.sistemaescolar.Controller;

import aula05exercicio.sistemaescolar.entity.Aluno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private List<Aluno> listaAluno = new ArrayList<>();

    @PostMapping()
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        if(alunoValido(aluno)){
            listaAluno.add(aluno);
            return ResponseEntity.status(201).body(aluno);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping()
    public ResponseEntity<List> listarAlunos(){
        if(listaAluno.size() > 0){
            return ResponseEntity.status(302).body(listaAluno);
        } else {
            return ResponseEntity.status(204).build();
        }
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Aluno> buscarAlunoIndice(@PathVariable int indice){
        if(indiceValido(indice)){
            return ResponseEntity.status(302).body(listaAluno.get(indice));
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable int indice, @RequestBody Aluno aluno){
        if(alunoValido(aluno) && indiceValido(indice)){
            listaAluno.set(indice, aluno);
            return ResponseEntity.status(200).body(aluno);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    public Boolean alunoValido(Aluno aluno) {
        if(aluno.getNome().length() >= 3 && aluno.getNome() != null && !aluno.getNome().isBlank()
                && aluno.getEmail().contains("@") && aluno.getEmail().contains(".school") && aluno.getEmail() != null && !aluno.getEmail().isBlank()
                && aluno.getNotaContinuada1() >= 0 && aluno.getNotaContinuada1() <= 10
                && aluno.getNotaContinuada2() >= 0 && aluno.getNotaContinuada2() <= 10
                && aluno.getNotaContinuada3() >= 0 && aluno.getNotaContinuada3() <= 10
                && aluno.getNotaIntegrada() >= 0 && aluno.getNotaIntegrada() <= 10){
            return true;
        } else {
            return false;
        }
    }

    public Boolean indiceValido(int indice){
        if(indice >= 0 && indice < listaAluno.size()){
            return true;
        } else {
            return false;
        }
    }
}
