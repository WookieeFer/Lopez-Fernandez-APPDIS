package view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import bussiness.EmpleadoBusiness;
import bussiness.SucursalBusiness;
import model.Empleado;
import model.Sucursal;

@ManagedBean
@ViewScoped
public class EmpleadoBean {

	@Inject
	private EmpleadoBusiness eB;
	private Empleado empleado;
	private List<Empleado> empleados;
	@Inject
	private FacesContext facesContext;
	private boolean editing = false;
	private int codigo;
	private int codigoSucursal;

	@Inject
	private SucursalBusiness sB;
	private List<Sucursal> sucursales;

	@PostConstruct
	public void init() {
		empleado = new Empleado();
		empleados = eB.listarEmpleados();
		sucursales = sB.listarSucursales();
	}

	public void loadData() {

		System.out.println("load data " + codigo);
		if (codigo == 0)
			return;
		try {
			empleado = eB.leer(codigo);
			editing = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String registrar() {
		try {
			if (editing) {
				Sucursal s = new Sucursal();
				s.setCodigoSucursal(codigoSucursal);
				empleado.setCodigoSucursal(s);
				eB.actualizar(empleado);
			} else {
				Sucursal s = new Sucursal();
				s.setCodigoSucursal(codigoSucursal);
				empleado.setCodigoSucursal(s);
				eB.registrar(empleado);
				return "crearEmpleados?faces-redirect=true";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void eliminar(int codigo) {
		try {
			eB.eliminar(codigo);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Registro eliminado");
			facesContext.addMessage(null, m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String editar(Empleado e) {
		editing = true;
		return "crearEmpleados?faces-redirect=true&id=" + e.getCodigoEmpleado();
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}

	public int getCodigoSucursal() {
		return codigoSucursal;
	}

	public void setCodigoSucursal(int codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
