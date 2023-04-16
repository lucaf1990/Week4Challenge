package W4_Challenge_SpringJPAproject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import W4_Challenge_SpringJPAproject.model.Edificio;

@Repository
public interface EdificioDAORepository extends CrudRepository<Edificio, Long> {

	
	
}
