package W4_Challenge_SpringJPAproject.model;



import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="tabella_postazioni")
public class Postazione implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codiceUnivoco;
	private String descrizionePostazione;
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipoPostazione;
	private int numeroMassimoPerPostazione;
	private boolean postazioneLibera;
	
	@OneToMany(mappedBy = "postazionePrenotata", fetch = FetchType.EAGER) //one to many mapped by - one to one per definire il principale 
	private List<Prenotazione> prenotazione;
	@ManyToOne
	private Edificio edificioSelezionato;
	
	public void setPostazioneBase(TipoPostazione postazione) {
		if (postazione == TipoPostazione.Privata) {
			this.setNumeroMassimoPerPostazione(1);
			this.setTipoPostazione(TipoPostazione.Privata);
			this.setDescrizionePostazione("Postazione: PRIVATA - N° max Persone = 1");
		} else if (postazione == TipoPostazione.OpenSpace) {
			this.setNumeroMassimoPerPostazione(5);
			this.setTipoPostazione(TipoPostazione.OpenSpace);
			this.setDescrizionePostazione("Postazione: OPENSPACE - N° max Persone = 5");
		} else if (postazione == TipoPostazione.SalaRiunioni) {
			this.setNumeroMassimoPerPostazione(10);
			this.setTipoPostazione(TipoPostazione.SalaRiunioni);
			this.setDescrizionePostazione("Postazione: SALA RIUNIONI - N° max Persone = 10");
		}
	}

	public Postazione(String descrizionePostazione, TipoPostazione tipoPostazione, int numeroMassimoPerPostazione,
			boolean postazioneLibera, Edificio edificioSelezionato) {
		super();
		this.descrizionePostazione = descrizionePostazione;
		this.tipoPostazione = tipoPostazione;
		this.numeroMassimoPerPostazione = numeroMassimoPerPostazione;
		this.postazioneLibera = postazioneLibera;
		this.edificioSelezionato = edificioSelezionato;
	}

	
}
