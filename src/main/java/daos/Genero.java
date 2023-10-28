package daos;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "generos", schema = "gbp_operacional")
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_genero", nullable = false)
	private long id_genero;

	@Column(name = "nombre_genero", nullable = false)
	private String nombre_genero;

	@Column(name = "descripcion_genero")
	private String descripcion_genero;

	@OneToMany(mappedBy = "genero")
	private List<Libro> listaLibrosGenero;

	public Genero() {

	}

	public Genero(String nombre_genero, String descripcion_genero) {
		super();
		this.nombre_genero = nombre_genero;
		this.descripcion_genero = descripcion_genero;
	}

}
