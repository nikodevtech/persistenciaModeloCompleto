package daos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "autores", schema = "gbp_operacional")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_autor", nullable = false)
	private long id_autor;

	@Column(name = "nombre_autor", nullable = false)
	private String nombreAutor;

	@Column(name = "apellidos_autor")
	private String apellidosAutor;

	@ManyToMany(mappedBy = "listaAutoresLibro")
	private List<Libro> listaLibrosAutor;

	public Autor() {

	}

	public Autor(String nombreAutor, String apellidosAutor) {
		super();
		this.nombreAutor = nombreAutor;
		this.apellidosAutor = apellidosAutor;
		this.listaLibrosAutor = new ArrayList<>();
	}

	public List<Libro> getListaLibrosAutor() {
		return listaLibrosAutor;
	}
	
	
	

}
