package W4_Challenge_SpringJPAproject.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import W4_Challenge_SpringJPAproject.model.Edificio;
import W4_Challenge_SpringJPAproject.repository.EdificioDAORepository;
import jakarta.persistence.PersistenceException;

@Service
public class EdificioService {

	@Autowired
	private EdificioDAORepository edr;
	@Autowired
	@Qualifier("NuovoEdificio")
	private ObjectProvider<Edificio> nuovoEdificio;

	public void createEdificio() {

		try {
			for (int i = 0; i < 20; i++) {
				insertEdificio(nuovoEdificio.getObject());
			}
			System.out.println("Edifici correttamente salvati nel database");
		} catch (PersistenceException e) {
			System.out.println("Errore nel salvataggio dell'efidicio nel database");

		}

	}

	private void insertEdificio(Edificio e) {
		edr.save(e);
	}

	public Edificio findEdificioByID(Long id) {
		try {
			Optional<Edificio> optionalEdificio = edr.findById(id);
			if (optionalEdificio.isPresent()) {
				return optionalEdificio.get();
			} else {
				throw new PersistenceException("Edificio non trovato per id: " + id);
			}
		} catch (PersistenceException e) {
			throw new PersistenceException("Errore nella ricerca dell'edificio", e);
		}

	}

	public List<Edificio> findAllEdifici() {
		try {
			return (List<Edificio>) edr.findAll();
		} catch (PersistenceException e) {
			throw new PersistenceException("Errore nella ricerca dell'elenco edifici", e);
		}

	}

	public void removeEdificio(Edificio e) {
		try {
			edr.delete(e);
			System.out.println("Edificio correttamente eliminato dal database");
		} catch (PersistenceException e1) {
			throw new PersistenceException("Errore nella rimozione dell'edificio", e1);
		}

	}

	public void updateEdificio(Edificio e) {
		try {
			edr.save(e);
			System.out.println("Edificio correttamente aggiornato nel database");
		} catch (PersistenceException e1) {
			throw new PersistenceException("Errore nell'update dei nuovi dati dell'edificio nel database", e1);
		}

	}

}
