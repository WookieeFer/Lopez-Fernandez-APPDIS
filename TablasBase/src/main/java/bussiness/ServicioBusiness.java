package bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ServicioDao;
import model.Servicio;
import model.ServicioCliente;

@Stateless
public class ServicioBusiness {

	@Inject
	private ServicioDao dao;

	/**
	 * Este metodo registra un Servicio
	 * 
	 * @return
	 */
	public void registrar(Servicio s) {
		System.out.println("llegando aqui");
		Servicio aux = dao.leer(s.getCodigoServicio());
		if (aux != null) {
			System.out.println("Servicio ya registrada");
		} else {
			System.out.println("Nuevo cooigoddd " + s.getCodigoServicio());
			dao.insertar(s);
		}
	}

	/**
	 * Este metodo lee un Servicio
	 * 
	 * @return
	 */
	public Servicio leer(int codigo) {
		Servicio aux = dao.leer(codigo);
		if (aux == null)
			System.out.println("Serivico no registrado");

		return aux;

	}

	/**
	 * Este metodo actualiza un Servicio
	 * 
	 * @return
	 */
	public void actualizar(Servicio s) {
		Servicio aux = dao.leer(s.getCodigoServicio());
		if (aux == null)
			System.out.println("Servicio no registrada");
		else
			dao.actualizar(s);
	}

	/**
	 * Este metodo elimina un Servicio
	 * 
	 * @return
	 */
	public void eliminar(int codigo) {
		Servicio aux = dao.leer(codigo);
		if (aux == null)
			System.out.println("Servicio no registrada");
		else
			dao.eliminar(codigo);
	}

	/**
	 * Este metodo retorna una lista de Servicios
	 * 
	 * @return
	 */
	public List<Servicio> listarServicios() {
		return dao.listarServicios();
	}

	public List<ServicioCliente> listarServiciosCliente() {
		return dao.listarServiciosCliente();
	}

}