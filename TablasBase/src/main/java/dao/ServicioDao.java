package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Servicio;
import model.ServicioCliente;

@Stateless
public class ServicioDao {

	@Inject
	private EntityManager em;

	public void insertar(Servicio s) {
		System.out.println("nunevo codigo " + s.getCodigoServicio());
		em.persist(s);
	}

	public void actualizar(Servicio s) {
		em.merge(s);
	}

	public void eliminar(int codigo) {
		em.remove(leer(codigo));
	}

	public Servicio leer(int codigo) {
		System.out.println("paso aqui");
		System.out.println("Este es el codigo...." + codigo);
		Servicio aux = em.find(Servicio.class, codigo);
//		System.out.println(aux.getCodigoServicio() + ", " + aux.getNombre() + ", " + ", "
//				+ aux.getCodigoCliente().getCodigoCliente() + ", " + aux.getCodigoEmpleado().getCodigoEmpleado() + ", "
//				+ aux.getCodigoEmpleado().getCodigoSucursal().getCodigoSucursal() + ", "
//				+ aux.getCodigoEmpleado().getCodigoSucursal().getCodigoCiudad().getCodigoCiudad());
		return aux;
	}

	public List<Servicio> listarServicios() {
		String jpql = "Select c From Servicio c";
		Query query = em.createQuery(jpql, Servicio.class);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>111");
		List<Servicio> listaServicios = query.getResultList();
		for (Servicio servicio : listaServicios) {
			System.out.println(servicio.getCodigoServicio() + ", " + servicio.getNombre() + ", "
					+ servicio.getCodigoCliente().getCodigoCliente() + ", "
					+ servicio.getCodigoEmpleado().getCodigoEmpleado() + ", "
					+ servicio.getCodigoEmpleado().getCodigoSucursal().getCodigoSucursal() + ", "
					+ servicio.getCodigoEmpleado().getCodigoSucursal().getCodigoCiudad().getCodigoCiudad());
		}
		return listaServicios;
	}

	public List<ServicioCliente> listarServiciosCliente() {
		String jpql = "SELECT s FROM Servicio s";
		Query query = em.createQuery(jpql, Servicio.class);
		List<Servicio> listaServicios = query.getResultList();
		List<ServicioCliente> servicios = new ArrayList<>();
		for (Servicio servicio : listaServicios) {
			ServicioCliente sc = new ServicioCliente();
			sc.setCedula_cli(servicio.getCodigoCliente().getCedula());
			sc.setNombre_cli(servicio.getCodigoCliente().getNombre());
			sc.setApe_cli(servicio.getCodigoCliente().getApellido());
			sc.setEmail_cli(servicio.getCodigoCliente().getCorreo());
			sc.setNombre_emp(servicio.getCodigoEmpleado().getNombre());
			sc.setEmail_emp(servicio.getCodigoEmpleado().getCorreo());
			sc.setNombre_servicio(servicio.getNombre());
			sc.setDesc_servicio(servicio.getDescripcion());
			servicios.add(sc);
		}
		return servicios;
	}

}
