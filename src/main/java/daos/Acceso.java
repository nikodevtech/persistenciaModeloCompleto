package daos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "accesos", schema = "gbp_operacional")
public class Acceso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_acceso", nullable = false)
	private long idAcceso;

	@Column(name = "codigo_acceso", nullable = false)
	private String codigoAcceso;

	@Column(name = "descripcion_acceso")
	private String descripcionAcceso;

	@OneToMany(mappedBy = "acceso")
	private List<Usuario> listaUsuariosConAccesoo;

	public Acceso() {
		super();
	}

	public Acceso(String codigoAcceso, String descripcionAcceso) {
		super();
		this.codigoAcceso = codigoAcceso;
		this.descripcionAcceso = descripcionAcceso;
	}

}
