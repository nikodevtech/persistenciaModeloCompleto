package daos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "libros", schema = "gbp_operacional")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_libro", nullable = false)
	private long idLibro;

	@Column(name = "isbn_libro", nullable = false)
	private String isbnLibro;

	@Column(name = "titulo_libro", nullable = false)
	private String tituloLibro;

	@Column(name = "edicion_libro")
	private String edicionLibro;

	@OneToMany(mappedBy = "libro")
	private List<Prestamo> listaPrestamosLibro;

	@ManyToOne
	@JoinColumn(name = "id_editorial")
	Editorial editorial;

	@ManyToOne
	@JoinColumn(name = "id_genero")
	Genero genero;

	@ManyToOne
	@JoinColumn(name = "id_coleccion")
	Coleccion coleccion;

	
	@JoinTable(name = "Rel_Autores_Libros", // Indica el nombre de la tabla intermedia
			joinColumns = @JoinColumn(name = "id_autor"), // y nombre de los campos que tendran los FK que relacionan
			inverseJoinColumns = @JoinColumn(name = "id_libro"), 
			schema = "gbp_operacional")
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Autor> listaAutoresLibro;

	public Libro() {

	}

	public Libro(String isbnLibro, String tituloLibro, String edicionLibro, Editorial editorial, Genero genero,
			Coleccion coleccion) {
		super();
		this.isbnLibro = isbnLibro;
		this.tituloLibro = tituloLibro;
		this.edicionLibro = edicionLibro;
		this.editorial = editorial;
		this.genero = genero;
		this.coleccion = coleccion;
		this.listaAutoresLibro = new ArrayList<>();

	}

	public List<Autor> getListaAutoresLibro() {
		return listaAutoresLibro;
	}

	

}
