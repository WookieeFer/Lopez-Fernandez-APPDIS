package bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.EmpleadoDao;
import model.Empleado;

@Stateless
public class EmpleadoBusiness {

	@Inject
	private EmpleadoDao dao;

	/**
	 * Este metodo registra un Empleado
	 * 
	 * @return
	 */
	public void registrar(Empleado emp) throws Exception {
		Empleado aux = dao.leer(emp.getCodigoEmpleado());
		if (aux != null)
			throw new Exception("Persona ya registrada");
		else
			dao.insertar(emp);
	}

	/**
	 * Este metodo lee un Empleado
	 * 
	 * @return
	 */
	public Empleado leer(int cedula) throws Exception {
		Empleado aux = dao.leer(cedula);
		if (aux == null)
			throw new Exception("Persona no registrada");
		else
			return aux;
	}

	/**
	 * Este metodo actualiza un Empleado
	 * 
	 * @return
	 */
	public void actualizar(Empleado emp) throws Exception {
		Empleado aux = dao.leer(emp.getCodigoEmpleado());
		if (aux == null)
			throw new Exception("Persona no registrada");
		else
			dao.actualizar(emp);
	}

	/**
	 * Este metodo elimina un Empleado
	 * 
	 * @return
	 */
	public void eliminar(int codigo) throws Exception {
		Empleado aux = dao.leer(codigo);
		if (aux == null)
			throw new Exception("Persona no registrada");
		else
			dao.eliminar(codigo);
	}

	/**
	 * Este metodo retorna una lista de Empleados
	 * 
	 * @return
	 */
	public List<Empleado> listarEmpleados() {
		return dao.listarEmpleados();
	}

}