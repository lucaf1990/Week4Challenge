package W4_Challenge_SpringJPAproject.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import W4_Challenge_SpringJPAproject.model.Utente;
import W4_Challenge_SpringJPAproject.repository.UtenteDAORepository;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;

@Service

public class UtenteService {

	@Autowired
	private UtenteDAORepository udr;
	@Autowired
	@Qualifier("NuovoUtente")
	private ObjectProvider<Utente> createUtente;



	public void creaUtente() {
			for (int i = 0; i < 20; i++) {
				insertUtente(createUtente.getObject());
			}
			System.out.println("Utenti correttamente salvati nel database");
	}

	private Utente insertUtente(Utente u) {
		udr.save(u);
		return u;
	}

	public Utente findUtenteByID(Long id) {
		try {
			Optional<Utente> optionalUtente = udr.findById(id);
			if (optionalUtente.isPresent()) {

				return optionalUtente.get();
			} else {
				throw new PersistenceException("Utente non trovato per id: " + id);
			}
		} catch (PersistenceException e) {
			throw new PersistenceException("Errore nella ricerca dell'utente", e);
		}
	}

	public List<Utente> findAllUtenti() {
		try {
			return (List<Utente>) udr.findAll();
		} catch (PersistenceException e) {
			throw new PersistenceException("Errore nella ricerca della lista utenti", e);
		}

	}

	public void removeUtente(Utente u) {
		try {
			udr.delete(u);
			System.out.println("Utente correttamente eliminato dal database");
		} catch (PersistenceException e) {
			throw new PersistenceException("Errore nell'eliminazione dell'utente dal database", e);
		}

	}

	public void updateUtente(Utente u) {
		try {
			udr.save(u);
			System.out.println("Utente correttamente aggiornato nel database");
		} catch (PersistenceException e) {
			throw new PersistenceException("Errore nell'aggiornamento dati dell'utente nel database", e);
		}

	}
}
