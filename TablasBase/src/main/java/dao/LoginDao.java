package dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Empleado;

public class LoginDao {

	@Inject
	private EntityManager em;

	public Empleado BuscarLog(String correo, String cedula) {
		try {

			Query query = em.createQuery("SELECT e FROM Empleado e WHERE e.correo = :correo AND e.cedula = :cedula",
					Empleado.class);
			query.setParameter("correo", correo);
			query.setParameter("cedula", cedula);
			Empleado e = (Empleado) query.getSingleResult();
			System.out.println("Empleado encontrado " + e.getNombre());
			if (e != null)
				return e;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
