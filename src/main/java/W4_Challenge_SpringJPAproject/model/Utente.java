package W4_Challenge_SpringJPAproject.model;

import java.io.Serializable;
import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="tabella_utenti")
public class Utente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	private String nomeCompleto;
	private String userEmail;
	@OneToMany(mappedBy = "utente") //one to many mapped by - one to one per definire il principale 
	private List<Prenotazione> prenotazione;
	
	
	
	
	
	
}
