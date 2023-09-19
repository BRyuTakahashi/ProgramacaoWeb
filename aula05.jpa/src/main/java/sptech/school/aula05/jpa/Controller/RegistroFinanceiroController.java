package sptech.school.aula05.jpa.Controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.aula05.jpa.Entity.RegistroFinanceiro;
import sptech.school.aula05.jpa.Repository.RegistroFinanceiroRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registros")
public class RegistroFinanceiroController {

    @Autowired
    private RegistroFinanceiroRepository repository;

    @PostMapping
    public ResponseEntity<RegistroFinanceiro> cadastrarRegistro(@RequestBody RegistroFinanceiro registro){
        RegistroFinanceiro registroSalvo = this.repository.save(registro);
        return ResponseEntity.status(201).body(registro);
    }

    @GetMapping
    public ResponseEntity<List<RegistroFinanceiro>> listarRegistros(){
        return ResponseEntity.status(302).body(repository.findAll());
    }

    @GetMapping("/{indice}")
    public ResponseEntity<RegistroFinanceiro> buscarRegistroIndice(@PathVariable Integer id){

        Optional<RegistroFinanceiro> registroOpt = this.repository.findById(id);

        if(registroOpt.isPresent()){
            RegistroFinanceiro registroFinanceiro = registroOpt.get();
            return ResponseEntity.status(200).body(registroFinanceiro);
        }

        return ResponseEntity.status(402).build();
    }

    @PutMapping("/{indice}")
    public ResponseEntity<RegistroFinanceiro> atualizarRegistro(@RequestBody RegistroFinanceiro registro, @PathVariable Integer id){

        if (this.repository.existById(id)){
            RegistroFinanceiro registroAtualizado = this.repository.save(registro);
            return ResponseEntity.status(200).body(registroAtualizado);
        }

        /*if(indiceValido(indice)){
            listaRegistro.set(indice, registro);
            return ResponseEntity.status(200).body(registro);
        } else {
            return ResponseEntity.status(400).build();
        }*/
        return ResponseEntity.status(400).build();
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<RegistroFinanceiro> deletarRegistro(@PathVariable Integer id){

        if (this.repository.existById(id)){
            this.repository.deleteId(id);
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(404).build();

        /*if(indiceValido(indice)){
            listaRegistro.remove(indice);
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(400).build();
        }*/
    }

    @GetMapping("/ganhos")
    public ResponseEntity<List<RegistroFinanceiro>> listarRegistroPositivo(){
        List<RegistroFinanceiro> registrosPositivos = new ArrayList<>();
        for (int indice = 0; indice < listaRegistro.size(); indice++){
            if(listaRegistro.get(indice).getValor() >= 0){
                registrosPositivos.add(listaRegistro.get(indice));
            }
        }
        return ResponseEntity.status(302).body(registrosPositivos);
    }

    @GetMapping("/despesas")
    public ResponseEntity<List<RegistroFinanceiro>> listarRegistroDespesas(){
        List<RegistroFinanceiro> registrosDespess = new ArrayList<>();
        for (int indice = 0; indice < listaRegistro.size(); indice++){
            if(listaRegistro.get(indice).getValor() < 0){
                registrosDespess.add(listaRegistro.get(indice));
            }
        }

        return ResponseEntity.status(302).body(registrosDespess);
    }

}
