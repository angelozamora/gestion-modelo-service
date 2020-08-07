package pe.com.proyecto.gestionmodeloservice.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.proyecto.gestionmodeloservice.api.models.Categoria;
import pe.com.proyecto.gestionmodeloservice.api.models.Categorias;
import pe.com.proyecto.gestionmodeloservice.api.models.Resultado;
import pe.com.proyecto.gestionmodeloservice.app.jpa.CategoriaJpa;

import pe.com.proyecto.gestionmodeloservice.app.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public Categorias obtenerCategorias() {
		// TODO Auto-generated method stub
		Categorias categorias = new Categorias();
		Resultado resultado = new Resultado();
		List<Categoria> categoriasList = new ArrayList<Categoria>();
		try {
			for(CategoriaJpa categoriaJpa : categoriaRepository.findAll()) {
				Categoria categoria = new Categoria();
				categoria.setId(categoriaJpa.getId()+"");
				categoria.setNombre(categoriaJpa.getNombre());
				categoriasList.add(categoria);
			}
			if(categoriasList.isEmpty()) {
				categorias.setCategorias(null);
				resultado.setCodigoRespuesta("400");
				resultado.setMensajeRespuesta("Datos no encontrados");
			}
			else {
				categorias.setCategorias(categoriasList);
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
		categorias.setResultado(resultado);
		return categorias;
	}

	@Override
	public Categorias registrarCategorias(Categoria categoria) {
		// TODO Auto-generated method stub
		Categorias categorias = new Categorias();
		Resultado resultado = new Resultado();
		List<Categoria> categoriasList = new ArrayList<Categoria>();
		try {
			CategoriaJpa categoriaJpa = new CategoriaJpa();
			categoriaJpa.setNombre(categoria.getNombre());
			categoriaRepository.save(categoriaJpa);
			categoria.setId(categoriaJpa.getId()+"");
			categoriasList.add(categoria);
			categorias.setCategorias(categoriasList);
			resultado.setCodigoRespuesta("200");
			resultado.setMensajeRespuesta("Operacion correcta");
		}
		catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
			resultado.setCodigoRespuesta("400");
			resultado.setMensajeRespuesta("Datos no encontrados");
		}
		categorias.setResultado(resultado);
		return categorias;
	}

	@Override
	public Resultado eliminarCategoriasxId(String id) {
		// TODO Auto-generated method stub
		Resultado resultado = new Resultado();
		Long Id = Long.parseLong(id);
		try {
			categoriaRepository.deleteById(Id);
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
