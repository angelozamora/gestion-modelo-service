package pe.com.proyecto.gestionmodeloservice.app.service;

import pe.com.proyecto.gestionmodeloservice.api.models.Modelo;
import pe.com.proyecto.gestionmodeloservice.api.models.Modelos;
import pe.com.proyecto.gestionmodeloservice.api.models.Resultado;

public interface ModeloService {

	public Modelos obtenerModelos();
	
	public Modelos obtenerModelosxCodigo(String codigo);
	
	public Modelos registrarModelos(Modelo modelo);
	
	public Resultado eliminarModelosxId(String id);
}
