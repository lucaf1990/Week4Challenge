package W4_Challenge_SpringJPAproject.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.Query;

import W4_Challenge_SpringJPAproject.model.Edificio;
import W4_Challenge_SpringJPAproject.model.Postazione;
import W4_Challenge_SpringJPAproject.model.TipoPostazione;
import W4_Challenge_SpringJPAproject.repository.PostazioneDAORepository;

@Configuration
@PropertySource("classpath:application.properties")
public class PostazioneConfiguration {


	@Bean("CreaPostazioneVuota")
	@Scope("prototype")
	Postazione nuovaPostazione(Edificio e, TipoPostazione postazione) {
		Postazione p= new Postazione();
		p.setPostazioneBase(postazione);
		p.setPostazioneLibera(true);
		p.setEdificioSelezionato(e);
		System.out.println("Postazione creata correttamente");
		return p;
	}
	
	
}
