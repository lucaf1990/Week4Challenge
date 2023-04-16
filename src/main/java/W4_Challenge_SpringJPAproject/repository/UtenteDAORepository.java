package W4_Challenge_SpringJPAproject.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import W4_Challenge_SpringJPAproject.model.Prenotazione;
import W4_Challenge_SpringJPAproject.model.Utente;


@Repository
public interface UtenteDAORepository extends CrudRepository<Utente, Long> {
	
	@Query("SELECT u FROM Utente u WHERE u.prenotazione IN (SELECT p FROM Prenotazione p "
			+ "WHERE p.prenotazionePostazione <> :verificaDataPrenotazione)")
	List<Utente> trovaUtentiChePossonoPrenotareOggi(LocalDate verificaDataPrenotazione );


}
