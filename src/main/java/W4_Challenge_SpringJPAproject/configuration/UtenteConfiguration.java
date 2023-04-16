package W4_Challenge_SpringJPAproject.configuration;

import java.util.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import W4_Challenge_SpringJPAproject.model.Postazione;
import W4_Challenge_SpringJPAproject.model.Utente;

@Configuration
@PropertySource("classpath:application.properties")
public class UtenteConfiguration {

	
	@Bean("NuovoUtente")
    @Scope("prototype")
	Utente nuovoUtente(ArrayList<Postazione> p) {
		Utente u= new Utente();
		Faker f=  Faker.instance();
		u.setNomeCompleto(f.name().fullName());
		u.setUserEmail(u.getNomeCompleto() + "@JPAproject.Java");
		u.setUserName(u.getNomeCompleto().toUpperCase().concat("_USER_")+f.code().ean8());
		// u.setPostazioniPrenotate(p);
		System.out.println("Utente correttamenete creato");
		return u;
	}
	
	
	
	
}
