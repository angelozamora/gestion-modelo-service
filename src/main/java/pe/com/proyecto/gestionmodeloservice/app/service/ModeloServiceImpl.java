package pe.com.proyecto.gestionmodeloservice.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.proyecto.gestionmodeloservice.api.models.Categoria;
import pe.com.proyecto.gestionmodeloservice.api.models.Horma;
import pe.com.proyecto.gestionmodeloservice.api.models.Modelo;
import pe.com.proyecto.gestionmodeloservice.api.models.Modelos;
import pe.com.proyecto.gestionmodeloservice.api.models.Resultado;
import pe.com.proyecto.gestionmodeloservice.app.jpa.CategoriaJpa;
import pe.com.proyecto.gestionmodeloservice.app.jpa.HormaJpa;
import pe.com.proyecto.gestionmodeloservice.app.jpa.ModeloJpa;
import pe.com.proyecto.gestionmodeloservice.app.repository.ModeloRepository;

@Service
public class ModeloServiceImpl implements ModeloService{

	@Autowired
	ModeloRepository modeloRepository;
	
	@Override
	public Modelos obtenerModelos() {
		// TODO Auto-generated method stub
		Modelos modelos = new Modelos();
		Resultado resultado=new Resultado();
		List<Modelo> modelosList = new ArrayList<Modelo>();
		try {
			for(ModeloJpa modeloJpa : modeloRepository.findAll()) {
				Modelo modelo = new Modelo();
				modelo.setId(modeloJpa.getId()+"");
				modelo.setCodigo(modeloJpa.getCodigo()+"");
				modelo.setFoto(modeloJpa.getFoto());
				Categoria categoria = new Categoria();
				categoria.setNombre(modeloJpa.getCategoria().getNombre());
				modelo.setCategoria(categoria);
				Horma horma = new Horma();
				horma.setCodigo(modeloJpa.getHorma().getCodigo()+"");
				modelo.setHorma(horma);
				modelosList.add(modelo);
			}
			if(modelosList.isEmpty()) {
				modelos.setModelos(null);
				resultado.setCodigoRespuesta("400");
				resultado.setMensajeRespuesta("Datos no encontrados");
			}
			else {
				modelos.setModelos(modelosList);
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
		modelos.setResultado(resultado);
		return modelos;
	}

	@Override
	public Modelos obtenerModelosxCodigo(String codigo) {
		// TODO Auto-generated method stub
		Modelos modelos = new Modelos();
		Resultado resultado=new Resultado();
		List<Modelo> modelosList = new ArrayList<Modelo>();
		int Codigo = Integer.parseInt(codigo);
		try {
			ModeloJpa modeloJpa = modeloRepository.findByCodigo(Codigo);
			if(modeloJpa != null) {
				Modelo modelo = new Modelo();
				modelo.setId(modeloJpa.getId()+"");
				modelo.setCodigo(modeloJpa.getCodigo()+"");
				modelo.setFoto(modeloJpa.getFoto());
				Categoria categoria = new Categoria();
				categoria.setNombre(modeloJpa.getCategoria().getNombre());
				Horma horma = new Horma();
				horma.setCodigo(modeloJpa.getHorma().getCodigo()+"");
				modelo.setCategoria(categoria);
				modelosList.add(modelo);
				modelos.setModelos(modelosList);
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
		modelos.setResultado(resultado);
		return modelos;
	}

	@Override
	public Modelos registrarModelos(Modelo modelo) {
		// TODO Auto-generated method stub
		Modelos modelos = new Modelos();
		Resultado resultado=new Resultado();
		List<Modelo> modelosList = new ArrayList<Modelo>();
		try {
			ModeloJpa modeloJpa = new ModeloJpa();
			modeloJpa.setCodigo(Integer.parseInt(modelo.getCodigo()));
			modeloJpa.setFoto(modelo.getFoto());
			CategoriaJpa categoriaJpa = new CategoriaJpa();
			categoriaJpa.setId(Long.parseLong(modelo.getCategoria().getId()));
			modeloJpa.setCategoria(categoriaJpa);
			HormaJpa hormaJpa = new HormaJpa();
			hormaJpa.setId(Long.parseLong(modelo.getHorma().getId()));
			modeloJpa.setHorma(hormaJpa);
			modeloRepository.save(modeloJpa);
			modelo.setId(modeloJpa.getId()+"");
			modelosList.add(modelo);
			modelos.setModelos(modelosList);
			resultado.setCodigoRespuesta("200");
			resultado.setMensajeRespuesta("Operacion correcta");
		}
		catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
			resultado.setCodigoRespuesta("400");
			resultado.setMensajeRespuesta("Datos no encontrados");
		}
		modelos.setResultado(resultado);
		return modelos;
	}

	@Override
	public Resultado eliminarModelosxId(String id) {
		// TODO Auto-generated method stub
		Resultado resultado = new Resultado();
		Long Id = Long.parseLong(id);
		try {
			modeloRepository.deleteById(Id);
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
