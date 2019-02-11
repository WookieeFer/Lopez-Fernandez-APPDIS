package view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import bussiness.LoginBussiness;

@ManagedBean
@ViewScoped
public class LoginBean {

	@Inject
	private LoginBussiness logBussiness;
	@Inject
	private FacesContext facesContext;

	private String correo;
	private String cedula;

	public LoginBussiness getLogBussiness() {
		return logBussiness;
	}

	public void setLogBussiness(LoginBussiness logBussiness) {
		this.logBussiness = logBussiness;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@PostConstruct
	public void init() {

	}

	public String login() {

		String c = logBussiness.Logueo(correo, cedula);
		System.out.println("login " + c);
		if (c != "no")
			return "blank.xhtml";
		else
			return "Login.xhtml";
	}
}
