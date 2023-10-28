package controladores;

import java.util.Calendar;

import daos.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Inicio {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Creación de objetos para la persistencia
		Acceso accesoCliente = new Acceso("Cliente", "Acceso cliente estandar de la biblioteca");
		Acceso accesoEmpleado = new Acceso("Empleado", "Empleados de la biblioteca");

		Editorial primeraEditorial = new Editorial("Grupo comercial Anaya");
		Genero genero1 = new Genero("Terror y misterio",
				"Género literario que se define por la sensación de miedo que provoca en el lector");
		Coleccion coleccionTerror = new Coleccion("Clasicos del terror mas vendidos");

		Autor autor1 = new Autor("Bram", "Stoker");
		Libro libro1 = new Libro("SW-0-7645-2641-3", "Drácula", "3522", primeraEditorial, genero1, coleccionTerror);
		libro1.getListaAutoresLibro().add(autor1);
		autor1.getListaLibrosAutor().add(libro1);
			
		Usuario usuarioCliente = new Usuario("11223344W", "Leo", "Messi", "23441231", "nomail@no.com", "1234", false,
				Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), accesoCliente);
		Usuario usuarioEmpleado = new Usuario("22334455K", "Cristiano", "Ronaldo", "612312122", "nomail@no.com", "1234",
				false, Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), accesoEmpleado);

		EstadoPrestamo estadoOk = new EstadoPrestamo("Devuelto", "Prestamo devuelto correctamente en tiempo y fecha");
		EstadoPrestamo estadoNoOk = new EstadoPrestamo("No devuelto",
				"Prestamo no devuelto cumpliendo la fecha límite");

		Prestamo prestamo1 = new Prestamo(Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(),
				usuarioCliente, estadoOk, libro1);

		// Registro de datos en el contexto o modelo virtual
		em.persist(primeraEditorial); // Introducimos la primera editorial, genero, coleccion y libro
		em.persist(genero1);
		em.persist(coleccionTerror);
		em.persist(autor1);
		em.persist(libro1);

		em.persist(accesoCliente); // Los dos tipo de acceso para los usuarios
		em.persist(accesoEmpleado);

		em.persist(estadoOk); // Los dos estados de los prestamos
		em.persist(estadoNoOk);

		em.persist(usuarioCliente); // Los dos usuarios con cada tipo de acceso
		em.persist(usuarioEmpleado);

		em.persist(prestamo1); // Empieza el funcionamiento de la biblio con el primer prestamo :D

		em.getTransaction().commit(); // Aquí es cuando se lleva a cabo la Persistencia real a la BBDD
		em.close();

	}

}
