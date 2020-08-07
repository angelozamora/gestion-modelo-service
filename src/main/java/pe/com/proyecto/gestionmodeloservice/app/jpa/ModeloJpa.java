package pe.com.proyecto.gestionmodeloservice.app.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="modelo")
public class ModeloJpa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="CODIGO")
	private int codigo;
	
	@OneToOne
	@JoinColumn(name="CATEGORIA_ID")
	private CategoriaJpa categoria;
	
	@OneToOne
	@JoinColumn(name="HORMA_ID")
	private HormaJpa horma;
	
	@Column(name="FOTO")
	private String foto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public CategoriaJpa getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaJpa categoria) {
		this.categoria = categoria;
	}

	public HormaJpa getHorma() {
		return horma;
	}

	public void setHorma(HormaJpa horma) {
		this.horma = horma;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
}
