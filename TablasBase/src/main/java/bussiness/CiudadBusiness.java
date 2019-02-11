package bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.CiudadDao;
import model.Ciudad;
import model.MostrarSucursales;

@Stateless
public class CiudadBusiness {

	@Inject
	private CiudadDao dao;

	/**
	 * Este metodo registra una ciudad
	 * 
	 * @return
	 */
	public void registrar(Ciudad c) throws Exception {
		Ciudad aux = dao.leer(c.getCodigoCiudad());
		if (aux != null)
			throw new Exception("Ciudad ya registrada");
		else
			dao.insertar(c);
	}

	/**
	 * Este metodo lee una ciudad
	 * 
	 * @return
	 */
	public Ciudad leer(int codigo) throws Exception {
		Ciudad aux = dao.leer(codigo);
		if (aux == null)
			throw new Exception("Ciudad no registrada");
		else
			return aux;
	}

	/**
	 * Este metodo actualiza una ciudad
	 * 
	 * @return
	 */
	public void actualizar(Ciudad ci) throws Exception {
		Ciudad aux = dao.leer(ci.getCodigoCiudad());
		if (aux == null)
			throw new Exception("Ciudad no registrada");
		else
			dao.actualizar(ci);
	}

	/**
	 * Este metodo elimina una ciudad
	 * 
	 * @return
	 */
	public void eliminar(int codigo) throws Exception {
		Ciudad aux = dao.leer(codigo);
		if (aux == null)
			throw new Exception("Ciudad no registrada");
		else
			dao.eliminar(codigo);
	}

	/**
	 * Este metodo lista una ciudad
	 * 
	 * @return
	 */
	public List<Ciudad> listarCiudades() {
		return dao.listarCiudades();
	}

	public List<MostrarSucursales> listarSucursal(String nombre) {
		return dao.listarSucursal(nombre);
	}
}