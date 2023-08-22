package aula3.aula3.entity;

import java.time.LocalDate;

// Tabela música
// Model
// Entity
public class Musica {


    private String nome;
    private String artista;
    private LocalDate dataCriacao = LocalDate.now();

    // Sobrecarga
    public Musica(){

    }

    public Musica (String nome, String artista){
        this.nome = nome;
        this.artista = artista;
    }

    public static void main(String[] args) {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}
