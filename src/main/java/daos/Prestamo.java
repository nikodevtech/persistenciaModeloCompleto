package daos;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "prestamos", schema = "gbp_operacional")
public class Prestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prestamo", nullable = false)
	private long idPrestamo;

	@Column(name = "fch_inicio_prestamo")
	private Calendar fechaInicioPrestamo;
	@Column(name = "fch_fin_prestamo")
	private Calendar fechaFinPrestamo;
	@Column(name = "fch_entrega_prestamo")
	private Calendar fechaEntregaPrestamo;

	@ManyToOne
	@JoinColumn(name = "id_libro")
	Libro libro;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_estado_prestamo")
	EstadoPrestamo estadoPrestamo;

	public Prestamo(Calendar fechaInicioPrestamo, Calendar fechaFinPrestamo, Calendar fechaEntregaPrestamo,
			Usuario usuario, EstadoPrestamo estadoPrestamo, Libro libro) {
		super();
		this.fechaInicioPrestamo = fechaInicioPrestamo;
		this.fechaFinPrestamo = fechaFinPrestamo;
		this.fechaEntregaPrestamo = fechaEntregaPrestamo;
		this.usuario = usuario;
		this.estadoPrestamo = estadoPrestamo;
		this.libro = libro;
	}

	public Prestamo() {

	}

}
