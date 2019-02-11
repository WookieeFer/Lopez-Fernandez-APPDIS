package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Empleado;

@Stateless
public class EmpleadoDao {

	@Inject
	private EntityManager em;

	public void insertar(Empleado e) {
		em.persist(e);
	}

	public void actualizar(Empleado e) {
		em.merge(e);
	}

	public void eliminar(int codigo) {
		em.remove(leer(codigo));
	}

	public Empleado leer(int codigo) {
		Empleado aux = em.find(Empleado.class, codigo);
		return aux;
	}

	public List<Empleado> listarEmpleados() {
		String jpql = "Select c From Empleado c";
		Query query = em.createQuery(jpql, Empleado.class);
		List<Empleado> listaEmpleados = query.getResultList();
		for (Empleado empleado : listaEmpleados) {
			System.out.println(empleado.getNombre() + empleado.getCodigoSucursal().getCodigoSucursal());
		}
		return query.getResultList();
	}

}
