package pe.com.proyecto.gestionmodeloservice.app.service;

import pe.com.proyecto.gestionmodeloservice.api.models.Horma;
import pe.com.proyecto.gestionmodeloservice.api.models.Hormas;
import pe.com.proyecto.gestionmodeloservice.api.models.Resultado;

public interface HormaService {
	
	public Hormas obtenerHormas();
	
	public Hormas obtenerHormasxCodigo(String codigo);
	
	public Hormas registrarHormas(Horma horma);
	
	public Resultado eliminarHormasxId(String id);

}
