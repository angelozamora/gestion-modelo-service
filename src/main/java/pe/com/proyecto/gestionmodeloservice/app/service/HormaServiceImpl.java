package pe.com.proyecto.gestionmodeloservice.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.proyecto.gestionmodeloservice.api.models.Categoria;
import pe.com.proyecto.gestionmodeloservice.api.models.Horma;
import pe.com.proyecto.gestionmodeloservice.api.models.Hormas;
import pe.com.proyecto.gestionmodeloservice.api.models.Resultado;
import pe.com.proyecto.gestionmodeloservice.app.jpa.CategoriaJpa;
import pe.com.proyecto.gestionmodeloservice.app.jpa.HormaJpa;

import pe.com.proyecto.gestionmodeloservice.app.repository.HormaRepository;


@Service
public class HormaServiceImpl implements HormaService{
	@Autowired
	HormaRepository hormaRepository;
	
	@Override
	public Hormas obtenerHormas() {
		// TODO Auto-generated method stub
		Hormas hormas = new Hormas();
		Resultado resultado = new Resultado();
		List<Horma> hormasList = new ArrayList<Horma>();
		try {
			for(HormaJpa hormaJpa : hormaRepository.findAll()) {
				Horma horma = new Horma();
				horma.setId(hormaJpa.getId()+"");
				horma.setCodigo(hormaJpa.getCodigo()+"");
				horma.setFoto(hormaJpa.getFoto());
				Categoria categoria = new Categoria();
				categoria.setId(horma.getCategoria().getId());
				horma.setCategoria(categoria);
				hormasList.add(horma);
			}
			if(hormasList.isEmpty()) {
				hormas.setHormas(null);;
				resultado.setCodigoRespuesta("400");
				resultado.setMensajeRespuesta("Datos no encontrados");
			}
			else {
				hormas.setHormas(hormasList);
				resultado.setCodigoRespuesta("200");
				resultado.setMensajeRespuesta("Operacion correcta");
			}
		}
		catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
			resultado.setCodigoRespuesta("400");
			resultado.setMensajeRespuesta("Datos no encontrados");
		}
		hormas.setResultado(resultado);
		return hormas;
	}

	@Override
	public Hormas obtenerHormasxCodigo(String codigo) {
		// TODO Auto-generated method stub
		Hormas hormas = new Hormas();
		Resultado resultado = new Resultado();
		List<Horma> hormasList = new ArrayList<Horma>();
		int Codigo = Integer.parseInt(codigo);
		try {
			HormaJpa hormaJpa = hormaRepository.findByCodigo(Codigo);
			if(hormaJpa != null) {
				Horma horma = new Horma();
				horma.setId(hormaJpa.getId()+"");
				horma.setCodigo(hormaJpa.getCodigo()+"");
				horma.setFoto(hormaJpa.getFoto());
				Categoria categoria = new Categoria();
				categoria.setId(horma.getCategoria().getId());
				horma.setCategoria(categoria);
				hormasList.add(horma);
				hormas.setHormas(hormasList);
				resultado.setCodigoRespuesta("200");
				resultado.setMensajeRespuesta("Operacion correcta");
			}
			else {
				resultado.setCodigoRespuesta("400");
				resultado.setMensajeRespuesta("Datos no encontrados");
			}
		}
		catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
			resultado.setCodigoRespuesta("400");
			resultado.setMensajeRespuesta("Datos no encontrados");
		}
		hormas.setResultado(resultado);
		return hormas;
	}

	@Override
	public Hormas registrarHormas(Horma horma) {
		// TODO Auto-generated method stub
		Hormas hormas = new Hormas();
		Resultado resultado = new Resultado();
		List<Horma> hormasList = new ArrayList<Horma>();
		try {
			HormaJpa hormaJpa = new HormaJpa();
			hormaJpa.setCodigo(Integer.parseInt(horma.getCodigo()));
			hormaJpa.setFoto(horma.getFoto());
			CategoriaJpa categoriaJpa = new CategoriaJpa();
			categoriaJpa.setId(Long.parseLong(horma.getCategoria().getId()));
			hormaRepository.save(hormaJpa);
			horma.setId(hormaJpa.getId()+"");
			hormasList.add(horma);
			hormas.setHormas(hormasList);
			resultado.setCodigoRespuesta("200");
			resultado.setMensajeRespuesta("Operacion correcta");
		}
		catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
			resultado.setCodigoRespuesta("400");
			resultado.setMensajeRespuesta("Datos no encontrados");
		}
		hormas.setResultado(resultado);
		return hormas;
	}

	@Override
	public Resultado eliminarHormasxId(String id) {
		// TODO Auto-generated method stub
		Resultado resultado = new Resultado();
		Long Id = Long.parseLong(id);
		try {
			hormaRepository.deleteById(Id);
			resultado.setCodigoRespuesta("200");
			resultado.setMensajeRespuesta("Operacion correcta");
		}
		catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
			resultado.setCodigoRespuesta("400");
			resultado.setMensajeRespuesta("Datos no encontrados");
		}
		return resultado;
	}
	
}
