package W4_Challenge_SpringJPAproject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import W4_Challenge_SpringJPAproject.model.Edificio;
import W4_Challenge_SpringJPAproject.runner.EdificioService;

@Configuration
@PropertySource("classpath:application.properties")
public class EdificioConfiguration {

	
	
	@Bean("NuovoEdificio")
    @Scope("prototype")
	Edificio nuovoEdificio() {
		Edificio e= new Edificio();
		Faker f=  Faker.instance();
		e.setCittaEdificio(f.address().cityName());
		e.setIndirizzoEdificio(f.address().fullAddress());
		e.setNomeEdificio(f.harryPotter().spell());
		System.out.println("Edificio correttamente creato");
		return e;
	}
	
}
