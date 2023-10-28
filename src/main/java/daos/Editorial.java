package daos;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "editoriales", schema = "gbp_operacional")
public class Editorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_editorial", nullable = false)
	private long idEditorial;

	@Column(name = "nombre_editorial", nullable = false)
	private String nombreEditorial;

	@OneToMany(mappedBy = "editorial")
	private List<Libro> listaLibrosEditorial;

	public Editorial() {

	}

	public Editorial(String nombreEditorial) {
		super();
		this.nombreEditorial = nombreEditorial;
	}

}
