package daos;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios", schema = "gbp_operacional")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", nullable = false)
	private long idUsuario;

	@Column(name = "dni_usuario", nullable = false)
	private String dniUsuario;

	@Column(name = "nombre_usuario")
	private String nombreUsuario;

	@Column(name = "apellidos_usuario")
	private String apellidosUsuario;

	@Column(name = "tlf_usuario")
	private String tlfUsuario;

	@Column(name = "email_usuario")
	private String emailUsuario;

	@Column(name = "clave_usuario")
	private String claveUsuario;

	@Column(name = "estaBloqueado_usuario")
	private boolean estaBloqueadoUsuario;

	@Column(name = "fch_fin_bloqueo")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fchFinBloqueo;

	@Column(name = "fch_alta_usuario")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fchAltaUsuario;

	@Column(name = "fch_baja_usuario")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fchBajaUsuario;

	@ManyToOne
	@JoinColumn(name = "id_acceso")
	Acceso acceso;

	@OneToMany(mappedBy = "usuario")
	private List<Prestamo> listaPrestamosUsuario;

	public Usuario() {
		super();
	}

	public Usuario(String dniUsuario, String nombreUsuario, String apellidosUsuario, String tlfUsuario,
			String emailUsuario, String claveUsuario, boolean estaBloqueadoUsuario, Calendar fchFinBloqueo,
			Calendar fchAltaUsuario, Calendar fchBajaUsuario, Acceso acceso) {
		super();
		this.dniUsuario = dniUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidosUsuario = apellidosUsuario;
		this.tlfUsuario = tlfUsuario;
		this.emailUsuario = emailUsuario;
		this.claveUsuario = claveUsuario;
		this.estaBloqueadoUsuario = estaBloqueadoUsuario;
		this.fchFinBloqueo = fchFinBloqueo;
		this.fchAltaUsuario = fchAltaUsuario;
		this.fchBajaUsuario = fchBajaUsuario;
		this.acceso = acceso;
	}

}
