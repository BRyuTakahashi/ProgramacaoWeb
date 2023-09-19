package school.sptech.validacoes;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.validacoes.entity.Musica;

//Camada que vai lidar com o DB
public interface MusicaRepository extends JpaRepository<Musica, Integer> {

}
