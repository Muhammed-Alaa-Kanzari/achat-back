package tn.esprit.rh.achat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.entities.Operateur;

@Repository
public interface OperateurRepository extends CrudRepository<Operateur, Long> {

	List<Operateur> getAllOperateurs();

	Operateur createOperateur(Operateur operateur);

	Operateur updateOperateur(long id, Operateur operateur);

	void deleteOperateur(long id);

	Operateur getOperateurById(long id);
}
