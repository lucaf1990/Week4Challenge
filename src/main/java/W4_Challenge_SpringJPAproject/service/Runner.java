package W4_Challenge_SpringJPAproject.service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import W4_Challenge_SpringJPAproject.configuration.PrenotazioneConfiguration;
import W4_Challenge_SpringJPAproject.model.Edificio;
import W4_Challenge_SpringJPAproject.model.Postazione;
import W4_Challenge_SpringJPAproject.model.Prenotazione;
import W4_Challenge_SpringJPAproject.model.TipoPostazione;
import W4_Challenge_SpringJPAproject.model.Utente;
import W4_Challenge_SpringJPAproject.repository.PostazioneDAORepository;
import W4_Challenge_SpringJPAproject.repository.UtenteDAORepository;
import W4_Challenge_SpringJPAproject.runner.EdificioService;
import W4_Challenge_SpringJPAproject.runner.PostazioneService;
import W4_Challenge_SpringJPAproject.runner.PrenotazioneService;
import W4_Challenge_SpringJPAproject.runner.UtenteService;
import lombok.Data;
@Component
@Data
public class Runner implements ApplicationRunner {

	@Autowired UtenteService utente;
	@Autowired EdificioService edificio;
	@Autowired PostazioneService postazione;
	@Autowired PrenotazioneService prenotazione;
	
	@Autowired PostazioneDAORepository pdr;
	@Autowired UtenteDAORepository udr;
	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		//CREAZIONE TABELLE E VERIFICA DEL COLLEGAMENTO CON IL DATABASE//
		
		System.out.println("Applicazione inizializzata correttamente");
		
		
		//FUNZIONE CREA UTENTI (Genera 20 utenti casuali)
		//utente.creaUtente();
		
		
		
		//FUNZIONE PER LA RICERCA DELL'UTENTE
		Utente u2 = utente.findUtenteByID(2l);
		Utente u3 = utente.findUtenteByID(3l);
		Utente u4 = utente.findUtenteByID(4l);
		Utente u5 = utente.findUtenteByID(5l);
		Utente u6 = utente.findUtenteByID(1l);
		
		
		
		//FUNZIONE CREA EDIFICI (Genera 20 edifici casuali)
		//edificio.createEdificio();
		
		
		
		//FUNZIONE PER LA RICERCA DEGLI EDIFICI
		Edificio e= edificio.findEdificioByID(1l);	
		Edificio e2= edificio.findEdificioByID(2l);	
		Edificio e3= edificio.findEdificioByID(3l);	
		Edificio e4= edificio.findEdificioByID(4l);	
		Edificio e5= edificio.findEdificioByID(5l);	
		Edificio e6= edificio.findEdificioByID(6l);	
		Edificio e7= edificio.findEdificioByID(7l);	
		Edificio e8= edificio.findEdificioByID(8l);	
	Edificio e9= edificio.findEdificioByID(9l);	

		
		
		//FUNZIONE PER LA CREAZIONE DELLE POSTAZIONI
		//postazione.creaPostazione(e, TipoPostazione.Privata);
		//postazione.creaPostazione(e2, TipoPostazione.SalaRiunioni);
		//postazione.creaPostazione(e3, TipoPostazione.Privata);
		//postazione.creaPostazione(e4, TipoPostazione.OpenSpace);
		//postazione.creaPostazione(e5, TipoPostazione.Privata);
		//postazione.creaPostazione(e6, TipoPostazione.Privata);
		//postazione.creaPostazione(e7, TipoPostazione.OpenSpace);
		//postazione.creaPostazione(e8, TipoPostazione.SalaRiunioni);
		//postazione.creaPostazione(e9, TipoPostazione.OpenSpace);

		
		
		//FUNZIONE PER LA RICERCA DELLE POSTAZIONI 
		Postazione p= postazione.trovaPostazione(1l);
		Postazione p1= postazione.trovaPostazione(2l);

		
		
		//FUNZIONE PER LA CREAZIONE DELLE PRENOTAZIONI 
		//(Verifica che:
		// 			 	    data non sia passata,
						//  utente non abbia gia prenotazione per quella data,
					    //  postazione sia vuota per quella data)
		//prenotazione.creaSalvaPrenotazione(LocalDate.of(2023, 10, 21),p1,  u6);
		//prenotazione.creaSalvaPrenotazione(LocalDate.of(2022, 10, 21),p1,  u6); //errore data passata
		//prenotazione.creaSalvaPrenotazione(LocalDate.of(2023, 10, 21),p1,  u6); //errore utente ha gia prenotazione per quel giorno 
		//prenotazione.creaSalvaPrenotazione(LocalDate.of(2023, 10, 21),p1,  u4); //errore postazione gia occupata per quel giorno
		

		
		
		//FUNZIONE PER LA RICERCA DELLE POSTAZIONI PER CITTA' E TIPO
		//System.out.println(postazione.trovaPostazionePerCittaeTipo(TipoPostazione.OpenSpace, "")); //inserire una città nella stringa
		


		

	}

}
