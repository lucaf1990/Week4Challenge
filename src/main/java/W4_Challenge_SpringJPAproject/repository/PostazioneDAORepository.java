package W4_Challenge_SpringJPAproject.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import W4_Challenge_SpringJPAproject.model.Postazione;
import W4_Challenge_SpringJPAproject.model.TipoPostazione;


@Repository
public interface PostazioneDAORepository extends CrudRepository<Postazione, Long> {

	@Query(value="SELECT p FROM Postazione p WHERE p.tipoPostazione= :tipoPostazione AND p.edificioSelezionato.cittaEdificio= :cittaEdificio")
	
	 List<Postazione> trovaPostazionePerTipoECitta(TipoPostazione tipoPostazione,String cittaEdificio); 

	@Query(value="SELECT p FROM Postazione p WHERE p.postazioneLibera = true")
	
	 List<Postazione> trovaPostazioneSeLibera(); 


}
