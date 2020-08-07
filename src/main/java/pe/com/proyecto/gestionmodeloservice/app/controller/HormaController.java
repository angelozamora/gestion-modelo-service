package pe.com.proyecto.gestionmodeloservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.proyecto.gestionmodeloservice.api.models.Horma;
import pe.com.proyecto.gestionmodeloservice.api.models.Hormas;
import pe.com.proyecto.gestionmodeloservice.api.models.Resultado;
import pe.com.proyecto.gestionmodeloservice.app.service.HormaService;

@RestController
@RequestMapping("/hormas")
public class HormaController {
	@Autowired
	HormaService hormaService;
	
	@GetMapping(value="/horma")
	public Hormas obtenerHormas() {
		Hormas hormas = new Hormas();
		hormas = hormaService.obtenerHormas();
		return hormas;
	};
	@GetMapping(value="/hormas/codigo/{codigo}")
	public Hormas obtenerHormasxCodigo(@PathVariable (name="codigo") String codigo) {
		Hormas hormas = new Hormas();
		hormas = hormaService.obtenerHormasxCodigo(codigo);
		return hormas;
	};
	@PostMapping(value="/horma")
	public Hormas registrarHormas(@RequestBody Horma horma) {
		Hormas hormas = new Hormas();
		hormas = hormaService.registrarHormas(horma);
		return hormas;
	};
	@DeleteMapping(value="/horma/id/{id}")
	public Resultado eliminarHormasxId(@PathVariable (name="id") String id) {
		Resultado resultado = new Resultado();
		resultado = hormaService.eliminarHormasxId(id);
		return resultado;
	};
}
