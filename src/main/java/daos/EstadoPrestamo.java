package daos;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "estados_prestamos", schema = "gbp_operacional")
public class EstadoPrestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado_prestamo", nullable = false)
	private long idEstadoPrestamo;

	@Column(name = "codigo_estado_prestamo", nullable = false)
	private String codigoEstadoPrestamo;

	@Column(name = "descripcion_estado_prestamo")
	private String descripcionEstadoPrestamo;

	@OneToMany(mappedBy = "estadoPrestamo")
	private List<Prestamo> listaPrestamos;

	public EstadoPrestamo() {

	}

	public EstadoPrestamo(String codigoEstadoPrestamo, String descripcionEstadoPrestamo) {
		super();
		this.codigoEstadoPrestamo = codigoEstadoPrestamo;
		this.descripcionEstadoPrestamo = descripcionEstadoPrestamo;
	}

}
