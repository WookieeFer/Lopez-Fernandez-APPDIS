package bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ClienteDAO;
import model.Cliente;

@Stateless
public class ClienteBusiness {

	@Inject
	private ClienteDAO dao;

	/**
	 * Este metodo registra un cliente
	 * 
	 * @return
	 */
	public void registrar(Cliente c) {
		Cliente aux = dao.leer(c.getCodigoCliente());
		if (aux != null)
			System.out.println("Persona ya registrado");
		else
			dao.insertar(c);
	}

	/**
	 * Este metodo lee un cliente
	 * 
	 * @return
	 */
	public Cliente leer(int codigo) throws Exception {
		Cliente aux = dao.leer(codigo);
		if (aux == null)
			throw new Exception("Persona no registrada");
		else
			return aux;
	}

	/**
	 * Este metodo actualiza un cliente
	 * 
	 * @return
	 */
	public void actualizar(Cliente c) throws Exception {
		Cliente aux = dao.leer(c.getCodigoCliente());
		if (aux == null)
			throw new Exception("Persona no registrada");
		else
			dao.actualizar(c);
	}

	/**
	 * Este metodo elimina un cliente
	 * 
	 * @return
	 */
	public void eliminar(int codigo) throws Exception {
		Cliente aux = dao.leer(codigo);
		if (aux == null)
			throw new Exception("Persona no registrada");
		else
			dao.eliminar(codigo);
	}

	public List<Cliente> listarClientes() {
		return dao.listarClientes();
	}

	/**
	 * Este metodo lee un cliente según cedula
	 * 
	 * @return
	 */
	public Cliente leerCedula(String cedula) throws Exception {
		Cliente aux = dao.leerCedula(cedula);
		if (aux == null)
			throw new Exception("Persona no registrada");
		else
			return aux;
	}

	/**
	 * Este metodo procesa un login de un cliente
	 * 
	 * @return
	 */
	public Cliente login(String usuario, String contrasenia) throws Exception {
		Cliente aux = dao.login(usuario, contrasenia);
		if (aux == null)
			throw new Exception("Persona no registrada");
		else
			return aux;
	}
}