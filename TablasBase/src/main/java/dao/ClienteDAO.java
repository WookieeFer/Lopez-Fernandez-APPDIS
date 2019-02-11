package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Cliente;

@Stateless
public class ClienteDAO {

	@Inject
	private EntityManager em;

	public void insertar(Cliente c) {
		em.persist(c);
	}

	public void actualizar(Cliente c) {
		em.merge(c);
	}

	public void eliminar(int codigo) {
		em.remove(leer(codigo));
	}

	public Cliente leer(int codigo) {
		Cliente aux = em.find(Cliente.class, codigo);
		return aux;
	}

	public Cliente leerCedula(String cedula) {
		String jpql = "SELECT c FROM Cliente c WHERE c.cedula LIKE ?1";
		Query query = em.createQuery(jpql, Cliente.class);
		query.setParameter(1, cedula);
		Cliente aux = (Cliente) query.getSingleResult();
		return aux;
	}

	public Cliente login(String usuario, String contrasenia) {
		String jpql = "SELECT c FROM Cliente c WHERE c.correo LIKE ?1 AND c.cedula LIKE ?2";
		Query query = em.createQuery(jpql, Cliente.class);
		query.setParameter(1, usuario);
		query.setParameter(2, contrasenia);
		Cliente aux = (Cliente) query.getSingleResult();
		return aux;
	}

	public List<Cliente> listarClientes() {
		String jpql = "Select c From Cliente c";
		Query query = em.createQuery(jpql, Cliente.class);
		List<Cliente> clientes = query.getResultList();
		return clientes;

	}

}
