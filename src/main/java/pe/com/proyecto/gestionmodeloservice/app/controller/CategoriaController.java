package pe.com.proyecto.gestionmodeloservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.proyecto.gestionmodeloservice.api.models.Categoria;
import pe.com.proyecto.gestionmodeloservice.api.models.Categorias;
import pe.com.proyecto.gestionmodeloservice.api.models.Resultado;
import pe.com.proyecto.gestionmodeloservice.app.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping(value="/categoria")
	public Categorias obtenerCategoria() {
		Categorias categorias = new Categorias();
		categorias = categoriaService.obtenerCategorias();
		return categorias;
	}
	
	@PostMapping(value="/categoria")
	public Categorias registrarCategorias(@RequestBody Categoria categoria) {
		Categorias categorias = new Categorias();	
		categorias = categoriaService.registrarCategorias(categoria);
		return categorias;
	};
	
	@DeleteMapping(value="/categoria/id/{id}")
	public Resultado eliminarModeloxId(@PathVariable (name="id") String id) {
		Resultado resultado = new Resultado();
		resultado = categoriaService.eliminarCategoriasxId(id);
		return resultado;
	};
}
