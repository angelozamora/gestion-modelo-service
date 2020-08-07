package pe.com.proyecto.gestionmodeloservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.proyecto.gestionmodeloservice.api.models.Modelo;
import pe.com.proyecto.gestionmodeloservice.api.models.Modelos;
import pe.com.proyecto.gestionmodeloservice.api.models.Resultado;
import pe.com.proyecto.gestionmodeloservice.app.service.ModeloService;

@RestController
@RequestMapping("/modelos")
public class ModeloController {
	@Autowired
	ModeloService modeloService;
	@GetMapping(value="/modelo")
	public Modelos obtenerModelos() {
		Modelos modelos = new Modelos();
		modelos = modeloService.obtenerModelos();
		return modelos;
	};
	@GetMapping(value="/modelo/codigo/{codigo}")
	public Modelos obtenerModelosxCodigo(@PathVariable (name="codigo") String codigo) {
		Modelos modelos = new Modelos();
		modelos = modeloService.obtenerModelosxCodigo(codigo);
		return modelos;
	};
	@PostMapping(value="/modelo")
	public Modelos registrarModelos(@RequestBody Modelo modelo) {
		Modelos modelos = new Modelos();
		modelos = modeloService.registrarModelos(modelo);
		return modelos;
	};
	@DeleteMapping(value="/modelo/id/{id}")
	public Resultado eliminarModeloxId(@PathVariable (name="id") String id) {
		Resultado resultado = new Resultado();
		resultado = modeloService.eliminarModelosxId(id);
		return resultado;
	};
}
