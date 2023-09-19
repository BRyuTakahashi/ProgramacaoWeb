package aula05exercicio.futebol.TimeController;

import aula05exercicio.futebol.entity.Time;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {

    private List<Time> listaTime = new ArrayList<>();

    @PostMapping()
    public ResponseEntity<Time> cadastrarTime(@RequestBody Time time){
        if(timeValido(time)){
            listaTime.add(time);
            return ResponseEntity.status(201).body(time);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping()
    public ResponseEntity<List> listarTimes(){
        if(listaTime.size() > 0){
            return ResponseEntity.status(200).body(listaTime);
        } else {
            return ResponseEntity.status(204).build();
        }
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Time> procurarTimeIndice(@PathVariable int indice){
        if(indiceValido(indice)){
            return ResponseEntity.status(302).body(listaTime.get(indice));
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/{indice}/registrar-vitoria")
    public ResponseEntity<Time> registrarVitoria(@PathVariable int indice){
        if(indiceValido(indice)){
            listaTime.get(indice).setVitorias(listaTime.get(indice).getVitorias() + 1);
            return ResponseEntity.status(200).body(listaTime.get(indice));
        }  else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/{indice}/registrar-empate")
    public ResponseEntity<Time> registrarEmpate(@PathVariable int indice){
        if(indiceValido(indice)){
            listaTime.get(indice).setEmpates(listaTime.get(indice).getEmpates() + 1);
            return ResponseEntity.status(200).body(listaTime.get(indice));
        }  else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/{indice}/registrar-derrota")
    public ResponseEntity<Time> registrarDerrotas(@PathVariable int indice){
        if(indiceValido(indice)){
            listaTime.get(indice).setDerrotas(listaTime.get(indice).getDerrotas() + 1);
            return ResponseEntity.status(200).body(listaTime.get(indice));
        }  else {
            return ResponseEntity.status(404).build();
        }
    }

    public Boolean timeValido(Time time){
        if(time.getNome().length() >= 3 && time.getNome() != null && !time.getNome().isBlank()
                && time.getTreinador().length() >= 2 && time.getTreinador()  != null && !time.getTreinador().isBlank()){
            return true;
        } else {
            return false;
        }
    }

    public Boolean indiceValido(int indice){
        if(indice >= 0 && indice < listaTime.size()){
            return true;
        } else {
            return false;
        }
    }
}