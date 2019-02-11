package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Ciudad;
import model.MostrarSucursales;
import model.Sucursal;

/**
 * En esta clase se establecen los sql para conectar a una base de datos
 * 
 * @author Byron Fernandez y Jonnathan Lopez
 *
 */

@Stateless
public class CiudadDao {

	@Inject
	private EntityManager em;

	/**
	 * Este metodo inserta una ciudad recibiendo un parametro de Ciudad
	 * 
	 * @param c
	 */

	public void insertar(Ciudad c) {
		em.persist(c);
	}

	/**
	 * Este metodo actualiza una ciudad recibiendo un parametro de Ciudad
	 * 
	 * @param c
	 */

	public void actualizar(Ciudad c) {
		em.merge(c);
	}

	/**
	 * Este metodo elimina una ciudad recibiendo un parametro codigo de Ciudad
	 * 
	 * @param codigo
	 */
	public void eliminar(int codigo) {
		em.remove(leer(codigo));
	}

	/**
	 * Este metodo lee una ciudad recibiendo un parametro codigo de Ciudad
	 * 
	 * @param codigo
	 * @return
	 */
	public Ciudad leer(int codigo) {
		Ciudad aux = em.find(Ciudad.class, codigo);
		return aux;
	}

	/**
	 * Este metodo retorna una lista de Ciudades
	 * 
	 * @return
	 */
	public List<Ciudad> listarCiudades() {
		String jpql = "Select c From Ciudad c";
		Query query = em.createQuery(jpql, Ciudad.class);
		return query.getResultList();
	}

	/*
	 * public List<Ciudad> listarCiudadSucursales() { String jpql =
	 * "SELECT c FROM Ciudad c WHERE c. LIKE ?1"; Query query = em.createQuery(jpql,
	 * Ciudad.class); return query.getResultList(); }
	 */

	/**
	 * Este metodo retorna la muestra de sucursales mediante un parametro nombre de
	 * ciudad
	 * 
	 * @param nombre
	 * @return
	 */
	public List<MostrarSucursales> listarSucursal(String nombre) {
		String jpql = "SELECT c FROM Ciudad c WHERE c.nombre LIKE ?1";
		Query query = em.createQuery(jpql, Ciudad.class);
		query.setParameter(1, nombre);
		Ciudad ciudad = (Ciudad) query.getSingleResult();
		List<Sucursal> lista = ciudad.getSucursales();
		List<MostrarSucursales> sucursales = new ArrayList<>();
		for (Sucursal sucursal : lista) {
			MostrarSucursales ms = new MostrarSucursales();
			ms.setCodigoSucursal(sucursal.getCodigoSucursal());
			ms.setDireccion(sucursal.getDireccion());
			sucursales.add(ms);
		}
		return sucursales;

	}

}
