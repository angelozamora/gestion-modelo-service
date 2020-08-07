package pe.com.proyecto.gestionmodeloservice.app.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.com.proyecto.gestionmodeloservice.app.jpa.HormaJpa;

@Repository
public interface HormaRepository extends CrudRepository<HormaJpa, Long>{
	
	HormaJpa findById(long id);
	
	HormaJpa findByCodigo(int codigo);
	
}
