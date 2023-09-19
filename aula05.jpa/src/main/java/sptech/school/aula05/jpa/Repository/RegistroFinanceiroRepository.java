package sptech.school.aula05.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.aula05.jpa.Entity.RegistroFinanceiro;

public interface RegistroFinanceiroRepository extends JpaRepository<RegistroFinanceiro, Integer> {
}
