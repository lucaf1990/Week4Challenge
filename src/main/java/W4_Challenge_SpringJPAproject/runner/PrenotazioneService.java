package W4_Challenge_SpringJPAproject.runner;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import W4_Challenge_SpringJPAproject.model.Postazione;
import W4_Challenge_SpringJPAproject.model.Prenotazione;
import W4_Challenge_SpringJPAproject.model.Utente;
import W4_Challenge_SpringJPAproject.repository.PrenotazioneDAORepository;
import jakarta.persistence.PersistenceException;

@Service
public class PrenotazioneService {
//richiamo il dao
	@Autowired
	private PrenotazioneDAORepository pdr;
	@Autowired
	private PostazioneService ps;
	@Autowired
	@Qualifier("NuovaPrenotazione")
	private ObjectProvider<Prenotazione> nuovaPrenotazione;

	public void creaSalvaPrenotazione(LocalDate of, Postazione p, Utente u) {
		// controlli: controllare data che non sia passata,
		// controllare che utente non abbia gia prenotazione per quella data,
		// postazione sia vuota per quella data

		//
		// List<Prenotazione> myList=u.getPrenotazione();
		// myList.stream()
		// .filter((prenotazione)->prenotazione.getPrenotazionePostazione()==of)
		// .collect(Collectors.toList()); //se questo null non ho prenotazione epr la
		// data di oggi

		LocalDate checkDate = LocalDate.now();
		if (of.isAfter(checkDate)) {
			if (findPrenotazioneByUtenteAndData(u, of) == null) {
				// vuol dire che lui non ha prenotazioni
				if (p.isPostazioneLibera()) {
					// controllo post libera
					// qui creo efettivamente la prenotazione

					p.setPostazioneLibera(false);
					ps.updatePostazione(p);
					insertPrenotazione(nuovaPrenotazione.getObject(of, p, u));
					System.out.println("Prenotazione inserita correttamente");
				} else {System.out.println("Postazione già occupata, scegli un'altra postazione");}

			} else {System.out.println("Hai già una  prenotazione per questa data! Scegli un altra data");}

		} else {System.out.println("Scegli una data futura per la prenotazione");}

	}
	
	private Prenotazione findPrenotazioneByUtenteAndData(Utente u, LocalDate ld) {
		return 	pdr.findByUtenteAndPrenotazionePostazione(u,ld);
		 
	}
	

	Prenotazione nuovaPrenotazioneCiao(LocalDate of, Postazione p, Utente u) {
		Prenotazione prenotazione = nuovaPrenotazione.getObject(of, p, u);
		insertPrenotazione(prenotazione);
return prenotazione;
	}

	private void insertPrenotazione(Prenotazione p) {
		pdr.save(p);
	}

	public void deletePrenotazione(Prenotazione p) {
		try {
			pdr.delete(p);
			System.out.println("Prenotazione eliminata correttamente dal database");
		} catch (PersistenceException e) {
			throw new PersistenceException("Errore nell'eliminazione della Prenotazione dal database", e);
		}

	}

	public void updatePrenotazione(Prenotazione p) {
		try {
			pdr.save(p);
			System.out.println("Prenotazione correttamente aggiornata nel database");
		} catch (PersistenceException e) {
			throw new PersistenceException("Errore nell'aggiornamento dati della Prenotazione nel database", e);
		}

	}

	public List<Prenotazione> findAllPrenotazioni() {
		return (List<Prenotazione>) pdr.findAll();
	}

}
