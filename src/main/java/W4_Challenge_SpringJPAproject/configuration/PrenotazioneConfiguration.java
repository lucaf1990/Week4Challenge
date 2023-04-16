package W4_Challenge_SpringJPAproject.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import java.time.LocalDate;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import W4_Challenge_SpringJPAproject.model.Postazione;
import W4_Challenge_SpringJPAproject.model.Prenotazione;
import W4_Challenge_SpringJPAproject.model.Utente;
import W4_Challenge_SpringJPAproject.repository.UtenteDAORepository;
import W4_Challenge_SpringJPAproject.runner.PostazioneService;

@Configuration
@PropertySource("classpath:application.properties")
public class PrenotazioneConfiguration {
//non intergaisce con il server
	
	private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	@Bean("NuovaPrenotazione")
	@Scope("prototype")
	Prenotazione nuovaPrenotazione(LocalDate ld, Postazione p, Utente u) {
//logica a livello di java 
		Prenotazione prenotazione1 = new Prenotazione();
		prenotazione1.setPrenotazionePostazione(ld);
		prenotazione1.setFinePrenotazionePostazione(prenotazione1.getPrenotazionePostazione().plusDays(1));
		prenotazione1.setPostazionePrenotata(p);
		prenotazione1.setUtente(u);
		
		scheduler.schedule(() -> {
			p.setPostazioneLibera(true);
		}, 24, TimeUnit.HOURS);
		return prenotazione1;

	}


	
}
