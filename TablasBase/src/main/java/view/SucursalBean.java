package view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import bussiness.CiudadBusiness;
import bussiness.SucursalBusiness;
import model.Ciudad;
import model.Sucursal;;

@ManagedBean
@ViewScoped
public class SucursalBean {

	@Inject
	private SucursalBusiness sB;
	private Sucursal sucursal;
	private List<Sucursal> sucursales;
	@Inject
	private FacesContext facesContext;
	private boolean editing = false;
	private int codigo;
	private int codigoCiudad;

	@Inject
	private CiudadBusiness cB;
	private List<Ciudad> ciudades;

	@PostConstruct
	public void init() {
		sucursal = new Sucursal();
		sucursales = sB.listarSucursales();
		ciudades = cB.listarCiudades();
	}

	public void loadData() {

		System.out.println("load data " + codigo);
		if (codigo == 0)
			return;
		try {
			sucursal = sB.leer(codigo);
			editing = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String registrar() {
		try {
			if (editing) {
				Ciudad c = new Ciudad();
				c.setCodigoCiudad(codigoCiudad);
				sucursal.setCodigoCiudad(c);
				sB.actualizar(sucursal);
			} else {
				Ciudad c = new Ciudad();
				c.setCodigoCiudad(codigoCiudad);
				sucursal.setCodigoCiudad(c);
				sB.registrar(sucursal);
				return "crearSucursales?faces-redirect=true";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void eliminar(int codigo) {
		try {
			sB.eliminar(codigo);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Registro eliminado");
			facesContext.addMessage(null, m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String editar(Sucursal s) {
		editing = true;
		return "crearSucursales?faces-redirect=true&id=" + s.getCodigoSucursal();
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
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

	public int getCodigoCiudad() {
		return codigoCiudad;
	}

	public void setCodigoCiudad(int codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

}
