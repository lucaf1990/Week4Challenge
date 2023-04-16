package W4_Challenge_SpringJPAproject.runner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import W4_Challenge_SpringJPAproject.model.Edificio;
import W4_Challenge_SpringJPAproject.model.Postazione;
import W4_Challenge_SpringJPAproject.model.TipoPostazione;
import W4_Challenge_SpringJPAproject.model.Utente;
import W4_Challenge_SpringJPAproject.repository.PostazioneDAORepository;
import jakarta.persistence.PersistenceException;

@Service
public class PostazioneService {

	@Autowired
	private PostazioneDAORepository pdr;
	@Autowired
	@Qualifier("CreaPostazioneVuota")
	private ObjectProvider<Postazione> nuovaPostazione;

	public List<Postazione> trovaPostazionePerCittaeTipo(TipoPostazione tp, String citta) {

		return pdr.trovaPostazionePerTipoECitta(tp, citta);

	}

	public void creaPostazione(Edificio e, TipoPostazione postazione) {
		try {

			Postazione p = nuovaPostazione.getObject(e, postazione);
			insertPostazione(p);
		} catch (PersistenceException e1) {
			throw new PersistenceException("Errore nel salvataggio della postazione nel database", e1);
		}
	}

	private void insertPostazione(Postazione p) {
		pdr.save(p);
	}

	public void deletePostazione(Postazione p) {
		try {
			pdr.delete(p);
			System.out.println("Postazione eliminata correttamente dal database");
		} catch (PersistenceException e) {
			throw new PersistenceException("Errore nell'eliminazione della postazione dal database", e);
		}

	}

	public void updatePostazione(Postazione p) {
		try {
			pdr.save(p);
			System.out.println("Postazione correttamente aggiornata nel database");
		} catch (PersistenceException e) {
			throw new PersistenceException("Errore nell'aggiornamento dati della postazione nel database", e);
		}

	}

	public Postazione trovaPostazione(Long id) {
		try {
			Optional<Postazione> optionalPostazione = pdr.findById(id);
			if (optionalPostazione.isPresent()) {

				return optionalPostazione.get();
			} else {
				throw new PersistenceException("Postazione non trovato per id: " + id);
			}
		} catch (PersistenceException e) {
			throw new PersistenceException("Errore nella ricerca della postazione", e);
		}
	}

	public List<Postazione> findAllPostazioni() {
		return (List<Postazione>) pdr.findAll();
	}
}
