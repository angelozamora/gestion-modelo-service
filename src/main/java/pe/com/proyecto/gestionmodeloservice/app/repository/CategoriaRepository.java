package pe.com.proyecto.gestionmodeloservice.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.com.proyecto.gestionmodeloservice.app.jpa.CategoriaJpa;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaJpa, Long>{
	
	CategoriaJpa findById(long id);
	
}
