package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Sucursal;

@Stateless
public class SucursalDao {

	@Inject
	private EntityManager em;

	public void insertar(Sucursal s) {
		em.persist(s);
	}

	public void actualizar(Sucursal s) {
		em.merge(s);
	}

	public void eliminar(int codigo) {
		em.remove(leer(codigo));
	}

	public Sucursal leer(int codigo) {
		Sucursal aux = em.find(Sucursal.class, codigo);
		return aux;
	}

	public List<Sucursal> listarSucursales() {
		String jpql = "Select c From Sucursal c";
		Query query = em.createQuery(jpql, Sucursal.class);
		List<Sucursal> listaSucursales = query.getResultList();
		for (Sucursal sucursal : listaSucursales) {
			System.out.println(sucursal.getDireccion() + sucursal.getCodigoCiudad().getCodigoCiudad());
		}
		return query.getResultList();

	}

}
