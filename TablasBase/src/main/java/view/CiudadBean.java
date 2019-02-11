package view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import bussiness.CiudadBusiness;
import model.Ciudad;

@ManagedBean
@ViewScoped
public class CiudadBean {

	@Inject
	private CiudadBusiness cB;
	private Ciudad ciudad;
	private List<Ciudad> ciudades;
	@Inject
	private FacesContext facesContext;
	private boolean editing = false;
	private int codigo;

	@PostConstruct
	public void init() {
		ciudad = new Ciudad();
		ciudades = cB.listarCiudades();
	}

	public void loadData() {

		System.out.println("load data " + codigo);
		if (codigo == 0)
			return;
		try {
			ciudad = cB.leer(codigo);
			editing = true;
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
	}

	public String registrar() {
		System.out.println("Entrando a Registrar");
		try {
			if (editing == true) {
				cB.actualizar(ciudad);
			} else {
				cB.registrar(ciudad);
				return "crearCiudades?faces-redirect=true";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void eliminar(int codigo) {
		try {
			cB.eliminar(codigo);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Registro eliminado");
			facesContext.addMessage(null, m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String editar(Ciudad c) {
		editing = false;
		return "crearCiudades?faces-redirect=true&id=" + c.getCodigoCiudad();
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
