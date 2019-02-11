package bussiness;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.LoginDao;
import model.Empleado;

@Stateless
public class LoginBussiness {

	@Inject
	private LoginDao logDao;

	/**
	 * Este metodo procesa el login de un Empleado
	 * 
	 * @return
	 */
	public String Logueo(String correo, String cedula) {
		Empleado e = logDao.BuscarLog(correo, cedula);
		System.out.println("logueo Bussiness " + e);
		if (e != null)
			return "si";
		else
			return "no";
	}

}
