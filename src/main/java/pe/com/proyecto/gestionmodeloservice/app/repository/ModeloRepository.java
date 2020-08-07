package pe.com.proyecto.gestionmodeloservice.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.com.proyecto.gestionmodeloservice.app.jpa.ModeloJpa;

@Repository
public interface ModeloRepository extends CrudRepository<ModeloJpa, Long>{

	ModeloJpa findById(long id);
	
	ModeloJpa findByCodigo(int codigo);
	
}
