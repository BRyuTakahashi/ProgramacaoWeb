package school.sptech.validacoes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Musica {

    @Id // -> indica a chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //-> indica o auto-increment
    private Integer id;

    @NotBlank
    private String nome;

    @Size(min = 3, max = 10)
    @NotBlank
    private String album;

    private LocalDate dataLancamento;

    @DecimalMin(value = "1.0")
    @DecimalMax(value = "10.0")
    private Double nota;

    @Min(1)
    private Integer ranking;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
}
