package daos;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "colecciones", schema = "gbp_operacional")
public class Coleccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_coleccion", nullable = false)
	private long idColeccion;

	@Column(name = "nombre_coleccion", nullable = false)
	private String nombreColeccion;

	@OneToMany(mappedBy = "coleccion")
	private List<Libro> listaLibrosColeccion;

	public Coleccion() {

	}

	public Coleccion(String nombreColeccion) {
		super();
		this.nombreColeccion = nombreColeccion;
	}

}
