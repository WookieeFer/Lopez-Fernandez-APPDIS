package bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.SucursalDao;
import model.Sucursal;

@Stateless
public class SucursalBusiness {

	@Inject
	private SucursalDao dao;

	/**
	 * Este metodo registra una Sucursal
	 * 
	 * @return
	 */
	public void registrar(Sucursal s) throws Exception {
		Sucursal aux = dao.leer(s.getCodigoSucursal());
		if (aux != null)
			throw new Exception("Sucursal ya registrada");
		else
			dao.insertar(s);
	}

	/**
	 * Este metodo lee una Sucursal
	 * 
	 * @return
	 */
	public Sucursal leer(int codigo) throws Exception {
		Sucursal aux = dao.leer(codigo);
		if (aux == null)
			throw new Exception("Sucursal no registrada");
		else
			return aux;
	}

	/**
	 * Este metodo actualiza una Sucursal
	 * 
	 * @return
	 */
	public void actualizar(Sucursal su) throws Exception {
		Sucursal aux = dao.leer(su.getCodigoSucursal());
		if (aux == null)
			throw new Exception("Sucursal no registrada");
		else
			dao.actualizar(su);
	}

	/**
	 * Este metodo elimina una Sucursal
	 * 
	 * @return
	 */
	public void eliminar(int codigo) throws Exception {
		Sucursal aux = dao.leer(codigo);
		if (aux == null)
			throw new Exception("Sucursal no registrada");
		else
			dao.eliminar(codigo);
	}

	/**
	 * Este metodo lista una Sucursal
	 * 
	 * @return
	 */
	public List<Sucursal> listarSucursales() {
		return dao.listarSucursales();
	}
}