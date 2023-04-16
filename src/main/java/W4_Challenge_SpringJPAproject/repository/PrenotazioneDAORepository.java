package W4_Challenge_SpringJPAproject.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import W4_Challenge_SpringJPAproject.model.Edificio;
import W4_Challenge_SpringJPAproject.model.Postazione;
import W4_Challenge_SpringJPAproject.model.Prenotazione;
import W4_Challenge_SpringJPAproject.model.Utente;

@Repository
public interface PrenotazioneDAORepository extends CrudRepository<Prenotazione, Long> {

	public List<Prenotazione> findByPostazionePrenotata(Postazione postazionePrenotata);
	
	public List<Prenotazione> findByPrenotazionePostazione(LocalDate prenotazionePostazione);
	
	public List<Prenotazione> findByUtente(Utente utente);
	
	public Prenotazione findByUtenteAndPrenotazionePostazione(Utente utente,LocalDate prenotazionePostazione);
	
}
