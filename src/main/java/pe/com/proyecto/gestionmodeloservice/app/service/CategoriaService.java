package pe.com.proyecto.gestionmodeloservice.app.service;

import pe.com.proyecto.gestionmodeloservice.api.models.Categoria;
import pe.com.proyecto.gestionmodeloservice.api.models.Categorias;
import pe.com.proyecto.gestionmodeloservice.api.models.Resultado;

public interface CategoriaService {
	
	public Categorias obtenerCategorias();
	
	public Categorias registrarCategorias(Categoria categoria);
	
	public Resultado eliminarCategoriasxId(String id);
}
